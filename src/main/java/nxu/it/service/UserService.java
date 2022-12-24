package nxu.it.service;

import com.jfinal.kit.HashKit;
import com.jfinal.plugin.activerecord.ActiveRecordException;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import nxu.it.dao.DbHelper;
import nxu.it.pojo.User;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger("nxu.it");
    public boolean register(User user){
         // jdbi写法
         boolean success = false;
         Jdbi jdbi = DbHelper.JDBI;
         String insertSql = "insert into t_user(sno, name, password, mobile, department_id, grade, major)" +
                 "values (:sno, :name, :password, :mobile, :departmentId, :grade, :major)";
         try {
             jdbi.withHandle(handle -> handle.createUpdate(insertSql)
                     .bindBean(user)
                     .execute());
             success = true;
         }catch (Exception exception){
             LOGGER.error("插入用户记录出错, 原因:{}", exception.getMessage());
         }
         return success;

/*        boolean success = false;

        Record record = new Record();
        record.set("name", user.getName())
                .set("sno", user.getSno())
                .set("password", user.getPassword())
                .set("mobile", user.getMobile())
                .set("department_id", user.getDepartmentId())
                .set("major", user.getMajor())
                .set("grade", user.getGrade());
        try {
            user.save();
            success = true;
        } catch (ActiveRecordException exception) {
            LOGGER.error("插入用户记录出错, 原因:{}", exception.getMessage());
        }
        return success;
*/
    }

    public boolean checkLogin(String sno, String password) {
        String sql = "select count(*) from t_user where sno = ? and password = ?";
        Integer count = DbHelper.JDBI.withHandle(handle -> handle.createQuery(sql)
                .bind(0, sno)
                .bind(1, HashKit.sha256(password))
                .mapTo(Integer.class)
                .one());
        return count != 0;
    }
}
