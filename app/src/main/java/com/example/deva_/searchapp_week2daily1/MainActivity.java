package com.example.deva_.searchapp_week2daily1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private EditText searchOnline;
    String url = "https://www.google.com/search?q=" + searchOnline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchOnline = findViewById(R.id.searchOnline);

    }


    public void searchButton(View view) throws NoSuchAlgorithmException {


        String query = searchOnline.getText().toString();
        searchOnline.setText(query);

        SharedPreferences sharedPreferences = getSharedPreferences("url", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("url", searchOnline.getText().toString());
        editor.commit();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.setAction("searchButton");

        startActivity(intent);


    }
}
