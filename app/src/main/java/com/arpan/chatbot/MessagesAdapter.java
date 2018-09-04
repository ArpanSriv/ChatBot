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

public class MessagesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Message> mMessages;
    Context mContext;
    private int MESSAGE_TYPE_RECIEVED = 1;
    private int MESSAGE_TYPE_SENT = 2;

    public MessagesAdapter (Context context, ArrayList<Message> messages) {
        mMessages = messages;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == MESSAGE_TYPE_RECIEVED) {
            //Inflate the item_message_recieved.xml
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_message_recieved, parent, false);
            RecyclerView.ViewHolder recievedViewHolder = new RecievedViewHolder(view);
            return recievedViewHolder;
        }

        else {
            //Inflate the item_message_sent.xml
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_message_sent, parent, false);
            RecyclerView.ViewHolder sentViewHolder = new SentViewHolder(view);
            return sentViewHolder;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Message currentMessage = mMessages.get(position);

        if (holder.getItemViewType() == MESSAGE_TYPE_RECIEVED) {
            //Bind Data to Received VH
            RecievedViewHolder rHolder = (RecievedViewHolder) holder;

            rHolder.messageContentTV.setText(currentMessage.getMessageContent());
            rHolder.timeTV.setText("14:00");
        }

        else {
            //Bind Data to Sent VH
            SentViewHolder sHolder = (SentViewHolder) holder;


            sHolder.timeTV.setText("15:00");
            sHolder.messageContentTV.setText(currentMessage.getMessageContent());
        }

    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }

    @Override
    public int getItemViewType(int position) {

        Message currentMessage = mMessages.get(position);

        if (currentMessage.getSenderName().equals("Bot")) {
            return MESSAGE_TYPE_RECIEVED;
        }

        else {
            return MESSAGE_TYPE_SENT;
        }

    }

    public class RecievedViewHolder extends RecyclerView.ViewHolder {

        TextView messageContentTV;
        TextView timeTV;

        public RecievedViewHolder(View itemView) {
            super(itemView);

            messageContentTV = itemView.findViewById(R.id.message_textview);
            timeTV = itemView.findViewById(R.id.time_textview);
        }
    }

    public class SentViewHolder extends RecyclerView.ViewHolder {

        TextView messageContentTV;
        TextView timeTV;

        public SentViewHolder(View itemView) {
            super(itemView);

            messageContentTV = itemView.findViewById(R.id.text_message_body);
            timeTV = itemView.findViewById(R.id.text_message_time);
        }
    }


}
