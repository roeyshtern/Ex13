package com.example.user.ex13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    GridView gv = null;
    MyAdapter adapter = null;
    Button btSortByNumbers = null;
    Button btSortByColors = null;
    Button btShuffle = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gv = (GridView)findViewById(R.id.gridView);
        this.adapter = new MyAdapter(this,R.layout.item);
        gv.setAdapter(adapter);

        btShuffle = (Button)findViewById(R.id.btShuffle);
        btSortByColors = (Button)findViewById(R.id.btSortColors);
        btSortByNumbers = (Button)findViewById(R.id.btSortNumbers);
    }
}
