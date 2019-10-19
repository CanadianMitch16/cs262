package edu.calvin.cs262.mon2;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PageLoader extends AsyncTaskLoader<String> {
    private String mUrl;


    PageLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }


    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public String loadInBackground() {
        HttpURLConnection urlConnection = null;
        BufferedReader reader;
        String pageContent;

        try {
            // Connect to entered url
            URL requestURL = new URL(mUrl);
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Retrieve input stream
            InputStream inputStream = urlConnection.getInputStream();

            // create reader from stream
            reader = new BufferedReader(new InputStreamReader(inputStream));

            // holds incoming stream for now
            StringBuilder builder = new StringBuilder();

            // Collects the source code through a while loop
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append("\n");
            }

            if (builder.length() == 0) {
                // Stream is empty therefore null
                return null;
            }

            pageContent = builder.toString();
        } catch (IOException e) {

            // Display any errors
            e.printStackTrace();
            pageContent = "Check your internet connection and provided url, then try again";
        } finally {

            // Disconnect
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return pageContent;
    }
}