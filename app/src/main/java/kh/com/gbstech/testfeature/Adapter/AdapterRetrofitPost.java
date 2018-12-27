package kh.com.gbstech.testfeature.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kh.com.gbstech.testfeature.Model.RetrofitPost;
import kh.com.gbstech.testfeature.R;

public class AdapterRetrofitPost extends RecyclerView.Adapter<AdapterRetrofitPost.MyViewHolderRetrofit> {

    private List<RetrofitPost> adapters = new ArrayList<>();

//    public AdapterRetrofitPost(List<RetrofitPost> adapters) {
//        this.adapters = adapters;
//    }

    public void setData(List<RetrofitPost> adapters) {
        this.adapters.addAll(adapters);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolderRetrofit onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_holder_retrofit, viewGroup, false);
        return new MyViewHolderRetrofit(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderRetrofit myViewHolderRetrofit, int i) {
        RetrofitPost user = adapters.get(i);
        myViewHolderRetrofit.id.setText(String.valueOf(user.getId()));
        myViewHolderRetrofit.title.setText(user.getTitle());
        myViewHolderRetrofit.body.setText(user.getBody());
    }

    @Override
    public int getItemCount() {
        return adapters.size();
    }

    class MyViewHolderRetrofit extends RecyclerView.ViewHolder {
        TextView id;
        TextView title;
        TextView body;

        private MyViewHolderRetrofit(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
        }
    }
}
