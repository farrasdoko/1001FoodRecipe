package com.farrasabiyyu12.a1001foodrecipe.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.farrasabiyyu12.a1001foodrecipe.DetailActivity;
import com.farrasabiyyu12.a1001foodrecipe.Model.ResultsItem;
import com.farrasabiyyu12.a1001foodrecipe.R;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    List<ResultsItem> resultsItems;
    Context context;

    public CustomAdapter(List<ResultsItem> resultsItems, Context context) {
        this.resultsItems = resultsItems;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_result, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        ResultsItem item = resultsItems.get(i);
        myViewHolder.tv_title_rv.setText(item.getTitle());
        myViewHolder.tv_ingredients_rv.setText(item.getIngredients());
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DetailActivity.class)
                        .putExtra(resultsItems.get(i).getHref(), "web_url"));
            }
        });

        try {
            Glide.with(context)
                    .load(item.getThumbnail())
                    .into(myViewHolder.img_thumbnail_rv);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return resultsItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_title_rv, tv_ingredients_rv;
        ImageView img_thumbnail_rv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title_rv = itemView.findViewById(R.id.tv_title_rv);
            tv_ingredients_rv = itemView.findViewById(R.id.tv_ingredients_rv);
            img_thumbnail_rv = itemView.findViewById(R.id.img_thumbnail_rv);
        }
    }
}
