package com.arpan.chatbot;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MessagesHolder> {

    ArrayList<Message> mMessages;
    Context mContext;

    public MessagesAdapter (Context context, ArrayList<Message> messages) {
        mMessages = messages;
        mContext = context;
    }

    @NonNull
    @Override
    public MessagesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_message, parent, false);
        MessagesHolder messagesHolder = new MessagesHolder(v);
        return messagesHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MessagesHolder holder, int position) {
        Message currentMessage = mMessages.get(position);

        holder.senderTV.setText(currentMessage.getSenderName());
        holder.messageTV.setText(currentMessage.getMessageContent());
    }

    @Override
    public int getItemCount() {
       return mMessages.size();
    }

    public class MessagesHolder extends RecyclerView.ViewHolder {

        TextView senderTV;
        TextView messageTV;

        public MessagesHolder(View itemView) {
            super(itemView);

            senderTV = itemView.findViewById(R.id.sender_tv);
            messageTV = itemView.findViewById(R.id.message_tv);

        }
    }

}
