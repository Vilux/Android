package com.example.android_files_assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    EditText typeText;
    EditText locationText;
    public static final String KEY_SEND_TEXT = "text";
    public static final String KEY_CHANGED_TEXT = "changed";
    private static final int CODE_DISPLAY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        typeText = (EditText) findViewById(R.id.typeText);
        locationText = (EditText) findViewById(R.id.locationText);

    }

    public void onClickAdd(View view) {

        // write to INTERNAL storage
        String typeData = typeText.getText().toString();
        String locationData = locationText.getText().toString();
        String time = Calendar.getInstance().getTime().toString();
        try
        {
            FileOutputStream fOut = openFileOutput("textfile.txt", MODE_APPEND);
            fOut.write(typeData.getBytes());
            fOut.write('|');
            fOut.write(locationData.getBytes());
            fOut.write('|');
            fOut.write(time.getBytes());
            fOut.write('\n');
            fOut.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();

    }

    public void onClickClear(View view){
        typeText.setText("");
        locationText.setText("");
    }

    public void onClickBirds(View view) {
        final Intent intent;

        intent = new Intent(getApplicationContext(), ScrollingActivity2.class);
        startActivity(intent);
    }
}
