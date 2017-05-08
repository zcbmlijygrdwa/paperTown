package zhenyuyang.cec150.ece.ucsb.edu.project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class newTown extends AppCompatActivity {
    final int NEW_TITLE_REQUEST = 0;
    final int NEW_ADDRESS_REQUEST = 1;
    final int NEW_CATEGORY_REQUEST = 2;
    final int NEW_INFORMATION_REQUEST =3;

    String title = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_town);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        final ListView listview = (ListView) findViewById(R.id.listView);
        String[] values = new String[]{"Add Title",
                "Set Address",
                "Select Category",
                "Add Description",
                "Yout Information"};

        String[] decriptions = new String[]{"Give a name to the item",
                "Where did you find the item",
                "What is the type of the item",
                "Be precise, consise and professional",
                "Required to keep track of the item"};

        boolean[] checked = new boolean[]{true,
                true,
                false,
                false,
                false};


        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }


        final MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this, values);

        //send data to the adaptor
        adapter.setCheckBoxValue(checked);
        adapter.setDecriptionsValue(decriptions);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {

                Log.i("onClick", "click");
                Log.i("onClick", "position = " + position);


                if (position == 0) {
                    Intent intent = new Intent(getApplicationContext(), NewTitleActivity.class);
                    //intent.putExtra(EXTRA_MESSAGE, "asdf");
                    startActivityForResult(intent, NEW_TITLE_REQUEST);
                    overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                    //finish();// kill current activity
                }

                if (position == 1) {
                    Intent intent = new Intent(getApplicationContext(), NewAddressActivity.class);
                    //intent.putExtra(EXTRA_MESSAGE, "asdf");
                    startActivityForResult(intent, NEW_ADDRESS_REQUEST);
                    overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                    //finish();// kill current activity
                }

                if (position == 2) {
                    Intent intent = new Intent(getApplicationContext(), NewCategoryActivity.class);
                    //intent.putExtra(EXTRA_MESSAGE, "asdf");
                    startActivityForResult(intent, NEW_CATEGORY_REQUEST);
                    overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                    //finish();// kill current activity
                }



            }

        });

        //test

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to


        if (requestCode == NEW_TITLE_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("result");
                Log.i("onActivityResult", "result = " + result);
                title = result;
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Log.i("onActivityResult", "NEW_TITLE_REQUEST RESULT_CANCELED");
                //Write your code if there's no result
            }
        }


        if (requestCode == NEW_ADDRESS_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("result");
                Log.i("onActivityResult", "result = " + result);
                title = result;
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Log.i("onActivityResult", "NEW_ADDRESS_REQUEST RESULT_CANCELED");
                //Write your code if there's no result
            }
        }

        if (requestCode == NEW_CATEGORY_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("result");
                Log.i("onActivityResult", "result = " + result);
                title = result;
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Log.i("onActivityResult", "NEW_CATEGORY_REQUEST RESULT_CANCELED");
                //Write your code if there's no result
            }
        }

    }


    //dynamically get view
    public View getViewByPosition(int pos, ListView listView) {
        final int firstListItemPosition = listView.getFirstVisiblePosition();
        final int lastListItemPosition = firstListItemPosition + listView.getChildCount() - 1;

        if (pos < firstListItemPosition || pos > lastListItemPosition) {
            return listView.getAdapter().getView(pos, null, listView);
        } else {
            final int childIndex = pos - firstListItemPosition;
            return listView.getChildAt(childIndex);
        }
    }

    void setChecked(View view) {
        ImageView c = (ImageView) view.findViewById(R.id.imageView_check);
        c.setImageResource(R.drawable.ic_check_box_black_24dp);

        TextView title = (TextView) view.findViewById(R.id.title1);
        title.setTextColor(Color.RED);
    }

    void setUnchecked(View view) {
        ImageView c = (ImageView) view.findViewById(R.id.imageView_check);
        c.setImageResource(R.drawable.ic_check_box_outline_blank_black_24dp);

        TextView title = (TextView) view.findViewById(R.id.title1);
        title.setTextColor(Color.GRAY);
    }


    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }


}




