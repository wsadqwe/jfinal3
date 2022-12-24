package nxu.it.pojo;

import com.jfinal.core.paragetter.StringGetter;
import com.jfinal.kit.HashKit;
import com.jfinal.plugin.activerecord.Model;

import java.util.Objects;

public class User extends Model<User> {

    private String sno;

    private String password;

    private String name;

    private String mobile;

    private Integer grade;

    private String major;

    private Integer departmentId;

    public User() {
    }

    public User(String sno, String password, String name, String mobile, Integer grade, String major, Integer departmentId) {
        this.sno = sno;
        this.password = password;
        this.name = name;
        this.mobile = mobile;
        this.grade = grade;
        this.major = major;
        this.departmentId = departmentId;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = HashKit.sha256(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "User{" +
                "sno='" + sno + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", grade=" + grade +
                ", major='" + major + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(sno, user.sno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sno);
    }
}
