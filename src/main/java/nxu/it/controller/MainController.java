package nxu.it.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.kit.Kv;
import nxu.it.filter.RequireLogin;
import nxu.it.pojo.User;
import nxu.it.pojo.UserInfo;
import nxu.it.security.Admin;
import nxu.it.security.Principal;
import nxu.it.service.UserService;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

@Path(value = "/", viewPath = "/")
public class MainController extends Controller {

    private static final String USER_SESSION_KRY = "user";
    public static final String LOGIN_REDIRECT_URL_KEY = "redirectUrl";

    private static UserService userService = new UserService();

    public void index() {
        renderHtml("<h2>It works!</h2>");
    }

    public void hello(){
        renderQrCode("你好",240,240);
    }

    public void bye(){
       renderQrCode("再见",240,240);
    }

    public void today(){

        LocalDateTime now = LocalDateTime.now();

        Kv jsonData = Kv.create()
                .set("year", now.getYear())
                .set("month", now.getMonthValue())
                .set("day", now.getDayOfMonth())
                .set("hour", now.getHour())
                .set("minute", now.getMinute())
                .set("weekday", now.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.CHINA));
        renderJson(jsonData);

    }

    public void register(){

        List<String> hometownList = List.of("北京", "天津", "银川", "河南", "上海", "湖南");
        List<String> hobbies = List.of("唱", "跳", "RAP", "篮球");
        set("hometownList", hometownList);
        set("hobbies", hobbies);
        renderFreeMarker("register.ftl");
    }


    public void doRegister(){
        String username = get("username");
        if (username == null || username.length() == 0){
            renderHtml("<h2>用户名为空</h2>");
            return;
        }
        String password = get("password");
        Integer gender = getInt("gender");
        String hometown = get("hometown");
        String[] hobbies = getParaValues("hobby");
        UserInfo userInfo = getBean(UserInfo.class, "", true);

        set("username",username);
        set("password", password);
        set("gender", gender);
        set("hometown", hometown);
        set("hobby", String.join(",", hobbies));


        renderTemplate("register-result.html");
    }

    public void login(){
        renderFreeMarker("login.ftl");
    }

    public void logout() {
        removeSessionAttr(USER_SESSION_KRY);
        redirect("/login");
    }

    public void loginCheck(){
        String username = get("username","");
        String password = get("password","");
        if(username.equals("admin") && password.equals("123456") || password.equals("nxu")){
            Principal principal = new Principal(username);
            setSessionAttr(USER_SESSION_KRY, principal);
            String redirectUrl =  getSessionAttr(LOGIN_REDIRECT_URL_KEY);
            if (redirectUrl != null && !redirectUrl.isBlank()) {
                redirect(redirectUrl);
            } else {
                set("sysUser", principal);
                renderFreeMarker("loginSuccess.ftl");
            }
            // setCookie("username", username, 30*60, true);

        }
        else {
            set("msg","用户名或密码错误, 请重新登录!");
            renderFreeMarker("login.ftl");
        }
    }

    public boolean checkLogin(){
        String username = getSessionAttr("username");
        if (username == null){
            redirect("/login");
            return false;
        }
        return true;
    }

    @Before(RequireLogin.class)
    public void main() {

        // 利用过滤器判断
        renderFreeMarker("main.ftl");
        //renderHtml("<h2 style=\"color:blue;\">" + "你好" + sysUser.getUsername() + "欢迎再次访问</h2>");

    }

    @Before(RequireLogin.class)
    public void test(){
        renderHtml("<h2>这是一个测试页面</h2>");
    }

    @Before(RequireLogin.class)
    @Admin
    public void admin() {
        renderHtml("管理员页面");
    }


    // 以下使用数据库进行登录注册功能的实现
    public void register1(){
        renderFreeMarker("register1.ftl");
    }

    public void doRegister1(){
        User user = getBean(User.class, "", true);
//        String sno = get("sno");
//        String name = get("name");
//        String password = get("password");
//        String major = get("major");
//        Integer grade = getInt("grade", 2022);
//        Integer departmentId = getInt("department_id", 0);
//        String mobile = get("mobile");

        boolean success = userService.register(user);
        String message = success? "注册成功":"注册失败";

        renderHtml(message);
    }

    public void login1(){
        renderFreeMarker("login1.ftl");
    }

    public void loginCheck1() {
        String username = get("username");
        String password = get("password");

        boolean success = userService.checkLogin(username, password);
        Kv result = Kv.create().set("success", success);
        String message = success?"登陆成功": "登录失败";
        result.set("message", message);
        if(success){
            Principal principal = new Principal(username);
            setSessionAttr(USER_SESSION_KRY, principal);
            redirect("http://localhost:8080/post/category/1");
        }
    }

    public void logout1() {
        removeSessionAttr(USER_SESSION_KRY);
        redirect("/login1");
    }
}
