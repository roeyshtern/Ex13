package com.example.user.ex13;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ResourceCursorAdapter;

import com.example.user.ex13.Data.DatabaseHelper;

/**
 * Created by User on 5/23/17.
 */

public class MyAdapter extends ResourceCursorAdapter {
    private int currOrder = DatabaseHelper.SORT_BY_NUMS;
    private DatabaseHelper dbh = null;
    private Context context = null;
    public MyAdapter(Context context, int layout) {
        super(context, layout, null,0);
        this.dbh = DatabaseHelper.getInstance(context);
        this.context = context;
        changeCursor(this.dbh.getAllItems(currOrder));
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }
}
