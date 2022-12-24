package nxu.it.security;

import com.jfinal.core.Controller;

import java.util.Optional;

import static nxu.it.Constants.USER_SESSION_KEY;

public class SecurityUtil {
    public static Optional<Principal> getCurrentPrincipal(Controller controller) {
        Principal principal = controller.getSessionAttr(USER_SESSION_KEY);
        return Optional.ofNullable(principal);
    }
}
