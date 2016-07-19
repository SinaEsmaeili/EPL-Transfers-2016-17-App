package com.unishi.sina.premapp;

import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseListAdapter;


public class ScrollingActivity extends AppCompatActivity {

    private int var;
    private ListView mListField, mListField2;
    private ImageView crests;

    Firebase mRef;
    Firebase squadsRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Retrieving on click listener info
        var = getIntent().getIntExtra("variable", 0);

        mRef = new Firebase("https://premapp-dc8b1.firebaseio.com");
        mListField = (ListView) findViewById(R.id.listView);
        mListField2 = (ListView) findViewById(R.id.listView2);

        crests = (ImageView) findViewById(R.id.crest);

        switch (var) {
            case 0: setTitle("Arsenal");
                squadsRef = mRef.child("arsenal");
                crests.setImageResource(R.drawable.ars);
                break;
            case 1: setTitle("Bournemouth");
                squadsRef = mRef.child("bournemouth");
                crests.setImageResource(R.drawable.bou);
                break;
            case 2: setTitle("Burnley");
                squadsRef = mRef.child("burnley");
                crests.setImageResource(R.drawable.bur);
                break;
            case 3: setTitle("Chelsea");
                squadsRef = mRef.child("chelsea");
                crests.setImageResource(R.drawable.che);
                break;
            case 4: setTitle("Crystal Palace");
                squadsRef = mRef.child("palace");
                crests.setImageResource(R.drawable.cry);
                break;
            case 5: setTitle("Everton");
                squadsRef = mRef.child("everton");
                crests.setImageResource(R.drawable.eve);
                break;
            case 6: setTitle("Hull City");
                squadsRef = mRef.child("hull");
                crests.setImageResource(R.drawable.hul);
                break;
            case 7: setTitle("Leicester");
                squadsRef = mRef.child("leicester");
                crests.setImageResource(R.drawable.lei);
                break;
            case 8: setTitle("Liverpool");
                squadsRef = mRef.child("liverpool");
                crests.setImageResource(R.drawable.liv);
                break;
            case 9: setTitle("Manchester City");
                squadsRef = mRef.child("city");
                crests.setImageResource(R.drawable.cit);
                break;
            case 10: setTitle("Manchester Utd");
                squadsRef = mRef.child("united");
                crests.setImageResource(R.drawable.uni);
                break;
            case 11: setTitle("Middlesbrough");
                squadsRef = mRef.child("middlesbrough");
                crests.setImageResource(R.drawable.mid);
                break;
            case 12: setTitle("Southampton");
                squadsRef = mRef.child("southampton");
                crests.setImageResource(R.drawable.sou);
                break;
            case 13: setTitle("Stoke");
                squadsRef = mRef.child("stoke");
                crests.setImageResource(R.drawable.sto);
                break;
            case 14: setTitle("Sunderland");
                squadsRef = mRef.child("sunderland");
                crests.setImageResource(R.drawable.sun);
                break;
            case 15: setTitle("Swansea");
                squadsRef = mRef.child("swansea");
                crests.setImageResource(R.drawable.swa);
                break;
            case 16: setTitle("Tottenham");
                squadsRef = mRef.child("tottenham");
                crests.setImageResource(R.drawable.tot);
                break;
            case 17: setTitle("Watford");
                squadsRef = mRef.child("watford");
                crests.setImageResource(R.drawable.wat);
                break;
            case 18: setTitle("West Brom");
                squadsRef = mRef.child("westbrom");
                crests.setImageResource(R.drawable.bro);
                break;
            case 19: setTitle("West Ham");
                squadsRef = mRef.child("westham");
                crests.setImageResource(R.drawable.wes);
                break;

        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        final ProgressBar bar = (ProgressBar) findViewById(R.id.pb);
        bar.setVisibility(View.VISIBLE);

//        FirebaseListAdapter<String> adapter = new FirebaseListAdapter<String>(this, String.class, android.R.layout.simple_list_item_1, squadsRef) {
//            @Override
//            protected void populateView(View view, String s, int i) {
//                TextView textView = (TextView)view.findViewById(android.R.id.text1);
//                textView.setText(s);
//            }
//
//        };

        // Creating the adapter for the arrivals list view
        FirebaseListAdapter<String> adapter = new FirebaseListAdapter<String>(this, String.class, R.layout.transfers, squadsRef.child("a")) {

            @Override
            protected void populateView(View view, String s, int i) {
                TextView textView = (TextView)view.findViewById(R.id.transfer_text1);
                textView.setText(s);
                textView.setTextColor(Color.WHITE);

                ImageView imageView = (ImageView)view.findViewById(R.id.transfer_image);
                imageView.setImageResource(R.drawable.joined);
            }

        };

        // Creating the adapter for the departures list view
        FirebaseListAdapter<String> adapter2 = new FirebaseListAdapter<String>(this, String.class, R.layout.transfers, squadsRef.child("d")) {

            @Override
            protected void populateView(View view, String s, int i) {
                TextView textView = (TextView)view.findViewById(R.id.transfer_text1);
                textView.setText(s);
                textView.setTextColor(Color.WHITE);

                ImageView imageView = (ImageView)view.findViewById(R.id.transfer_image);
                imageView.setImageResource(R.drawable.leaving);

            }

        };

        // Finding when synchronization of Firebase is complete for progress bar purposes
        adapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                bar.setVisibility(View.GONE);
            }

            @Override
            public void onInvalidated() {
                super.onInvalidated();
            }
        });

        mListField.setAdapter(adapter);
        mListField2.setAdapter(adapter2);
    }

}
