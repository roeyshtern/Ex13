package com.example.user.ex13;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

import com.example.user.ex13.Data.DBContract;
import com.example.user.ex13.Data.DatabaseHelper;
import com.example.user.ex13.Data.Item;

import java.util.HashSet;

/**
 * Created by User on 5/23/17.
 */

public class MyAdapter extends ResourceCursorAdapter {
    private static final int MAX_ITEMS = 16;
    public static final int MAX_NUMBERS = 99;
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
    public void bindView(View view, final Context context, Cursor cursor) {
        TextView tv = (TextView)view.findViewById(R.id.tvNumber);

        int number = cursor.getInt(cursor.getColumnIndex(DBContract.ItemEntry.KEY_NUMBER));
        view.setTag(cursor.getInt(cursor.getColumnIndex(DBContract.ItemEntry.KEY_ID)));
        int color = cursor.getInt(cursor.getColumnIndex(DBContract.ItemEntry.KEY_COLOR));
        ((GradientDrawable)view.getBackground()).setColor(color);

        if(number!=-1)
        {
            tv.setText(Integer.toString(number));
            view.setOnClickListener(null);
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    dbh.deleteItem((Integer)v.getTag());
                    changeCursor(dbh.getAllItems(currOrder));
                    notifyDataSetChanged();
                    return true;
                }
            });
        }
        else
        {
            tv.setText("...");
            if(cursor.getCount()< MAX_ITEMS)
            {
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((MainActivity)context).openNewItemDialog();
                    }
                });
            }
            else
            {
                view.setOnClickListener(null);
            }
            view.setOnLongClickListener(null);
        }

    }
    public HashSet<Integer> getExistingNumbers()
    {
        return  this.dbh.getExistingNumbers();
    }
    public void addNewItem(Item item)
    {
        this.dbh.addItem(item);
        changeCursor(this.dbh.getAllItems(currOrder));
        notifyDataSetChanged();
    }
    public void sortItems(int num)
    {
        this.currOrder = num;
        this.dbh.getAllItems(num);
        changeCursor(this.dbh.getAllItems(num));
        notifyDataSetChanged();
    }
}
