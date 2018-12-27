package kh.com.gbstech.testfeature.Activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import kh.com.gbstech.testfeature.Adapter.AdapterRetrofitPostPhoto;
import kh.com.gbstech.testfeature.Model.RetrofitPhoto;
import kh.com.gbstech.testfeature.Model.RetrofitPost;
import kh.com.gbstech.testfeature.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class PostPhotoRetrofitActivity extends AppCompatActivity {

    private List<RetrofitPost> posts = new ArrayList<>();
    private List<RetrofitPhoto> photos = new ArrayList<>();
    private AdapterRetrofitPostPhoto adapterPostPhoto = new AdapterRetrofitPostPhoto();
    private List<Integer> data1s;
    private List<Integer> data2s;
    private List<Integer> dataMix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_photo);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MixViewType mixViewType = retrofit.create(MixViewType.class);
        final Call<List<RetrofitPost>> post = mixViewType.getPost();
        post.enqueue(new Callback<List<RetrofitPost>>() {
            @Override
            public void onResponse(@NonNull Call<List<RetrofitPost>> call, @NonNull Response<List<RetrofitPost>> response) {
                if (response.body() != null) {
                    Log.d("post", "onResponse: "+response.body().size()+"API");
                    posts = response.body();
                    adapterPostPhoto.setDataPost(posts);
//                    for (int i = 0; i < posts.size(); i++) {
//                        Log.i("post", "onResponse: "+posts.get(i).getId());
//                    }
                    data1s = new ArrayList<>();
                    data2s = new ArrayList<>();
                    for (int i = 0; i < 6; i++) {
                        data1s.add(i);
                    }
                    for (int i = 1; i <= 11; i+=2) {
                        data2s.add(i);
                    }
                    Log.d("post", "onResponse: "+"data1"+data1s);
                    Log.d("post", "onResponse: "+"data2"+data2s);
//                    data1s.addAll(data2s);
//                    Log.d("post", "onResponse: "+"mixD1&D2"+data1s);
                    //MixArray
                    dataMix = new ArrayList<>();
                    for (int i = 0; i < data1s.size()+data2s.size(); i++) {
                        if (i%2==0 && i/2 < data1s.size()) {
                            dataMix.add(i,data1s.get(i / 2));
                        } if (i % 2 == 1 && i / 2 < data2s.size()) {
                            dataMix.add(i, data2s.get(i / 2));
                            }

                    }
                    Log.d("post", "onResponse: "+dataMix);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<RetrofitPost>> call, @NonNull Throwable t) {
                Log.d("post", "onFailure: "+t.getMessage());
            }
        });

        Call<List<RetrofitPhoto>> photo = mixViewType.getPhotos();
        photo.enqueue(new Callback<List<RetrofitPhoto>>() {
            @Override
            public void onResponse(@NonNull Call<List<RetrofitPhoto>> call, @NonNull Response<List<RetrofitPhoto>> response) {
                if (response.body() != null) {
                    Log.d("photo", "onResponse: "+response.body().size());
                    photos = response.body().subList(0,100);
                    adapterPostPhoto.setDataPhoto(photos);
                    for (RetrofitPhoto data : photos) {
                        Log.d("photo", "onResponse: "+data.getId());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<RetrofitPhoto>> call, @NonNull Throwable t) {
                Log.d("photo", "onFailure: "+t.getMessage());
            }
        });

        RecyclerView recyclerView = findViewById(R.id.lyt_rcv_retrofit_post_photo);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterPostPhoto);
    }

    public interface MixViewType {
        @GET("posts")
        Call<List<RetrofitPost>> getPost();

        @GET("photos")
        Call<List<RetrofitPhoto>> getPhotos();
    }

}
