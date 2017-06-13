public class Wearable {

    private String device_id;

    private int divice_type;

    private Date connection_time;

    private Date exit_time;

    private String device_user_id;

    private String device_user_password;

    public Wearable(String device_id, int divice_type, Date connection_time, Date exit_time, String device_user_id, String device_user_password) {
        this.device_id = device_id;
        this.divice_type = divice_type;
        this.connection_time = connection_time;
        this.exit_time = exit_time;
        this.device_user_id = device_user_id;
        this.device_user_password = device_user_password;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public int getDivice_type() {
        return divice_type;
    }

    public void setDivice_type(int divice_type) {
        this.divice_type = divice_type;
    }

    public Date getConnection_time() {
        return connection_time;
    }

    public void setConnection_time(Date connection_time) {
        this.connection_time = connection_time;
    }

    public Date getExit_time() {
        return exit_time;
    }

    public void setExit_time(Date exit_time) {
        this.exit_time = exit_time;
    }

    public String getDevice_user_id() {
        return device_user_id;
    }

    public void setDevice_user_id(String device_user_id) {
        this.device_user_id = device_user_id;
    }

    public String getDevice_user_password() {
        return device_user_password;
    }

    public void setDevice_user_password(String device_user_password) {
        this.device_user_password = device_user_password;
    }
}