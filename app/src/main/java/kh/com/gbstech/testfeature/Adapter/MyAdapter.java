package kh.com.gbstech.testfeature.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import kh.com.gbstech.testfeature.R;


public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int type1 = 1;
    private static final int type2 = 2;
    private static final int type3 = 3;


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder ;
        switch (viewType) {
            case type1:
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_holder, viewGroup, false);
                viewHolder = new myViewHolder(view);
                break;
            case type2:
                View view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_holder2, viewGroup, false);
                viewHolder = new myViewHolder2(view2);
                break;
            case type3:
                View view3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_holder3, viewGroup, false);
                viewHolder = new myViewHolder3(view3);
                break;
            default:
                View view4 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_holder, viewGroup, false);
                viewHolder = new myViewHolder(view4);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {

    }


    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public int getItemViewType(int position) {
        if (position ==1 || position == 4) {
            return type3;
        }
        else if (position % 2 == 0) {
            return type2;
        } else {
            return type1;
        }
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        private myViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_view_holder);
        }
    }

    class myViewHolder2 extends RecyclerView.ViewHolder {

        ImageView imageView2;

        private myViewHolder2(@NonNull View itemView) {
            super(itemView);
            imageView2 = itemView.findViewById(R.id.image2);
        }
    }

    class myViewHolder3 extends RecyclerView.ViewHolder {

        ImageView imageView3;
        private myViewHolder3(@NonNull View itemView) {
            super(itemView);
            imageView3 = itemView.findViewById(R.id.image3);
        }
    }



}
