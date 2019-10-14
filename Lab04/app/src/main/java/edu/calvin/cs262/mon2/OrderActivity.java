package edu.calvin.cs262.mon2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.Toast;


public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onRadioButtonClicked(View view) {
        //Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        //check which radio button was clicked
        switch (view.getId()) {
            case R.id.sameday:
                //Same day service
                displayToast(getString(R.string.same_day_messenger_service));
            break;
            case R.id.nextday:
                if (checked)
                    //Next day delivery
                    displayToast(getString(R.string.next_day_ground_delivery));
                break;
            case R.id.pickup:
                if (checked)
                    //Pick up
                    displayToast(getString(R.string.pick_up));
                break;
            default:
                //Do Nothing
                break;
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
