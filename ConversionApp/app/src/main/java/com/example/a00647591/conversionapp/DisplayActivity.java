package com.example.a00647591.conversionapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        final Intent intent;
        final TextView convertedValue;

        intent = getIntent();
        text   = intent.getStringExtra(MainActivity.KEY_SEND_TEXT);
        convertedValue = (TextView) findViewById(R.id.convertedValue);
        convertedValue.setText(text);
    }

    public void done(final View view)
    {
        final Intent result;

        result = new Intent();
        result.putExtra(MainActivity.KEY_CHANGED_TEXT, text.toUpperCase());
        setResult(AppCompatActivity.RESULT_CANCELED, result);
        finish();
    }
}
