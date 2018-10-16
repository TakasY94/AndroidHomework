package com.example.takasy.androidhomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class NewsRecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

        RecyclerView list = findViewById(R.id.news_recycler);
        list.setAdapter(new NewsRecyclerAdapter(DataUtils.generateNews()));
        list.setLayoutManager(new LinearLayoutManager(this));
    }
}
