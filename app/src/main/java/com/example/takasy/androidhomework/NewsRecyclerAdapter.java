package com.example.takasy.androidhomework;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.ViewHolder> {

    private final List<NewsItem> newsItemList;
    private final RequestManager imageLoader;
    private final OnItemClickListener clickListener;
    private final LayoutInflater inflater;

    public NewsRecyclerAdapter(Context context, List<NewsItem> newsItemList, OnItemClickListener clickListener){
        this.newsItemList = newsItemList;
        this.inflater = LayoutInflater.from(context);
        this.clickListener = clickListener;

        RequestOptions imageOption = new RequestOptions()
                .centerCrop();
        this.imageLoader = Glide.with(context).applyDefaultRequestOptions(imageOption);
    }

    @Override
    public int getItemCount() {
        return newsItemList.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.card_item_news, parent, false), clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(newsItemList.get(position));
    }

    public interface OnItemClickListener {
        void onItemClick(NewsItem newsItem);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private final ImageView newsPicture;
        private final TextView title;
        private final TextView date;
        private final TextView category;
        private final TextView previewText;

        public ViewHolder(View cardView, final OnItemClickListener listener){
            super(cardView);
            cardView.setOnClickListener(view -> {
                int position = getAdapterPosition();
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(newsItemList.get(position));
                }
            });

            newsPicture = cardView.findViewById(R.id.card_image);
            title = cardView.findViewById(R.id.news_title);
            date = cardView.findViewById(R.id.published_date);
            category = cardView.findViewById(R.id.news_category);
            previewText = cardView.findViewById(R.id.preview_text);
        }

        void bind(NewsItem newsItem){
            imageLoader.load(newsItem.getImageUrl()).into(newsPicture);
            title.setText(newsItem.getTitle());
            date.setText(newsItem.getPublishDate().toString());
            category.setText(newsItem.getCategory().getName());
            previewText.setText(newsItem.getPreviewText());

        }
    }

    public static void start(Activity activity, NewsItem newsItem) {
        Intent intent = new Intent(activity, NewsDetailsActivity.class);
        intent.putExtra("newsItem", newsItem);
        activity.startActivity(intent);
    }
}
