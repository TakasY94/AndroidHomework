package com.example.takasy.androidhomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ToolbarWidgetWrapper;


public class NewsRecyclerActivity extends AppCompatActivity {

    private final NewsRecyclerAdapter.OnItemClickListener clickListener = newsItem -> {
        NewsRecyclerAdapter.start(NewsRecyclerActivity.this, newsItem);

        //String clickMessage = newsItem.getTitle();
        //Toast.makeText(this, clickMessage, Toast.LENGTH_SHORT).show();
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        RecyclerView list = findViewById(R.id.news_recycler);
        final int columns = getResources().getInteger(R.integer.columns);
        list.setAdapter(new NewsRecyclerAdapter(this, DataUtils.generateNews(),clickListener ));
        list.setLayoutManager(new GridLayoutManager(this, columns));
    }
}
