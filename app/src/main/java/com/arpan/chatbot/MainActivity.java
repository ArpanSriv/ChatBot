package com.arpan.chatbot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView messagesRecyclerView;
    private EditText inputEditText;
    private ImageButton button;
    private MessagesAdapter messagesAdapter;
    private Toolbar toolbar;

    ArrayList<Message> messages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Chat Bot");

        messagesRecyclerView = findViewById(R.id.messages_list);
        inputEditText = findViewById(R.id.message_edit_text);
        button = findViewById(R.id.send_button);

        messagesAdapter = new MessagesAdapter(this, messages);
        messagesRecyclerView.setAdapter(messagesAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        messagesRecyclerView.setLayoutManager(linearLayoutManager);


    }

    public void sendMessage(View v) {

        String typedMessage = inputEditText.getText().toString();

        Message message = new Message("Me", typedMessage);

        inputEditText.setText("");

        messages.add(message);

        messagesAdapter.notifyDataSetChanged();

        processReply(typedMessage);

    }


    public void processReply(String messageText) {

        Message message = new Message("Bot", "Hey There.");
        messages.add(message);

        messagesAdapter.notifyDataSetChanged();
    }


}
