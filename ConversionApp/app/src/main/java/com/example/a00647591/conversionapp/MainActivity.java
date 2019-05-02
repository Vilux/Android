package com.example.a00647591.conversionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    public static final String KEY_SEND_TEXT = "text";
    public static final String KEY_CHANGED_TEXT = "changed";
    private static final int CODE_DISPLAY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    DecimalFormat df = new DecimalFormat("0.00");

    public void milesToKm(final View view) {
        final EditText textToSend;
        final String text;
        final Intent intent;
        final String converted;

        textToSend = (EditText) findViewById(R.id.textToSend);
        converted = df.format((Double.parseDouble(textToSend.getText().toString()))*1.60934);
        text = converted+" km";
        intent = new Intent(this, DisplayActivity.class);
        intent.putExtra(KEY_SEND_TEXT, text);
        startActivityForResult(intent, CODE_DISPLAY);
    }

    public void kmToMiles(final View view) {
        final EditText textToSend;
        final String text;
        final Intent intent;
        final String converted;

        textToSend = (EditText) findViewById(R.id.textToSend);
        converted = df.format((Double.parseDouble(textToSend.getText().toString()))*0.62137);
        text = converted+" mi";
        intent = new Intent(this, DisplayActivity.class);
        intent.putExtra(KEY_SEND_TEXT, text);
        startActivityForResult(intent, CODE_DISPLAY);
    }

    public void inchesToCm(final View view) {
        final EditText textToSend;
        final String text;
        final Intent intent;
        final String converted;

        textToSend = (EditText) findViewById(R.id.textToSend);
        converted = df.format((Double.parseDouble(textToSend.getText().toString()))*2.54);
        text = converted+" cm";
        intent = new Intent(this, DisplayActivity.class);
        intent.putExtra(KEY_SEND_TEXT, text);
        startActivityForResult(intent, CODE_DISPLAY);
    }

    public void cmToInches(final View view) {
        final EditText textToSend;
        final String text;
        final Intent intent;
        final String converted;

        textToSend = (EditText) findViewById(R.id.textToSend);
        converted = df.format((Double.parseDouble(textToSend.getText().toString()))*0.393701);
        text = converted+" in";
        intent = new Intent(this, DisplayActivity.class);
        intent.putExtra(KEY_SEND_TEXT, text);
        startActivityForResult(intent, CODE_DISPLAY);
    }

    public void fToC(final View view) {
        final EditText textToSend;
        final String text;
        final Intent intent;
        final Double converted;
        final String converted2;

        textToSend = (EditText) findViewById(R.id.textToSend);
        converted = (Double.parseDouble(textToSend.getText().toString()));
        converted2 = df.format((converted - 32)*5/9);
        text = converted2+" \u00B0C";
        intent = new Intent(this, DisplayActivity.class);
        intent.putExtra(KEY_SEND_TEXT, text);
        startActivityForResult(intent, CODE_DISPLAY);
    }

    public void cToF(final View view) {
        final EditText textToSend;
        final String text;
        final Intent intent;
        final Double converted;
        final String converted2;

        textToSend = (EditText) findViewById(R.id.textToSend);
        converted = (Double.parseDouble(textToSend.getText().toString()));
        converted2 = df.format((converted*9/5)+32);
        text = converted2.toString()+" \u00B0F";
        intent = new Intent(this, DisplayActivity.class);
        intent.putExtra(KEY_SEND_TEXT, text);
        startActivityForResult(intent, CODE_DISPLAY);
    }

    public void lbsToKg(final View view) {
        final EditText textToSend;
        final String text;
        final Intent intent;
        final String converted;

        textToSend = (EditText) findViewById(R.id.textToSend);
        converted = df.format((Double.parseDouble(textToSend.getText().toString()))*0.393701);
        text = converted+" kg";
        intent = new Intent(this, DisplayActivity.class);
        intent.putExtra(KEY_SEND_TEXT, text);
        startActivityForResult(intent, CODE_DISPLAY);
    }

    public void kgToLbs(final View view) {
        final EditText textToSend;
        final String text;
        final Intent intent;
        final String converted;

        textToSend = (EditText) findViewById(R.id.textToSend);
        converted = df.format((Double.parseDouble(textToSend.getText().toString()))*2.20462);
        text = converted+" lbs";
        intent = new Intent(this, DisplayActivity.class);
        intent.putExtra(KEY_SEND_TEXT, text);
        startActivityForResult(intent, CODE_DISPLAY);
    }

    public void reset(final View view) {
        final EditText textToSend;

        textToSend = (EditText) findViewById(R.id.textToSend);
        textToSend.setText("");
    }

    @Override
    protected void onActivityResult(final int    requestCode,
                                    final int    resultCode,
                                    final Intent data)
    {
        final String changed;

        changed = data.getStringExtra(KEY_CHANGED_TEXT);
    }
}
