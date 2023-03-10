package nxu.it.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BasePost<M extends BasePost<M>> extends Model<M> implements IBean {

	/**
	 * 文章编号
	 * @param id
	 */
	public void setId(Long id) {
		set("id", id);
	}
	
	/**
	 * 文章编号
	 */
	public java.lang.Integer getId() {
		return getInt("id");
	}
	
	/**
	 * 文章分类编号
	 */
	public void setCategoryId(java.lang.Integer categoryId) {
		set("category_id", categoryId);
	}
	
	/**
	 * 文章分类编号
	 */
	public java.lang.Integer getCategoryId() {
		return getInt("category_id");
	}
	
	/**
	 * 文章标题
	 */
	public void setTitle(java.lang.String title) {
		set("title", title);
	}
	
	/**
	 * 文章标题
	 */
	public java.lang.String getTitle() {
		return getStr("title");
	}
	
	/**
	 * 作者编号
	 */
	public void setUsername(java.lang.String username) {
		set("username", username);
	}
	
	/**
	 * 作者编号
	 */
	public java.lang.String getUsername() {
		return getStr("username");
	}
	
	/**
	 * 文章内容
	 */
	public void setContent(java.lang.String content) {
		set("content", content);
	}
	
	/**
	 * 文章内容
	 */
	public java.lang.String getContent() {
		return getStr("content");
	}
	
	/**
	 * 发表时间
	 */
	public void setCreateAt(java.util.Date createAt) {
		set("create_at", createAt);
	}
	
	/**
	 * 发表时间
	 */
	public java.util.Date getCreateAt() {
		return getDate("create_at");
	}
	
}

