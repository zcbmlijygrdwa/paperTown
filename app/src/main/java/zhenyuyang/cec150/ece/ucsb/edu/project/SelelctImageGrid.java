package zhenyuyang.cec150.ece.ucsb.edu.project;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Zhenyu on 2017-05-08.
 */

public class SelelctImageGrid extends BaseAdapter {
    private Context mContext;
    private final String[] web;
    private  int[] Imageid;
    private  Uri[] ImageUris;





    public SelelctImageGrid(Context c,String[] web,int[] Imageid ) {
        mContext = c;
        this.Imageid = Imageid;
        this.web = web;
    }

    public SelelctImageGrid(Context c,String[] web,Uri[] ImageUris ) {
        mContext = c;
        this.ImageUris = ImageUris;
        this.web = web;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return ImageUris.length+1;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            if(position!=ImageUris.length) {
                grid = new View(mContext);
                grid = inflater.inflate(R.layout.grid_single, null);
                //TextView textView = (TextView) grid.findViewById(R.id.grid_text);
                ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
                //textView.setText(web[position]);
                //imageView.setImageResource(Imageid[position]);
                imageView.setImageURI(ImageUris[position]);
            }
            else{
                grid = new View(mContext);
                grid = inflater.inflate(R.layout.grid_single, null);
                //TextView textView = (TextView) grid.findViewById(R.id.grid_text);
                ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
                //textView.setText(web[position]);
                imageView.setBackgroundColor(Color.GRAY);
                imageView.setImageResource(R.drawable.ic_add_white_48dp);
                //imageView.setImageURI(ImageUris[position]);
            }
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}