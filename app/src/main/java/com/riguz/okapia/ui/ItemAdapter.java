package com.riguz.okapia.ui;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.riguz.okapia.R;
import com.riguz.okapia.model.SecretItem;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private final List<SecretItem> items;
    private final Resources resources;

    public ItemAdapter(List<SecretItem> dataset, Resources resources) {
        this.items = dataset;
        this.resources = resources;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        SecretItem item = items.get(i);
        itemViewHolder.textViewTitle.setText(item.getTitle());
        itemViewHolder.textViewSubTitle.setText(item.getSubTitle());
        itemViewHolder.imageViewIcon.setImageDrawable(resources.getDrawable(item.getIconId()));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewSubTitle;
        private ImageView imageViewIcon;

        ItemViewHolder(View container) {
            super(container);
            this.textViewTitle = container.findViewById(R.id.textViewTitle);
            this.textViewSubTitle = container.findViewById(R.id.textViewSubTitle);
            this.imageViewIcon = container.findViewById(R.id.imageViewIcon);
        }
    }
}
