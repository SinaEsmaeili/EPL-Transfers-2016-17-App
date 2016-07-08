package com.unishi.sina.premapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Club> clubs;
    private RecyclerView rv;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        rv = (RecyclerView) findViewById(R.id.rv);

        mLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(mLayoutManager);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();

    }

    private void initializeData() {
        clubs = new ArrayList<>();

        clubs.add(new Club("Arsenal", R.drawable.arsenal));
        clubs.add(new Club("Bournemouth", R.drawable.afcb));
        clubs.add(new Club("Burnley", R.drawable.burnley));
        clubs.add(new Club("Chelsea", R.drawable.chelsea));
        clubs.add(new Club("Crystal Palace", R.drawable.palace));
        clubs.add(new Club("Everton", R.drawable.everton));
        clubs.add(new Club("Hull City", R.drawable.hull));
        clubs.add(new Club("Leicester", R.drawable.leicester));
        clubs.add(new Club("Liverpool", R.drawable.liverpool));
        clubs.add(new Club("Manchester City", R.drawable.city));
        clubs.add(new Club("Manchester United", R.drawable.united));
        clubs.add(new Club("Middlesbrough", R.drawable.middle));
        clubs.add(new Club("Southampton", R.drawable.southampton));
        clubs.add(new Club("Stoke", R.drawable.stoke));
        clubs.add(new Club("Sunderland", R.drawable.sunderland));
        clubs.add(new Club("Swansea", R.drawable.swansea));
        clubs.add(new Club("Tottenham", R.drawable.spurs));
        clubs.add(new Club("Watford", R.drawable.watford));
        clubs.add(new Club("West Bromwich Albion", R.drawable.westbrom));
        clubs.add(new Club("West Ham", R.drawable.westham));

    }

    private void initializeAdapter() {
        mAdapter = new RVAdapter(this, clubs);
        rv.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
