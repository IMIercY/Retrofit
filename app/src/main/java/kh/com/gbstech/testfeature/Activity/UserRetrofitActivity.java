package kh.com.gbstech.testfeature.Activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import kh.com.gbstech.testfeature.Adapter.AdapterRetrofitUser;
import kh.com.gbstech.testfeature.Model.RetrofitUser;
import kh.com.gbstech.testfeature.R;
import kh.com.gbstech.testfeature.helper.Data;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class UserRetrofitActivity extends AppCompatActivity {

    private List<RetrofitUser> users = new ArrayList<>();
    private AdapterRetrofitUser adapterRetrofitUser = new AdapterRetrofitUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_retrofit);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MercyService mercyService = retrofit.create(MercyService.class);
        final Call<List<RetrofitUser>> user  = mercyService.getUsers();
        user.enqueue(new Callback<List<RetrofitUser>>() {
            @Override
            public void onResponse(@NonNull Call<List<RetrofitUser>> call, @NonNull Response<List<RetrofitUser>> response) {
                if (response.body() != null) {
                    Log.d("user", "onResponse: "+response.body().size());
                }

                users = response.body();
                Log.d("app", "onResponse: " + users.get(0).getAddress().getGeo().getLat());

                adapterRetrofitUser.setData(users);
                //setDataToDataHelper
                Data.getInstance().setUsers(users);

            }

            @Override
            public void onFailure(@NonNull Call<List<RetrofitUser>> call, @NonNull Throwable t) {
                Log.d("error", "onFailure: "+t.getMessage());
            }
        });

        RecyclerView recyclerView = findViewById(R.id.lyt_rcv_retrofit_user);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterRetrofitUser);

    }


    public interface MercyService {
        @GET("users")
        Call<List<RetrofitUser>> getUsers();


    }
}

