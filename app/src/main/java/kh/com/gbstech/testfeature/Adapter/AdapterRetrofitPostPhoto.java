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
import kh.com.gbstech.testfeature.Model.RetrofitPost;
import kh.com.gbstech.testfeature.R;

public class AdapterRetrofitPostPhoto extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final static int firstView = 0;
    private final static int secondView = 1;
    private List<RetrofitPost> posts = new ArrayList<>();
    private List<RetrofitPhoto> photos = new ArrayList<>();

    private View inflateView(ViewGroup viewGroup,int layoutResource) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(layoutResource,
                viewGroup, false);
    }

    public void setDataPost (List<RetrofitPost> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    public void setDataPhoto (List<RetrofitPhoto> photos) {
        this.photos = photos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        switch (viewType) {
            case firstView:
                viewHolder = new ViewHolderPost(inflateView(viewGroup, R.layout.view_holder_retrofit));
                break;

            case secondView:
                viewHolder = new ViewHolderPhoto(inflateView(viewGroup, R.layout.view_holder_retrofit_photo));
                break;
            default:
                viewHolder = new ViewHolderPhoto(inflateView(viewGroup, R.layout.view_holder_retrofit_photo));
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderPost) {
            RetrofitPost post = posts.get(position);
            ((ViewHolderPost) holder).bindData(post);
        } else if (holder instanceof ViewHolderPhoto) {
            RetrofitPhoto photo = photos.get(position);
            ((ViewHolderPhoto) holder).id.setText(String.valueOf(photo.getId()));
            Picasso.get().load(photo.getPhoto()).into(((ViewHolderPhoto) holder).photo);
        }

    }

    @Override
    public int getItemViewType(int position) {
        if ( position % 2 == 0 ) {
            return firstView;
        }else {
            return secondView;
        }
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

     private class ViewHolderPost extends RecyclerView.ViewHolder {

         private TextView id, title, body;
        private ViewHolderPost(@NonNull View itemView) {
            super(itemView);
                id = itemView.findViewById(R.id.id);
                title = itemView.findViewById(R.id.title);
                body = itemView.findViewById(R.id.body);


        }

        private void bindData (RetrofitPost post) {
            id.setText(String.valueOf(post.getId()));
            title.setText(post.getTitle());
            body.setText(post.getBody());
        }
    }

    private class ViewHolderPhoto extends RecyclerView.ViewHolder {
        private TextView id;
        private ImageView photo;

        private ViewHolderPhoto(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id_photo);
            photo = itemView.findViewById(R.id.img_view_holder_photo);
        }
    }

}
