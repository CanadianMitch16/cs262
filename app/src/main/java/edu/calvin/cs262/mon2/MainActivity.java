package edu.calvin.cs262.mon2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText mValueOne;
    private EditText mValueTwo;
    private TextView mResult;
    private Button mCalculate;
    private String Decision = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mValueOne = findViewById(R.id.valueOne);
        mValueTwo = findViewById(R.id.valueTwo);
        mResult = findViewById(R.id.result);
        mCalculate = findViewById(R.id.calculate);


        Spinner spinner = findViewById(R.id.operator);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        mCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mValueOne.getText().toString().length() == 0) {
                    mValueOne.setText("0");
                }
                if (mValueTwo.getText().toString().length() == 0) {
                    mValueTwo.setText("0");
                }

                if (Decision.equals("+")) {
                    int num1 = Integer.parseInt(mValueOne.getText().toString());
                    int num2 = Integer.parseInt(mValueTwo.getText().toString());

                    int sum = num1 + num2;

                    mResult.setText(String.valueOf(sum));
                }
                if (Decision.equals("-")) {
                    int num1 = Integer.parseInt(mValueOne.getText().toString());
                    int num2 = Integer.parseInt(mValueTwo.getText().toString());

                    int sum = num1 - num2;

                    mResult.setText(String.valueOf(sum));
                }
                if (Decision.equals("*")) {
                    int num1 = Integer.parseInt(mValueOne.getText().toString());
                    int num2 = Integer.parseInt(mValueTwo.getText().toString());

                    int sum = num1 * num2;

                    mResult.setText(String.valueOf(sum));
                }
                if (Decision.equals("/")) {
                    int num1 = Integer.parseInt(mValueOne.getText().toString());
                    int num2 = Integer.parseInt(mValueTwo.getText().toString());

                    int sum = num1 / num2;

                    mResult.setText(String.valueOf(sum));
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choice = parent.getItemAtPosition(position).toString();
        if (choice.equals("+")) {
            Decision = "+";
        }
        if (choice.equals("-")) {
            Decision = "-";
        }
        if (choice.equals("/")) {
            Decision = "/";
        }
        if (choice.equals("*")){
            Decision = "*";
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
