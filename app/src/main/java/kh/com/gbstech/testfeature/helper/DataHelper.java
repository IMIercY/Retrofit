package kh.com.gbstech.testfeature.helper;

import java.util.ArrayList;
import java.util.List;

import kh.com.gbstech.testfeature.Model.RetrofitPost;

public class DataHelper {

    private static DataHelper dataHelper;
    private List<RetrofitPost> posts;

    private DataHelper() {
        this.posts = new ArrayList<>();
    }

    public static DataHelper newInstance() {
        if (dataHelper == null) {
            dataHelper = new DataHelper();
        }
        return dataHelper;
    }

    public void setPostToDataHelper(List<RetrofitPost> post) {
        this.posts.addAll(post);
     }

    public List<RetrofitPost> getPosts() {
        return this.posts;
    }

    public int getSize() {
        return this.posts.size();
    }
}
