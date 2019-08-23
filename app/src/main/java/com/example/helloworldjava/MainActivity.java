package com.example.helloworldjava;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    public final static int START_SECOND_ACTIVITY = 0;
    public final static String MAIN_ACTIVITY_TEXT = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        TextView textView1 = findViewById(R.id.header1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText(textView1.getText() + " World!");
                Intent secondActivityIntent =
                        new Intent(MainActivity.this, SecondActivity.class);
                secondActivityIntent.putExtra(MAIN_ACTIVITY_TEXT, "Hello From MainActivity!");
                // MainActivity.this.startActivity(secondActivityIntent);
                MainActivity.this.startActivityForResult(secondActivityIntent, START_SECOND_ACTIVITY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // super.onActivityResult(requestCode, resultCode, data);
        Log.e("My requestCode", String.valueOf(requestCode));
        Log.e("My resultCode", String.valueOf(resultCode));
        Log.e("My data", String.valueOf(data));
        switch (requestCode) {
            case START_SECOND_ACTIVITY: {
                if (resultCode == RESULT_OK && data != null) {
                    final TextView textView1 = findViewById(R.id.header1);
                    textView1.setText(textView1.getText() + " " + data.getStringExtra(SecondActivity.SECOND_ACTIVITY_TEXT));
                }
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent finishIntent = new Intent(Intent.ACTION_WEB_SEARCH);
        finishIntent.putExtra(SearchManager.QUERY, "www.google.com");
        startActivity(finishIntent);
        super.onBackPressed();
    }
}
