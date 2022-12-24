//package nxu.it.pojo;
//
//import java.time.LocalDateTime;
//import java.util.Objects;
//
//public class Post {
//    private Integer id;
//    private Integer categoryId;
//    private String title;
//    private String content;
//    private String username;
//    private LocalDateTime createAt;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getCategoryId() {
//        return categoryId;
//    }
//
//    public void setCategoryId(Integer categoryId) {
//        this.categoryId = categoryId;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public LocalDateTime getCreateAt() {
//        return createAt;
//    }
//
//    public void setCreateAt(LocalDateTime createAt) {
//        this.createAt = createAt;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        Post post = (Post) o;
//        return Objects.equals(id, post.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
//
//    @Override
//    public String toString() {
//        return "Post{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                '}';
//    }
//}
