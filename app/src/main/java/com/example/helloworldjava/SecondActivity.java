package com.example.helloworldjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    public final static String SECOND_ACTIVITY_TEXT = "text";

    private EditText mSAEditText;
    private String mString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String fromMainActivity = this.getIntent().getStringExtra(MainActivity.MAIN_ACTIVITY_TEXT);
        Toast.makeText(this, fromMainActivity, Toast.LENGTH_LONG).show();

        mSAEditText = findViewById(R.id.saEditText);
        Button saButton = findViewById(R.id.saButton);

        mSAEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mString = editable.toString();
            }
        });

        saButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onActivityFinished();
                SecondActivity.this.finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        onActivityFinished();
        super.onBackPressed();
    }

    private void onActivityFinished(){
        Intent responseIntent = new Intent();
        responseIntent.putExtra(SECOND_ACTIVITY_TEXT, mString);
        setResult(RESULT_OK, responseIntent);
    }
}
