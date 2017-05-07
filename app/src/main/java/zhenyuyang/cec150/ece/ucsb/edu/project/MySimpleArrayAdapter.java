package zhenyuyang.cec150.ece.ucsb.edu.project;

import android.content.Context;
import android.graphics.Color;
import android.util.StringBuilderPrinter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Zhenyu on 2017-05-06.
 */

public class MySimpleArrayAdapter extends ArrayAdapter<String>  {
    private final Context context;
    private final String[] titles;
    private String[] decriptions;
    private boolean[] checked;

    public MySimpleArrayAdapter(Context context, String[] titles) {
        super(context, R.layout.listviewlayout, titles);
        this.context = context;
        this.titles = titles;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.listviewlayout, parent, false);


        //title
        TextView textView_title = (TextView) rowView.findViewById(R.id.title1);
        textView_title.setText(titles[position]);
        if(checked[position]){
            textView_title.setTextColor(Color.RED);
        }
        else{
            textView_title.setTextColor(Color.GRAY);
        }


        //description
        TextView textView_description = (TextView) rowView.findViewById(R.id.description);
        textView_description.setText(decriptions[position]);


        //CheckBox
        ImageView cb = (ImageView) rowView.findViewById(R.id.imageView_check);
        if(checked[position]){
            cb.setImageResource(R.drawable.ic_check_box_black_24dp);
        }
        else{
            cb.setImageResource(R.drawable.ic_check_box_outline_blank_black_24dp);
        }


        return rowView;
    }


    public void setDescription(String[] in) {
        decriptions = in;
    }

    public void setCheckBoxValue(boolean[] in) {
        checked = in;
    }

    public void setDecriptionsValue(String[] in) {
        decriptions = in;
    }


}
