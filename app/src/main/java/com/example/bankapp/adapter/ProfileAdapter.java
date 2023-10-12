package com.example.bankapp.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankapp.R;
import com.example.bankapp.RecyclerViewInterface;
import com.example.bankapp.model.MInbox;
import com.example.bankapp.model.MProfile;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {

    private List<MProfile> profileItems;
    private final RecyclerViewInterface clickListener;
    private Fragment fragment;


    public ProfileAdapter(List<MProfile> profileItems, RecyclerViewInterface clickListener, Fragment fragment) {
        this.profileItems = profileItems;
        this.clickListener = clickListener;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.profile_item, parent, false);
        return new ViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MProfile item = profileItems.get(position);
        holder.imageProfile.setImageResource(item.getImageProfile());
        holder.txtProfile.setText(item.getTxtProfile());

    }

    @Override
    public int getItemCount() {
        return profileItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageProfile;
        TextView txtProfile;

        public ViewHolder(View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            imageProfile = itemView.findViewById(R.id.imageProfile);
            txtProfile = itemView.findViewById(R.id.txtProfile);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerViewInterface != null) {
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        };
    }
}
