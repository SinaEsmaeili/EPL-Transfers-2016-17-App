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

    Firebase mRef;
    Firebase squadsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        var = getIntent().getIntExtra("variable", 0);


        mRef = new Firebase("https://premapp-dc8b1.firebaseio.com");
        mListField = (ListView) findViewById(R.id.listView);
        mListField2 = (ListView) findViewById(R.id.listView2);

        switch (var) {
            case 0: setTitle("Arsenal");
                squadsRef = mRef.child("arsenal");
                break;
            case 1: setTitle("Bournemouth");
                squadsRef = mRef.child("bournemouth");
                break;
            case 2: setTitle("Burnley");
                squadsRef = mRef.child("burnley");
                break;
            case 3: setTitle("Chelsea");
                squadsRef = mRef.child("chealsea");
                break;
            case 4: setTitle("Crystal Palace");
                squadsRef = mRef.child("palace");
                break;
            case 5: setTitle("Everton");
                squadsRef = mRef.child("everton");
                break;
            case 6: setTitle("Hull City");
                squadsRef = mRef.child("hull");
                break;
            case 7: setTitle("Leicester");
                squadsRef = mRef.child("leicester");
                break;
            case 8: setTitle("Liverpool");
                squadsRef = mRef.child("liverpool");
                break;
            case 9: setTitle("Manchester City");
                squadsRef = mRef.child("city");
                break;
            case 10: setTitle("Manchester Utd");
                squadsRef = mRef.child("united");
                break;
            case 11: setTitle("Middlesbrough");
                squadsRef = mRef.child("middlesbrough");
                break;
            case 12: setTitle("Southampton");
                squadsRef = mRef.child("southampton");
                break;
            case 13: setTitle("Stoke");
                squadsRef = mRef.child("stoke");
                break;
            case 14: setTitle("Sunderland");
                squadsRef = mRef.child("sunderland");
                break;
            case 15: setTitle("Swansea");
                squadsRef = mRef.child("swansea");
                break;
            case 16: setTitle("Tottenham");
                squadsRef = mRef.child("tottenham");
                break;
            case 17: setTitle("Watford");
                squadsRef = mRef.child("watford");
                break;
            case 18: setTitle("West Brom");
                squadsRef = mRef.child("westbrom");
                break;
            case 19: setTitle("West Ham");
                squadsRef = mRef.child("westham");
                break;

        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        final ProgressBar bar = (ProgressBar) findViewById(R.id.pb);
        bar.setVisibility(View.VISIBLE);

        // Creating the adapter for Firebase to later link to the list view
//        FirebaseListAdapter<String> adapter = new FirebaseListAdapter<String>(this, String.class, android.R.layout.simple_list_item_1, squadsRef) {
//            @Override
//            protected void populateView(View view, String s, int i) {
//                TextView textView = (TextView)view.findViewById(android.R.id.text1);
//                textView.setText(s);
//            }
//
//        };

        FirebaseListAdapter<String> adapter = new FirebaseListAdapter<String>(this, String.class, R.layout.transfers, squadsRef.child("arrivals")) {

            @Override
            protected void populateView(View view, String s, int i) {
                TextView textView = (TextView)view.findViewById(R.id.transfer_text1);
                textView.setText(s);
                textView.setTextColor(Color.WHITE);

                ImageView imageView = (ImageView)view.findViewById(R.id.transfer_image);
                imageView.setImageResource(R.drawable.joined);
            }

        };

        FirebaseListAdapter<String> adapter2 = new FirebaseListAdapter<String>(this, String.class, R.layout.transfers, squadsRef.child("departures")) {

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
