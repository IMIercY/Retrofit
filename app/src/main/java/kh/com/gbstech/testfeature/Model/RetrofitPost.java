package kh.com.gbstech.testfeature.Model;

import com.google.gson.annotations.SerializedName;

public class RetrofitPost {

    @SerializedName("id")
    private Integer id;

    @SerializedName("title")
    private String title;

    @SerializedName("body")
    private String body;

    public RetrofitPost(Integer id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public RetrofitPost() {

    }


    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
