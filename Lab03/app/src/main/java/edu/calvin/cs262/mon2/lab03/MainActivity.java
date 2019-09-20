package edu.calvin.cs262.mon2.lab03;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.util.Log;import android.util.IntProperty;


public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.classgetSimpleName();
    private EditText mMessageEditText;
    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_main);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
    }
        Log.d(LOG_TAG, "Button clicked!")
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }



