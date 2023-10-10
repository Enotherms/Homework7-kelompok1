package com.example.bankapp.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankapp.R;
import com.example.bankapp.model.MInbox;

import java.util.List;

public class InboxAdapter extends RecyclerView.Adapter<InboxAdapter.ViewHolder> {

    private List<MInbox> inboxItems;

    public InboxAdapter(List<MInbox> inboxItems) {
        this.inboxItems = inboxItems;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.inbox_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MInbox item = inboxItems.get(position);
        holder.inboxName.setText(item.getInboxName());
        holder.inboxMessage.setText(item.getInboxMsg());
    }

    @Override
    public int getItemCount() {
        return inboxItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView inboxName;
        TextView inboxMessage;

        public ViewHolder(View itemView) {
            super(itemView);
            inboxName = itemView.findViewById(R.id.inbox_name);
            inboxMessage = itemView.findViewById(R.id.inbox_message);
        }
    }
}
