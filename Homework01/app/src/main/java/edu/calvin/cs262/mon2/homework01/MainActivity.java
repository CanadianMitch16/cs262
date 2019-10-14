package edu.calvin.cs262.mon2.homework01;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.Button;



public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText mEditText1;
    private EditText mEditText2;
    private EditText mTextViewResult;
    private Button mButtonCalculate;
    private Spinner mOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner1 = findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(this);

        mEditText1 = findViewById(R.id.number1);
        mEditText2 = findViewById(R.id.number2);
        mTextViewResult = findViewById(R.id.textview_result);
        mButtonCalculate = findViewById(R.id.calculate);
        mOperator = findViewById(R.id.operator);

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        });

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        });

        }

    }
}
