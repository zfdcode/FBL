import java.util.Date;

public class Meal {

    private String meal_id;

    private String meal_name;

    private byte[] meal_image;

    private float meal_rating;

    private int meal_helath_value;

    private Date meal_preparation_time;

    private float meal_energy;

    private float meal_protein;

    private float meal_total_fat;

    private float meal_saturated;

    private float meal_total_carbohydrate;

    private float meal_sugar;

    private float meal_sodium;

    public Meal(String meal_id, String meal_name, byte[] meal_image, float meal_rating, int meal_helath_value, Date meal_preparation_time, float meal_energy, float meal_protein, float meal_total_fat, float meal_saturated, float meal_total_carbohydrate, float meal_sugar, float meal_sodium) {
        this.meal_id = meal_id;
        this.meal_name = meal_name;
        this.meal_image = meal_image;
        this.meal_rating = meal_rating;
        this.meal_helath_value = meal_helath_value;
        this.meal_preparation_time = meal_preparation_time;
        this.meal_energy = meal_energy;
        this.meal_protein = meal_protein;
        this.meal_total_fat = meal_total_fat;
        this.meal_saturated = meal_saturated;
        this.meal_total_carbohydrate = meal_total_carbohydrate;
        this.meal_sugar = meal_sugar;
        this.meal_sodium = meal_sodium;
    }

    public String getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(String meal_id) {
        this.meal_id = meal_id;
    }

    public String getMeal_name() {
        return meal_name;
    }

    public void setMeal_name(String meal_name) {
        this.meal_name = meal_name;
    }

    public byte[] getMeal_image() {
        return meal_image;
    }

    public void setMeal_image(byte[] meal_image) {
        this.meal_image = meal_image;
    }

    public float getMeal_rating() {
        return meal_rating;
    }

    public void setMeal_rating(float meal_rating) {
        this.meal_rating = meal_rating;
    }

    public int getMeal_helath_value() {
        return meal_helath_value;
    }

    public void setMeal_helath_value(int meal_helath_value) {
        this.meal_helath_value = meal_helath_value;
    }

    public Date getMeal_preparation_time() {
        return meal_preparation_time;
    }

    public void setMeal_preparation_time(Date meal_preparation_time) {
        this.meal_preparation_time = meal_preparation_time;
    }

    public float getMeal_energy() {
        return meal_energy;
    }

    public void setMeal_energy(float meal_energy) {
        this.meal_energy = meal_energy;
    }

    public float getMeal_protein() {
        return meal_protein;
    }

    public void setMeal_protein(float meal_protein) {
        this.meal_protein = meal_protein;
    }

    public float getMeal_total_fat() {
        return meal_total_fat;
    }

    public void setMeal_total_fat(float meal_total_fat) {
        this.meal_total_fat = meal_total_fat;
    }

    public float getMeal_saturated() {
        return meal_saturated;
    }

    public void setMeal_saturated(float meal_saturated) {
        this.meal_saturated = meal_saturated;
    }

    public float getMeal_total_carbohydrate() {
        return meal_total_carbohydrate;
    }

    public void setMeal_total_carbohydrate(float meal_total_carbohydrate) {
        this.meal_total_carbohydrate = meal_total_carbohydrate;
    }

    public float getMeal_sugar() {
        return meal_sugar;
    }

    public void setMeal_sugar(float meal_sugar) {
        this.meal_sugar = meal_sugar;
    }

    public float getMeal_sodium() {
        return meal_sodium;
    }

    public void setMeal_sodium(float meal_sodium) {
        this.meal_sodium = meal_sodium;
    }
}