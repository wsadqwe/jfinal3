package nxu.it.service;

import com.jfinal.plugin.activerecord.ActiveRecordException;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import nxu.it.dao.DbHelper;
import nxu.it.model.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PostService {

    private static final Logger LOGGER = LoggerFactory.getLogger("nxu.it");

    public boolean save(Post post){

        boolean success = false;
        try {
            post.save();
            success = true;
        } catch (ActiveRecordException e){
            LOGGER.error("向数据库插入文章记录{}时出错, 原因:{}", post, e.getMessage());
        }
        return success;
    }

    public List<Post> findByCategoryId(Long categoryId) {
        String findByCategoryIdSql = "select id, category_id, title, username, content, create_at" +
                " from t_post where category_id = ?";
        List<Post> posts = Post.dao.find(findByCategoryIdSql, categoryId);
        return posts;
    }

    public Page<Post> paginateByCategoryId(Long categoryId, int pageNumber, int pageSize) {
        String findByCategoryIdSelect = "select id, category_id, title, username, content, create_at ";
        String findByCategoryIdExceptSelect = "from t_post where category_id = ?";
        return Post.dao.paginate(pageNumber, pageSize, findByCategoryIdSelect, findByCategoryIdExceptSelect, categoryId);
    }

    public Post findById(long postId) {
        Post post = Post.dao.findById(postId);
        return post;
    }

    public boolean update(Post post) {

        boolean success = false;

        try{
            post.update();
            success = true;
        } catch (ActiveRecordException ex) {
            LOGGER.error("向数据库中更新文章记录{}时出错, 原因:{}", post, ex.getMessage());
        }
        return success;
    }

    public boolean checkAllowModify(Long postId, String username) {
        String checkSql = "select count(*) as cnt from t_post where id = ? and username = ?";
        Long cnt = Db.queryLong(checkSql, postId, username);
        return cnt != 0L;
    }

    public boolean deleteById(Long id){
        boolean success = false;
        try {
            Post.dao.deleteById(id);
            success = true;
        } catch (ActiveRecordException ex) {
            LOGGER.error("从数据库删除编号为{}的文章出错, 原因: {}", id, ex.getMessage());
        }
        return success;
    }
}
