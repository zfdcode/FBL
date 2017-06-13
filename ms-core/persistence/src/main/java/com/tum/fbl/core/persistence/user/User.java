import java.util.Date;


public class User {

    private String user_id;

    private String user_name;

    private String user_password;

    private String user_email;

    private Date user_birthday;

    private int user_height;

    private int user_weight;

    private String user_display_name;

    private int user_role;

    private String user_address;

    public User(String user_id, String user_name, String user_password, String user_email, Date user_birthday, int user_height, int user_weight, String user_display_name, int user_role, String user_address) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_email = user_email;
        this.user_birthday = user_birthday;
        this.user_height = user_height;
        this.user_weight = user_weight;
        this.user_display_name = user_display_name;
        this.user_role = user_role;
        this.user_address = user_address;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public Date getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(Date user_birthday) {
        this.user_birthday = user_birthday;
    }

    public int getUser_height() {
        return user_height;
    }

    public void setUser_height(int user_height) {
        this.user_height = user_height;
    }

    public int getUser_weight() {
        return user_weight;
    }

    public void setUser_weight(int user_weight) {
        this.user_weight = user_weight;
    }

    public String getUser_display_name() {
        return user_display_name;
    }

    public void setUser_display_name(String user_display_name) {
        this.user_display_name = user_display_name;
    }

    public int getUser_role() {
        return user_role;
    }

    public void setUser_role(int user_role) {
        this.user_role = user_role;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }
}
