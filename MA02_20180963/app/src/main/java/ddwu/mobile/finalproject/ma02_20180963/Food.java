package ddwu.mobile.finalproject.ma02_20180963;

import java.io.Serializable;

public class Food implements Serializable {

    long _id;
    String foodName;
    int img;

    public Food() { }

    public Food(String foodName, int img) {
        this.foodName = foodName;
        this.img = img;
    }

    public Food(long _id, String foodName, int img) {
        this._id = _id;
        this.foodName = foodName;
        this.img = img;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
