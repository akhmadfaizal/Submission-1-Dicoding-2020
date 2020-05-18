package com.afi.bfaa.submission_1_githubuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private UserAdapter userAdapter;
    private String[] dataUser;
    private String[] dataLocation;
    private String[] dataUsername;
    private String[] dataCompany;
    private String[] dataRepository;
    private String[] dataFollowers;
    private String[] dataFollowing;
    private TypedArray dataPhoto;
    private ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Github User");

        ListView listView = findViewById(R.id.lv_user);
        userAdapter = new UserAdapter(this);
        listView.setAdapter(userAdapter);
        
        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mIntent = new Intent(MainActivity.this, DetailActivity.class);
                mIntent.putExtra(DetailActivity.EXTRA_USER, users.get(position));
                startActivity(mIntent);
            }
        });
    }


    private void prepare() {
        dataUser = getResources().getStringArray(R.array.name);
        dataLocation = getResources().getStringArray(R.array.location);
        dataPhoto = getResources().obtainTypedArray(R.array.avatar);
        dataUsername = getResources().getStringArray(R.array.username);
        dataRepository = getResources().getStringArray(R.array.repository);
        dataCompany = getResources().getStringArray(R.array.company);
        dataFollowers = getResources().getStringArray(R.array.followers);
        dataFollowing = getResources().getStringArray(R.array.following);
    }
    private void addItem() {
        users = new ArrayList<>();

        for (int i = 0; i < dataUser.length; i++){
          User user = new User();
          user.setName(dataUser[i]);
          user.setPhoto(dataPhoto.getResourceId(i, -1));
          user.setLocation(dataLocation[i]);
          user.setUsername(dataUsername[i]);
          user.setRepository(dataRepository[i]);
          user.setCompany(dataCompany[i]);
          user.setFollowers(dataFollowers[i]);
          user.setFollowing(dataFollowing[i]);
          users.add(user);
        }
        userAdapter.setUsers(users);
    }

}
