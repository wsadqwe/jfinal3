package nxu.it;

import com.jfinal.server.undertow.UndertowServer;
import nxu.it.config.MainConfig;

public class App {
    public static void main(String[] args) {
        UndertowServer.start(MainConfig.class, 8080, true);
    }
}
