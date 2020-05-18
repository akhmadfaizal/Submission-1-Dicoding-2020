package com.afi.bfaa.submission_1_githubuser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_USER = "extra_user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setTitle("Detail User");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        TextView tvDetName = findViewById(R.id.tv_det_name_user);
        ImageView imgDetPhoto = findViewById(R.id.img_det_photo);
        TextView tvDetUsername = findViewById(R.id.tv_det_username);
        TextView tvDetRepository = findViewById(R.id.tv_det_repository);
        TextView tvDetCompany = findViewById(R.id.tv_det_company);
        TextView tvDetFollowers = findViewById(R.id.tv_det_followers);
        TextView tvDetFollowing = findViewById(R.id.tv_det_following);
        TextView tvDetLocation = findViewById(R.id.tv_det_location);

        User user = getIntent().getParcelableExtra(EXTRA_USER);

        Glide.with(this)
                .load(user.getPhoto())
                .into(imgDetPhoto);
        tvDetUsername.setText(user.getUsername());
        tvDetName.setText("Name : " + user.getName());
        tvDetLocation.setText("Location : " + user.getLocation());
        tvDetCompany.setText("Company : " + user.getCompany());
        tvDetRepository.setText(user.getRepository());
        tvDetFollowers.setText(user.getFollowers());
        tvDetFollowing.setText(user.getFollowing());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        return true;
    }
}
