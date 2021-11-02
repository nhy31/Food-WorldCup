package ddwu.mobile.finalproject.ma02_20180963;

import java.io.Serializable;

public class NaverRestaurantDto implements Serializable {

    private long _id;
    private String title;
    private String link;
    private String category;
    private String description;
    private String telephone;
    private String address;
    private String roadAddress;
    private Integer mapx;
    private Integer mapy;

    public NaverRestaurantDto() {}

    public NaverRestaurantDto(String title, String description, String telephone,
                              String address, String roadAddress, Integer mapx, Integer mapy) {
        this.title = title;
        this.description = description;
        this.telephone = telephone;
        this.address = address;
        this.roadAddress = roadAddress;
        this.mapx = mapx;
        this.mapy = mapy;
    }

    public NaverRestaurantDto(String title, String category, String description,
                              String telephone, String address, String roadAddress, Integer mapx, Integer mapy) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.telephone = telephone;
        this.address = address;
        this.roadAddress = roadAddress;
        this.mapx = mapx;
        this.mapy = mapy;
    }

    public NaverRestaurantDto(String title, String link, String category, String description,
                              String telephone, String address, String roadAddress, Integer mapx, Integer mapy) {
        this.title = title;
        this.link = link;
        this.category = category;
        this.description = description;
        this.telephone = telephone;
        this.address = address;
        this.roadAddress = roadAddress;
        this.mapx = mapx;
        this.mapy = mapy;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoadAddress() {
        return roadAddress;
    }

    public void setRoadAddress(String roadAddress) {
        this.roadAddress = roadAddress;
    }

    public Integer getMapx() {
        return mapx;
    }

    public void setMapx(Integer mapx) {
        this.mapx = mapx;
    }

    public Integer getMapy() {
        return mapy;
    }

    public void setMapy(Integer mapy) {
        this.mapy = mapy;
    }
}
