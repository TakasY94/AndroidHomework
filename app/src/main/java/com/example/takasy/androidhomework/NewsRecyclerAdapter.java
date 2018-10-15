package com.example.takasy.androidhomework;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.ViewHolder> {

    private List<NewsItem> newsItemList;

    public NewsRecyclerAdapter (List<NewsItem> newsItemList){
        this.newsItemList = newsItemList;
    }

    @Override
    public int getItemCount() {
        return newsItemList.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_news, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(newsItemList.get(position));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private final ImageView newsPicture;
        private final TextView title;
        private final TextView date;
        private final TextView category;
        private final TextView previewText;

        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;

            newsPicture = cardView.findViewById(R.id.card_image);
            title = cardView.findViewById(R.id.news_title);
            date = cardView.findViewById(R.id.published_date);
            category = cardView.findViewById(R.id.news_category);
            previewText = cardView.findViewById(R.id.preview_text);
        }

        void bind(NewsItem newsItem){
            //TODO Download picture
            title.setText(newsItem.getTitle());
            date.setText(newsItem.getPublishDate().toString());
            category.setText(newsItem.getCategory().getName());
            previewText.setText(newsItem.getPreviewText());

        }
    }
}
