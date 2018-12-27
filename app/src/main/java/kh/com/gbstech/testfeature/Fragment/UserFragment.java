package kh.com.gbstech.testfeature.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kh.com.gbstech.testfeature.Adapter.AdapterRetrofitUser;
import kh.com.gbstech.testfeature.R;
import kh.com.gbstech.testfeature.helper.Data;

public class UserFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rcv_list_for_fragment_user);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        AdapterRetrofitUser adapterRetrofitUser = new AdapterRetrofitUser();
        adapterRetrofitUser.setData(Data.getInstance().getUsers());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterRetrofitUser);
        return view;
    }
}
