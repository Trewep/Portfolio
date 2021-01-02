package be.trewep.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    private static final String JsonUrlStr = "https://drupal.trewep.be/api/portfolio";
    private final LinkedList<Integer>mNumberList = new LinkedList<>();
    private RecyclerView mRecyclerView;

   /* LinearLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootLayout = findViewById(R.id.list_view);

        try {
            URL url= new URL(JsonUrlStr);

            //start in Background
            FetchPortfolioTask getDataTask = new FetchPortfolioTask();
            getDataTask.execute(url);
        }
        catch (MalformedURLException error){
            Log.e(TAG, error.getMessage());
        }
    }
    public class FetchPortfolioTask extends AsyncTask<URL, Void, portfolioItem[]> {
        final String TAG = FetchPortfolioTask.class.getSimpleName();
        URL url;
       //haal de data van de achtergrond (JSON) en voeg dit toe in de LinearLayout

        @Override
        protected portfolioItem[] doInBackground(URL... params){
            url = params[0];
            if (url.toString().contains(".json")){
                return FetchPortfolioTaskAsJSON();
            }
            //Fallback
            return new portfolioItem[0];
        }
        //Na 'doInBackground' is klaar, zet elk portfolio item naar de LinearLayout

        @Override
        protected void onPostExecute(portfolioItem[] portfolioItems){
            //loop over alle portfolio Items van uit doInBackground
            for (portfolioItem portfolioItem: portfolioItems){

                //create new view for hold Portfolio item
                View portfolioView = getLayoutInflater().inflate(R.layout.list_item,root: null);

                //Get the Title View and populate it
                TextView field_title = portfolioView.findViewById(R.id.field_title);
                field_title.setText(String.format("%s",portfolioItem.getField_title()));

                //Get the Tag View and populate it
                TextView field_tags = portfolioView.findViewById(R.id.field_tags);
                field_tags.setText(String.format("%s",portfolioItem.getField_tags()));

                //Get the Omschrijving View and populate it
                TextView field_Omschrijving = portfolioView.findViewById(R.id.field_omschrijving);
                field_Omschrijving.setText(String.format("%s",portfolioItem.getField_omschrijving()));

                //add to Root Layout
                rootLayout.addView(portfolioView);

            }
        }
        //fetch the string from the URL and interpret it as json data.
        //Using Gson library to decode the string.

        portfolioItem[] FetchPortfolioTaskAsJSON(){
            String jsonData = getDataFromURLAsString();
            return new GsonBuilder().create().fromJson(jsonData, portfolioItem[].class);
        }
        //make connection to url and fetch data as one long string
        String getDataFromURLAsString(){
            HttpsURLConnection urlConnection = null;
            try {
                urlConnection = (HttpsURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();

                Scanner scanner = new Scanner(in);
                scanner.useDelimiter("\\A");

                boolean hasInput = scanner.hasNext();
                if (hasInput){
                    return scanner.next();
                }
                else{
                    return null;
                }
            } catch (IOException error){
                Log.e(TAG, error.getMessage());
            } finally {
                if (urlConnection != null)
                    urlConnection.disconnect();
            }
            return "";
        }
    }*/
}