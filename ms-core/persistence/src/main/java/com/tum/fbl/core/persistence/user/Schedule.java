import java.util.Date;


public class Schedules {

    private String user_id;

    private int schedules_day_of_the_week;

    private Date schedules_opening_time;

    private Date schedules_closing_time;

    public Schedules(String user_id, int schedules_day_of_the_week, Date schedules_opening_time, Date schedules_closing_time) {
        this.user_id = user_id;
        this.schedules_day_of_the_week = schedules_day_of_the_week;
        this.schedules_opening_time = schedules_opening_time;
        this.schedules_closing_time = schedules_closing_time;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getSchedules_day_of_the_week() {
        return schedules_day_of_the_week;
    }

    public void setSchedules_day_of_the_week(int schedules_day_of_the_week) {
        this.schedules_day_of_the_week = schedules_day_of_the_week;
    }

    public Date getSchedules_opening_time() {
        return schedules_opening_time;
    }

    public void setSchedules_opening_time(Date schedules_opening_time) {
        this.schedules_opening_time = schedules_opening_time;
    }

    public Date getSchedules_closing_time() {
        return schedules_closing_time;
    }

    public void setSchedules_closing_time(Date schedules_closing_time) {
        this.schedules_closing_time = schedules_closing_time;
    }
}