package nxu.it.security;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import nxu.it.service.PostService;

import java.util.Optional;

public class AllowModify implements Interceptor {

    private static PostService postService = new PostService();

    @Override
    public void intercept(Invocation invocation) {
        Controller controller = invocation.getController();
        Optional<Principal> principalOpt = SecurityUtil.getCurrentPrincipal(controller);
        Principal principal = principalOpt.get();
        Long postId = controller.getParaToLong(0, 0L);
        if (postId == 0L) {
            postId = controller.getParaToLong("id",0L);
        }
        if(!postService.checkAllowModify(postId, principal.getUsername())){
            controller.renderHtml("<h2 style=\"color: red;\">您无权更新文章</h2>");
        } else {
            invocation.invoke();
        }
    }
}
