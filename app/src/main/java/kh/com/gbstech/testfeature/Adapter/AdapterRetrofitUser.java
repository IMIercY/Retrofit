package kh.com.gbstech.testfeature.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kh.com.gbstech.testfeature.Model.RetrofitUser;
import kh.com.gbstech.testfeature.R;

public class AdapterRetrofitUser extends RecyclerView.Adapter<AdapterRetrofitUser.ViewhoderUser> {


    private List<RetrofitUser> users = new ArrayList<>();

    public void setData (List<RetrofitUser> users) {
        this.users = users;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ViewhoderUser onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_holder_retrofit_user, viewGroup, false);
        return new ViewhoderUser(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewhoderUser viewhoderUser, int i) {
        RetrofitUser user = users.get(i);
        viewhoderUser.id.setText(String.valueOf(user.getId()));
        viewhoderUser.name.setText(user.getName());
        viewhoderUser.username.setText(user.getUsername());
        viewhoderUser.email.setText(user.getEmail());
        viewhoderUser.streett.setText(user.getAddress().getStreet());
        viewhoderUser.suite.setText(user.getAddress().getSuite());
        viewhoderUser.city.setText(user.getAddress().getCity());
        viewhoderUser.zipcode.setText(user.getAddress().getZipcode());
        viewhoderUser.lat.setText(user.getAddress().getGeo().getLat());
        viewhoderUser.lng.setText(user.getAddress().getGeo().getLng());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class ViewhoderUser extends RecyclerView.ViewHolder {
        private TextView id, name, username, email, streett, suite, city, zipcode, lat, lng;

        private ViewhoderUser(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id_user);
            name = itemView.findViewById(R.id.name);
            username = itemView.findViewById(R.id.user_name);
            email = itemView.findViewById(R.id.email);
            streett = itemView.findViewById(R.id.street);
            suite = itemView.findViewById(R.id.suite);
            city = itemView.findViewById(R.id.city);
            zipcode = itemView.findViewById(R.id.zipcode);
            lat = itemView.findViewById(R.id.lat);
            lng = itemView.findViewById(R.id.lng);
        }
    }

}
