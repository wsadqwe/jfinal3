package nxu.it.filter;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import nxu.it.security.Admin;
import nxu.it.security.Principal;
import nxu.it.security.SecurityUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class RequireLogin implements Interceptor {

    public static final String USER_SESSION_KEY = "user";
    public static final String LOGIN_REDIRECT_URL_KEY = "redirectUrl";

    @Override
    public void intercept(Invocation invocation) {
        Controller controller = invocation.getController();
        Optional<Principal> principal = SecurityUtil.getCurrentPrincipal(controller);
        Admin adminAnnotation = invocation.getMethod().getAnnotation(Admin.class);
        if(principal.isEmpty()){
            HttpServletRequest request = controller.getRequest();
            String requestURL = request.getRequestURL().toString();
            controller.setSessionAttr(LOGIN_REDIRECT_URL_KEY, requestURL);
            controller.redirect("/login1");
            return;
        }else if(adminAnnotation != null && !principal.get().isAdmin()){
            controller.renderHtml("<h2 style=\"color:red;\">您无权访问!</h2>");
            return;
        }
        invocation.invoke();
    }
}
