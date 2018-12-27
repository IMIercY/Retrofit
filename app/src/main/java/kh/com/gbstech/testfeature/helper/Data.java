package kh.com.gbstech.testfeature.helper;

import java.util.ArrayList;
import java.util.List;

import kh.com.gbstech.testfeature.Model.RetrofitPost;
import kh.com.gbstech.testfeature.Model.RetrofitUser;

public class Data {

    private static final Data ourInstance = new Data();
    private List<RetrofitPost> posts;
    private List<RetrofitUser> users;

    private Data() {
        posts = new ArrayList<>();
        users = new ArrayList<>();
    }

    public static Data getInstance() {
        return ourInstance;
    }

    public void setPostToDataHelper(List<RetrofitPost> post) {
        this.posts.addAll(post);
    }

    public List<RetrofitPost> getPosts() {
        return this.posts;
    }

    public void setUsers(List<RetrofitUser> users) {
        this.users = users;
    }

    public List<RetrofitUser> getUsers() {
        return this.users;
    }

}
