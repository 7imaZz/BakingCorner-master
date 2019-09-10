package com.example.bakingcorner.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bakingcorner.Model.CakeModel;
import com.example.bakingcorner.Model.Steps;
import com.example.bakingcorner.R;


import java.util.List;

public class CakesAdapter extends RecyclerView.Adapter<CakesAdapter.CakesViewHolder>{

    public class CakesViewHolder extends RecyclerView.ViewHolder {

        private TextView cakeNameTextView;
        public CakesViewHolder(@NonNull View itemView) {
            super(itemView);
            this.cakeNameTextView = itemView.findViewById(R.id.tv_cake);
        }
    }


    private List<CakeModel> cakes;
    private Context context;


    public CakesAdapter(Context context, List<CakeModel> cakes) {
        this.cakes = cakes;
        this.context = context;
    }

    @NonNull
    @Override
    public CakesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new CakesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CakesViewHolder holder, int position) {


        final CakeModel currentCake = cakes.get(position);

        holder.cakeNameTextView.setText(currentCake.getName());
        holder.cakeNameTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DetailsActivity.class);
                    intent.putExtra("cake", currentCake);
                    context.startActivity(intent);
                }
            });

    }

    @Override
    public int getItemCount() {
        return cakes.size();
    }
}
