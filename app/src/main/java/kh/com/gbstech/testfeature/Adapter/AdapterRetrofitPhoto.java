package kh.com.gbstech.testfeature.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import kh.com.gbstech.testfeature.Model.RetrofitPhoto;
import kh.com.gbstech.testfeature.R;

public class AdapterRetrofitPhoto extends RecyclerView.Adapter<AdapterRetrofitPhoto.ViewHolderPhoto> {

    private List<RetrofitPhoto> photos = new ArrayList<>();

    public void setData (List<RetrofitPhoto> photos) {
        this.photos = photos;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolderPhoto onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_holder_retrofit_photo, viewGroup, false);
        return new ViewHolderPhoto(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPhoto viewHolderPhoto, int i) {
        RetrofitPhoto photo = photos.get(i);
        viewHolderPhoto.id.setText(String.valueOf(photo.getId()));
        Picasso.get().load(photo.getPhoto()).fit().into(viewHolderPhoto.photo);
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

      class ViewHolderPhoto extends RecyclerView.ViewHolder {

        private TextView id;
        private ImageView photo;
        private ViewHolderPhoto(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id_photo);
            photo = itemView.findViewById(R.id.img_view_holder_photo);
        }
    }
}
