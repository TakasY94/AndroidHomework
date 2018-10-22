package com.example.takasy.androidhomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NewsDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        final TextView textView = findViewById(R.id.testText);
        final NewsItem newsItem = (NewsItem) getIntent().getParcelableExtra("newsItem");
        final String bodyMessage = newsItem.getFullText();
        textView.setText(bodyMessage);

    }
}
