package com.acadgild.s6A4QuickCallSMS;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by sunny on 9/3/16.
 */
public class MainAdapter extends BaseAdapter {

    Context context;
    String[] names;
    String[] numbers;
    LayoutInflater inflater = null;

    TextView nameText;
    TextView numberText;

    public MainAdapter(Context context, String[] names, String[] numbers) {
        this.context = context;
        this.names = names;
        this.numbers = numbers;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.main_list_items, null);

        nameText = (TextView) view.findViewById(R.id.name_text);
        numberText = (TextView) view.findViewById(R.id.number_text);

        nameText.setText(names[position]);
        numberText.setText(numbers[position]);

        return view;
    }
}
