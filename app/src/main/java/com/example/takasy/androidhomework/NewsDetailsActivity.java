package com.example.takasy.androidhomework;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class NewsDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        final ImageView imageView = findViewById(R.id.details_image);
        final TextView titleView = findViewById(R.id.details_title);
        final TextView dateView = findViewById(R.id.details_date);
        final TextView textView = findViewById(R.id.details_text);
        final NewsItem newsItem = (NewsItem) getIntent().getParcelableExtra("newsItem");
        final Toolbar toolbar = findViewById(R.id.details_toolbar);

        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setTitle(newsItem.getCategory().getName());
        }

        Glide.with(this).load(newsItem.getImageUrl()).into(imageView);
        titleView.setText(newsItem.getTitle());
        dateView.setText(newsItem.getPublishDate().toString());
        textView.setText(newsItem.getFullText());

    }
}
