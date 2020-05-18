package com.afi.bfaa.submission_1_githubuser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<User> users = new ArrayList<>();

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public UserAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        }
        ViewHolder viewHolder = new ViewHolder(itemView);

        User users = (User) getItem(position);
        viewHolder.bind(users);
        return itemView;
    }

    public class ViewHolder{
        private TextView txtName;
        private TextView txtLocation;
        private CircleImageView imgPhoto;

        ViewHolder(View view){
            txtName = view.findViewById(R.id.tv_name_user);
            txtLocation =  view.findViewById(R.id.tv_location_user);
            imgPhoto = view.findViewById(R.id.img_photo_user);
        }
        void bind(User user){
            txtName.setText(user.getName());
            txtLocation.setText(user.getLocation());
            imgPhoto.setImageResource(user.getPhoto());
        }
    }
}
