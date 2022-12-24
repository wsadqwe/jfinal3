package nxu.it.controller;

import cn.hutool.log.Log;
import com.google.zxing.oned.OneDimensionalCodeWriter;
import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.plugin.activerecord.Page;
import nxu.it.filter.RequireLogin;
import nxu.it.model.Category;
import nxu.it.model.Post;
import nxu.it.security.AllowModify;
import nxu.it.security.Principal;
import nxu.it.security.SecurityUtil;
import nxu.it.service.CategoryService;
import nxu.it.service.PostService;
import nxu.it.validator.PostFormValidator;

import java.util.List;
import java.util.Optional;

@Path(value = "/post", viewPath = "/post")
@Before(RequireLogin.class)
public class PostController extends Controller {

    private PostService postService = new PostService();
    private CategoryService categoryService = new CategoryService();

    public void publish(){
        List<Category> allCategories = categoryService.findAll();
        set("allCategories", allCategories);
        renderFreeMarker("publish.ftl");
    }

    @Before(PostFormValidator.class)
    public void save(){
        String title = get("title", "");
        Integer categoryId = getInt("category_id", 0);
        String content = get("content", "");

        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setCategoryId(categoryId);
        Optional<Principal> currentPrincipal = SecurityUtil.getCurrentPrincipal(this);
        currentPrincipal.ifPresent(principal -> post.setUsername(principal.getUsername()));
        boolean success = postService.save(post);
        String message = success?"发布成功": "发布失败";
        set("message", message);
        String redirectUrl = success ? "/post/view/" + post.getId() : "/post/category/" + categoryId;
        set("redirectUrl", redirectUrl);
        renderFreeMarker("operate-result.ftl");
    }

    @ActionKey("/post/category")
    @Clear(RequireLogin.class)
    public void listByCategory(){
        Long categoryId = getParaToLong(0, 0L);
        Integer page = getParaToInt("page", 1);
        Page<Post> postPage = postService.paginateByCategoryId(categoryId, page, 5);
        set("postPage", postPage);
        renderFreeMarker("list-by-category.ftl");
    }

    @Clear(RequireLogin.class)
    public void view() {
        Long postId = getParaToLong(0, 0L);
        Post post = postService.findById(postId);
        if(post == null) {
            set("message", "查看的文章不存在！");
            set("redirectUrl", "/post/category/1");
            renderFreeMarker("operate-result.ftl");
            return;
        }

        set("post", post);
        renderFreeMarker("view.ftl");
    }

    @Before(AllowModify.class)
    public void edit(){
        Long postId = getParaToLong(0, 0L);
        Post post = postService.findById(postId);
        if(post == null) {
            set("message", "要编辑的文章不存在！");
            set("redirectUrl", "/post/category/1");
            renderFreeMarker("operate-result.ftl");
            return;
        }
        List<Category> allCategories = categoryService.findAll();
        set("allCategories", allCategories);
        set("post", post);
        renderFreeMarker("edit.ftl");
    }

    @Before({AllowModify.class, PostFormValidator.class})
    public void update(){
        String title = get("title", "");
        Integer categoryId = getInt("category_id", 0);
        String content = get("content", "");
        Long id = getParaToLong("id", 0L);

        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setContent(content);
        post.setCategoryId(categoryId);
        Optional<Principal> currentPrincipal = SecurityUtil.getCurrentPrincipal(this);
        currentPrincipal.ifPresent(principal -> post.setUsername(principal.getUsername()));
        boolean success = postService.update(post);
        String message = success?"更新成功": "更新失败";
        set("message", message);
        set("redirectUrl", "/post/view/" + id);
        renderFreeMarker("operate-result.ftl");
    }

    @Before(AllowModify.class)
    public void delete(){
        Long postId = getParaToLong(0, 0L);
        boolean success = postService.deleteById(postId);
        String message = success ? "删除成功" : "删除失败";
        set("message", message);
        set("redirectUrl", "/post/category/1");
        renderFreeMarker("operate-result.ftl");
    }
}
