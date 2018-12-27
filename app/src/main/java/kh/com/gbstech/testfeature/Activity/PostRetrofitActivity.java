package kh.com.gbstech.testfeature.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import kh.com.gbstech.testfeature.Adapter.AdapterRetrofitPost;
import kh.com.gbstech.testfeature.Model.RetrofitPost;
import kh.com.gbstech.testfeature.R;
import kh.com.gbstech.testfeature.helper.Data;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class PostRetrofitActivity extends AppCompatActivity {


    AdapterRetrofitPost adapter;
    private List<RetrofitPost> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GitHubService gitHubService = retrofit.create(GitHubService.class);

        final Call<List<RetrofitPost>> users = gitHubService.getPost();
        users.enqueue(new Callback<List<RetrofitPost>>() {
            @Override
            public void onResponse(@NonNull Call<List<RetrofitPost>> call, @NonNull Response<List<RetrofitPost>> response) {
                if (response.body() != null) {
                    Log.e("app", "onCreate: " + response.body().size());
                }
                userList = response.body();
                adapter.setData(userList);
//                DataHelper.newInstance().setPostToDataHelper(userList);
                    Data.getInstance().setPostToDataHelper(userList);
            }

            @Override
            public void onFailure(@NonNull Call<List<RetrofitPost>> call, @NonNull Throwable t) {
                Log.e("app", "onCreate: " + t.fillInStackTrace());
            }
        });
        adapter = new AdapterRetrofitPost();
        RecyclerView recyclerView = findViewById(R.id.lyt_rcv_retrofit);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



    }



    public interface GitHubService {
        @GET("posts")
        Call<List<RetrofitPost>> getPost();

    }

}
