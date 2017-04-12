package com.joshellen.thebeerguru;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Josh on 3/7/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private Context context;
    private List<BreweryData> brewery_data;

    public CustomAdapter(Context context, List<BreweryData> brewery_data) {
        this.context = context;
        this.brewery_data = brewery_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_brewery, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.rating.setRating(brewery_data.get(position).getRating());
//        holder.yearEstablished.setText("Since "+brewery_data.get(position).getYear_established());
        holder.name.setText(brewery_data.get(position).getName());
        Glide.with(context).load(brewery_data.get(position).getImage_link()).into(holder.imageView);
        holder.city.setText(brewery_data.get(position).getCity());
        holder.state.setText(brewery_data.get(position).getState());
        holder.website.setText(brewery_data.get(position).getWebsite());
        holder.phone.setText(brewery_data.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return brewery_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public RatingBar rating;
//        public TextView yearEstablished;
        public TextView name;
        public ImageView imageView;
        public TextView city;
        public TextView state;
        public TextView website;
        public TextView phone;

        public ViewHolder(View itemView) {
            super(itemView);

            rating = (RatingBar) itemView.findViewById(R.id.rb_brewery_rating);
//            yearEstablished = (TextView) itemView.findViewById(R.id.tv_brewery_established);
            name = (TextView) itemView.findViewById(R.id.tv_brewery_name);
            imageView = (ImageView) itemView.findViewById(R.id.iv_brewery_logo);
            city = (TextView) itemView.findViewById(R.id.tv_brewery_city);
            state = (TextView) itemView.findViewById(R.id.tv_brewery_state);
            website = (TextView) itemView.findViewById(R.id.tv_brewery_website);
            phone =  (TextView) itemView.findViewById(R.id.tv_phone);

            // Displays a toast for the specific card that is clicked
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Toast.makeText(v.getContext(),
                            ("You clicked " + brewery_data.get(getAdapterPosition()).getName()),
                            Toast.LENGTH_LONG)
                            .show();
                }
            });
            // Displays a toast for the specific card image that is clicked
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Toast.makeText(v.getContext(),
                            ("You clicked " + brewery_data.get(getAdapterPosition()).getName()),
                            Toast.LENGTH_LONG)
                            .show();
                }
            });
        }
    }
}
