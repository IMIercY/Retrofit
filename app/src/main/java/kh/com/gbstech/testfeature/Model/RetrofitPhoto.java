package kh.com.gbstech.testfeature.Model;

import com.google.gson.annotations.SerializedName;

public class RetrofitPhoto {
    private Integer id;
    @SerializedName("url")
    private String photo;

    public RetrofitPhoto(Integer id, String url) {
        this.id = id;
        this.photo = url;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

//    public void setUrl(String url) {
//        this.photo = url;
//    }
}
