package be.trewep.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import static be.trewep.portfolio.MainActivity.EXTRA_LINK;
import static be.trewep.portfolio.MainActivity.EXTRA_OMSCHRIJVING;
import static be.trewep.portfolio.MainActivity.EXTRA_TAG;
import static be.trewep.portfolio.MainActivity.EXTRA_TITLE;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String title = intent.getStringExtra(EXTRA_TITLE);
        String omschrijving = intent.getStringExtra(EXTRA_OMSCHRIJVING);
        String tag = intent.getStringExtra(EXTRA_TAG);
        String link = intent.getStringExtra(EXTRA_LINK);

        TextView textViewTitle = findViewById(R.id.text_view_title);
        TextView textViewOmschrijving = findViewById(R.id.text_view_Omschrijving_detail);
        TextView textViewTag = findViewById(R.id.text_view_tag_detail);
        TextView textViewLink = findViewById(R.id.text_view_link_detail);


        textViewTitle.setText(title);
        textViewOmschrijving.setText(omschrijving);
        textViewTag.setText(tag);
        textViewLink.setText(link);
    }
}