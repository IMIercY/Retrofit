package kh.com.gbstech.testfeature.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import kh.com.gbstech.testfeature.Adapter.AdapterRetrofitPhoto;
import kh.com.gbstech.testfeature.Model.RetrofitPhoto;
import kh.com.gbstech.testfeature.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class PhotoRetrofitActivity extends AppCompatActivity {

    private List<RetrofitPhoto> photos = new ArrayList<>();
    private AdapterRetrofitPhoto adapterRetrofitPhoto = new AdapterRetrofitPhoto();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_retrofit);
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Interface service = retrofit.create(Interface.class);
        Call<List<RetrofitPhoto>> photo = service.getPhoto();
        photo.enqueue(new Callback<List<RetrofitPhoto>>() {
            @Override
            public void onResponse(@NonNull Call<List<RetrofitPhoto>> call, @NonNull Response<List<RetrofitPhoto>> response) {
                if (response.body() != null) {
                    Log.d("photo", "onResponse: "+response.body().size()+"items");
                }
                photos = response.body();
                Log.d("photo", "onResponse: "+photos.get(0).getPhoto());
                adapterRetrofitPhoto.setData(photos);
                //setDataToDataHelper
//                Data.getInstance().setUsers(photos);

            }

            @Override
            public void onFailure(@NonNull Call<List<RetrofitPhoto>> call, @NonNull Throwable t) {
                Log.d("photo", "onFailure: "+t.getMessage());
            }
        });

        RecyclerView recyclerView = findViewById(R.id.lyt_rcv_retrofit_photo);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterRetrofitPhoto);
    }

    public interface Interface {
        @GET("photos")
        Call<List<RetrofitPhoto>> getPhoto();
    }

}
