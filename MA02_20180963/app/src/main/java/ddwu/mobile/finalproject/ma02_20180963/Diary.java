package ddwu.mobile.finalproject.ma02_20180963;

import java.io.Serializable;

public class Diary  implements Serializable {

    private long _id;
    private String date;
    private String food;
    private String res;
    private int img;
    private String memo;

    public Diary() {}

    public Diary(String date, String food, String res, int img, String memo) {
        this.date = date;
        this.food = food;
        this.res = res;
        this.img = img;
        this.memo = memo;
    }

    public Diary(long _id, String date, String food, String res, int img, String memo) {
        this._id = _id;
        this.date = date;
        this.food = food;
        this.res = res;
        this.img = img;
        this.memo = memo;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
