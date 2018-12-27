package kh.com.gbstech.testfeature.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kh.com.gbstech.testfeature.Adapter.AdapterRetrofitPost;
import kh.com.gbstech.testfeature.R;
import kh.com.gbstech.testfeature.helper.Data;


/**
 * A simple {@link Fragment} subclass.
 */
public class PostFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_post, container, false);
        TextView textView = view.findViewById(R.id.text_view);

        RecyclerView recyclerView = view.findViewById(R.id.rcv_list_for_fragment_post);
        AdapterRetrofitPost adapterRetrofitPost = new AdapterRetrofitPost();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterRetrofitPost);
        adapterRetrofitPost.setData(Data.getInstance().getPosts());

        if (getArguments() != null) {
            textView.setText(getArguments().getString("s"));
        }
        return view;
    }


}
