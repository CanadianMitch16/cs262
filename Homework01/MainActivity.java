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

        mButtonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void OnClick(View v) {
                if (mEditText1.getText().toString().length() == 0) {
                    mEditText1.setText("0");
                }
                if (mEditText2.getText().toString().length() == 0) {
                    mEditText2.setText("0");
                }

                int num1 = Integer.parseInt(mEditText1.getText().toString());
                int num2 = Integer.parseInt(mEditText2,getText().toString());

                int sum = num1 + num2;

                mTextViewResult.setText(String.valueOf(sum));
            }

        }




    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast toast = Toast.makeText(this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
