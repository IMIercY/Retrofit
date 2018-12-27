package kh.com.gbstech.testfeature.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import kh.com.gbstech.testfeature.Adapter.MyAdapter;
import kh.com.gbstech.testfeature.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.lyt_rcv);
        Button btn_posts = findViewById(R.id.btm_posts);
        Button btn_users = findViewById(R.id.btn_users);
        Button btn_cmts = findViewById(R.id.btn_cmts);
        Button btn_post_photo = findViewById(R.id.btn_post_photo);
        Button btn_view_pager = findViewById(R.id.btn_view_pager);

        btn_posts.setOnClickListener(this);
        btn_users.setOnClickListener(this);
        btn_cmts.setOnClickListener(this);
        btn_post_photo.setOnClickListener(this);
        btn_view_pager.setOnClickListener(this);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        MyAdapter adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btm_posts:
                startActivity(new Intent(getApplicationContext(), PostRetrofitActivity.class));
                break;
            case R.id.btn_users:
                startActivity(new Intent(getApplicationContext(), UserRetrofitActivity.class));
                break;
            case R.id.btn_cmts:
                startActivity(new Intent(getApplicationContext(), PhotoRetrofitActivity.class));
                break;
            case R.id.btn_post_photo:
                startActivity(new Intent(getApplicationContext(), PostPhotoRetrofitActivity.class));
                break;
            case R.id.btn_view_pager:
                startActivity(new Intent(getApplicationContext(), ViewPagerActivity.class));
                break;
        }
    }
}
