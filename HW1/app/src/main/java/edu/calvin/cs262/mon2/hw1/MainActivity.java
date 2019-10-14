package edu.calvin.cs262.mon2.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;


public abstract class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, SpinnerAdapter {
    private EditText mEditText1;
    private EditText mEditText2;
    private TextView mTextViewResult;
    private Spinner mSpinnerOperator;
    private Button mButtonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.operator);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Spinner_items, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setAdapter(this);
        spinner.setOnItemSelectedListener(this);

        mEditText1 = findViewById(R.id.valueOne);
        mEditText2 = findViewById(R.id.valueTwo);
        mTextViewResult = findViewById(R.id.result);
        mButtonCalculate = findViewById(R.id.calculate);
        mSpinnerOperator = findViewById(R.id.operator);

        mButtonCalculate.setOnClickListener(new View.OnClickListener()); {
            @Override
            public void onClick(View v) {
                if (mEditText1.getText().toString().length() == 0) {
                    mEditText1.setText("0");
                }
                if (mEditText2.getText().toString().length() == 0) {
                    mEditText2.setText("0");
                }
                if (mSpinnerOperator.getSelectedItem().toString() == "*") {

                    int num1 = Integer.parseInt(mEditText1.getText().toString());
                    int num2 = Integer.parseInt(mEditText2.getText().toString());

                    int sum = num1 * num2;
                    mTextViewResult.setText(String.valueOf(sum));
                }
                if (mSpinnerOperator.getSelectedItem().toString() == "/") {

                    int num1 = Integer.parseInt(mEditText1.getText().toString());
                    int num2 = Integer.parseInt(mEditText2.getText().toString());

                    int sum = num1 / num2;
                    mTextViewResult.setText(String.valueOf(sum));
                }
                if (mSpinnerOperator.getSelectedItem().toString() == "+") {

                    int num1 = Integer.parseInt(mEditText1.getText().toString());
                    int num2 = Integer.parseInt(mEditText2.getText().toString());

                    int sum = num1 * num2;
                    mTextViewResult.setText(String.valueOf(sum));
                }
                if (mSpinnerOperator.getSelectedItem().toString() == "-") {

                    int num1 = Integer.parseInt(mEditText1.getText().toString());
                    int num2 = Integer.parseInt(mEditText2.getText().toString());

                    int sum = num1 - num2;
                    mTextViewResult.setText(String.valueOf(sum));
                }


                }
            }
        }
    }







