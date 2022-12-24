package nxu.it.pojo;

import java.util.Arrays;

public class UserInfo {

    private String username;

    private String password;

    private String gender;

    private String hometown;

    private String[] hobby;

    public UserInfo() {
    }

    public UserInfo(String username, String password, String gender, String hometown, String[] hobby) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.hometown = hometown;
        this.hobby = hobby;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", hometown='" + hometown + '\'' +
                ", hobby=" + Arrays.toString(hobby) +
                '}';
    }
}
