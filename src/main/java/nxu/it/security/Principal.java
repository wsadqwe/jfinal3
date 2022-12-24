package nxu.it.security;

import java.io.Serializable;

public class Principal implements Serializable {

    private static final long serialVersionUID = 343423423423423L;

    private boolean admin = false;

    private String username;

    public Principal() {
    }

    public Principal(String username) {
        this.username = username;
    }

    public Principal(String username, boolean admin) {
        this(username);
        this.admin = admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAdmin(){
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
