package edu.calvin.cs262.mon2;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtils {
    private static final String LOG_TAG = NetworkUtils.class.getSimpleName();
    //Base URL for Books API
    private static final String BOOK_BASE_URL = "https://www.googleapis.com/books/v1/volumes?";
    //Parameter for the search string
    private static final String QUERY_PARAM = "q";
    //Parameter that limits search results
    private static final String MAX_RESULTS = "maxResults";
    //Parameter to filter by print type
    private static final String PRINT_TYPE = "printType";


    static String getBookInfo(String queryString) {
        //Creating local variables for connecting to internet
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String bookJSONString = null;

        try {
            Uri builtURI = Uri.parse(BOOK_BASE_URL).buildUpon()
                    .appendQueryParameter(QUERY_PARAM, queryString)
                    .appendQueryParameter(MAX_RESULTS, "10")
                    .appendQueryParameter(PRINT_TYPE, "books")
                    .build();
            //Converts URI to a URL object
            URL requestURL = new URL(builtURI.toString());
            //Opens URL connection and makes request
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            //Get the InputStream
            InputStream inputStream = urlConnection.getInputStream();
            //Create buffered reader from the input stream
            reader = new BufferedReader(new InputStreamReader(inputStream));
            //Use a StringBuilder to hold the incoming response
            StringBuilder builder = new StringBuilder();

            //Reads input line-by-line into the string while there is still an input
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                //Since it is a JSON, adding a newline is not necessary and will not affect parsing
                //However, it does make debugging a LOT easier
                //If you print out the completed buffer for debugging
                builder.append("\n");

                //Checks to see if there is existing response content, null otherwhise
                if (builder.length() == 0) {
                    //Stream was empty, no reason to parse
                    return null;
                }

                //Converts StringBuilder object to a string stores as bookJSONString
                bookJSONString = builder.toString();
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Log.d(LOG_TAG, bookJSONString);
        return bookJSONString;
    }
}
