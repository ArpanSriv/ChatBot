package com.arpan.chatbot;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ImageButton;

import de.hdodenhof.circleimageview.CircleImageView;

public class Settings extends AppCompatActivity {

    private CircleImageView profilePicture;
    private ImageButton uploadButton;
    private int RC = 1;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        uploadButton = findViewById(R.id.upload_btn);
        profilePicture = findViewById(R.id.iv_dp);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String pp_string = sharedPreferences.getString("profile_picture", null);

        if (pp_string == null) {
            profilePicture.setImageDrawable(getResources().getDrawable(R.drawable.grey_background));
        }

        else {
            profilePicture.setImageURI(Uri.parse(pp_string));
        }

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, RC);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == RC && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri choosenImage = data.getData();

            profilePicture.setImageURI(choosenImage);

            sharedPreferences
                    .edit()
                    .putString("profile_picture", choosenImage.toString())
                    .apply();
        }
    }


}
