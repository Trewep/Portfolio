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

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    //private TextView mfield_title;
    //private TextView mfield_omschrijving;
    //private TextView mfield_tags;
    //private RequestQueue mQueue;

    private RecyclerView mRecyclerView;
    private portfolioAdapter mPortfolioAdapter;
    private ArrayList<portfolioItem> mPortfolioList;
    private RequestQueue mRequestQueue;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mPortfolioList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }

    private void parseJSON(){
        String url = "https://drupal.trewep.be/api/portfolio";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {

                            for (int i = 0; i< response.length();i++){
                                JSONObject portfolio = response.getJSONObject(i);
                                String title = portfolio.getString("title");

                                mPortfolioList.add(new portfolioItem(title));
                            }
                            mPortfolioAdapter = new portfolioAdapter(MainActivity.this, mPortfolioList);
                            mRecyclerView.setAdapter(mPortfolioAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mRequestQueue.add(request);
    }


       /* mfield_title = findViewById(R.id.field_title);
        //mfield_omschrijving = findViewById(R.id.field_omschrijving);
        //mfield_tags = findViewById(R.id.field_tags);

        mQueue = Volley.newRequestQueue(this);

        jsonParse();

    private void jsonParse(){
         String url ="https://drupal.trewep.be/api/portfolio";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {

                            for (int i = 0; i< response.length();i++){
                                JSONObject portfolio = response.getJSONObject(i);

                                String title = portfolio.getString("title");
                                //String omschrijving = portfolio.getString("field_omschrijving");
                                //String tags = portfolio.getString("field_tags");
                                mfield_title.append(title + "\n \n");
                                //mfield_omschrijving.append(omschrijving);
                                //mfield_tags.append(tags);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }*/
}