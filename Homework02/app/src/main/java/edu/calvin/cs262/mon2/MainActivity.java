package edu.calvin.cs262.mon2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    private CharSequence mProtocol = "https://";
    private EditText mUrlEntered;
    private TextView mSourceCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner protocol_selection = findViewById(R.id.protocol_selection);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.protocols, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        protocol_selection.setAdapter(adapter);
        protocol_selection.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                mProtocol = (CharSequence) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
                mProtocol = "https://";
            }
        });

        mUrlEntered =   findViewById(R.id.enter_url);
        mSourceCode =  findViewById(R.id.source_code);
    }


    public void getSourceCode(View view) {
        // concatenates URL with protocol
        String completeURL = mProtocol + mUrlEntered.getText().toString();

        // Check the connection, hide keyboard on button press
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager != null ) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }

        if (networkInfo != null && networkInfo.isConnected()) {
            Bundle urlBundle = new Bundle();

            // Load the page at entered URL
            urlBundle.putString("fullUrl", completeURL);
            getSupportLoaderManager().restartLoader(0, urlBundle, this);
            mSourceCode.setText(R.string.loading);
        } else {

            // Prompt user to check connection
            mSourceCode.setText(R.string.check_connection);
        }
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        String completeUrl = "";

        if (args != null) {
            completeUrl = args.getString("fullUrl");
        }

        return new PageLoader(this, completeUrl);
    }


    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        mSourceCode.setText(data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {
    }
}