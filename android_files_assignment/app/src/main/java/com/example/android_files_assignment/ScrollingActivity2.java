package com.example.android_files_assignment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;

import android.widget.TextView;

import java.io.FileInputStream;
import java.io.IOException;

public class ScrollingActivity2 extends AppCompatActivity {

    TextView birdInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling2);
        birdInfo = (TextView) findViewById(R.id.allInfo);

        try
        {
            FileInputStream fin = openFileInput("textfile.txt");
            int c=0;
            String temp = "";

            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c);
            }
            fin.close();
            String []contact= temp.split("\n");
            String data = "";
            for (int i = 0 ; i < contact.length ; i ++ ) {
                String[] contactData = contact[i].split("\\|");
                data = data +  contactData[0] +"\n"+ contactData[1] + "\n" +
                        contactData[2]+"\n\n";
            }
            birdInfo.setText( data  );
        } catch (IOException ioe) {

            ioe.printStackTrace();
        }

    }

    public void close(final View view)
    {
        finish();
    }
}
