package be.trewep.portfolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private TextView mfield_title;
    private TextView mfield_omschrijving;
    private TextView mfield_tags;
    private TextView mfield_url;
    private RequestQueue mQueue;


    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate (savedInstanceState);
        setContentView(R.layout.activity_main);

        mfield_title = findViewById(R.id.field_title);
        mfield_omschrijving = findViewById(R.id.field_omschrijving);
        mfield_tags = findViewById(R.id.field_tags);
        mfield_url = findViewById(R.id.field_url);

        mQueue = Volley.newRequestQueue(this);

        jsonParse();

    }
    private void jsonParse(){
         String url ="https://drupal.trewep.be/api/portfolio";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        JSONArray jsonArray = response.getJSONArray()
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
    }
   /* private static final String myURL = "https://drupal.trewep.be/api/portfolio";
    private final LinkedList<Integer>mNumberList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private portfolioItem mAdapter;
    RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQueue = Volley.newRequestQueue(this);

        Intent intent = getIntent();
        int number = intent.getIntExtra("MAXNUMBER", 100);

        populateList(20);

        mRecyclerView = findViewById(R.id.recycler);
        mAdapter = new portfolioItem(context: this, mNumberList); // List is empty at this point
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
    private void populateList(int max){
        for (int i = 1; i<=max; i++){
            mNumberList.add(i);
        }
    }*/

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