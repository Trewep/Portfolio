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
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
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

public class MainActivity extends AppCompatActivity implements portfolioAdapter.onItemClickListener {

    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_OMSCHRIJVING = "omschrijving";
    public static final String EXTRA_TAG ="tag";
    public static final String EXTRA_LINK = "link";


    private RecyclerView mRecyclerView;
    private portfolioAdapter mPortfolioAdapter;
    private ArrayList<portfolioItem> mPortfolioList;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mPortfolioList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();


    }

    private void parseJSON() {
        String url = "https://drupal.trewep.be/api/portfolio";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {


                            for (int i = 0; i < response.length(); i++) {
                                JSONObject portfolio = response.getJSONObject(i);

                                String title = portfolio.getString("title");
                                String omschrijving = portfolio.getString("field_omschrijving");
                                String tag = portfolio.getString("field_tags");
                                String link = portfolio.getString("view_node");

                                mPortfolioList.add(new portfolioItem(title, omschrijving, tag, link));

                            }

                            mPortfolioAdapter = new portfolioAdapter(MainActivity.this, mPortfolioList);
                            mRecyclerView.setAdapter(mPortfolioAdapter);
                            mPortfolioAdapter.setOnClickListener(MainActivity.this, new portfolioAdapter.onItemClickListener() {
                                @Override
                                public void onItemClick(int position) {
                                    portfolioItem clickedItem = mPortfolioList.get(position);

                                    String title = clickedItem.getTitle();
                                    String Link = clickedItem.getLink();

                                    Intent mSharingIntent = new Intent(Intent.ACTION_SEND);
                                    mSharingIntent.setType("text/plain");
                                    mSharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Trewep - Portfolio");
                                    mSharingIntent.putExtra(Intent.EXTRA_TEXT, title + " - "+ Link);
                                    startActivity(Intent.createChooser(mSharingIntent, "Share"));
                                }
                            });

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

    @Override
    public void onItemClick(int position) {
        /*Intent detailIntent = new Intent(this, DetailActivity.class);
        portfolioItem clickedItem = mPortfolioList.get(position);

        detailIntent.putExtra(EXTRA_TITLE, clickedItem.getTitle());
        detailIntent.putExtra(EXTRA_OMSCHRIJVING, clickedItem.getOmschrijving());
        detailIntent.putExtra(EXTRA_TAG, clickedItem.getTag());
        detailIntent.putExtra(EXTRA_LINK, clickedItem.getLink());
        startActivity(detailIntent);*/



    }

}

