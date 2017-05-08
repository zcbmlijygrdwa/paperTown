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
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class newTown extends AppCompatActivity {
    static ListView listview;

    final int NEW_TITLE_REQUEST = 0;
    final int NEW_ADDRESS_REQUEST = 1;
    final int NEW_CATEGORY_REQUEST = 2;
    final int NEW_DESCRIPTION_REQUEST = 3;
    final int NEW_INFORMATION_REQUEST =4;

    String title = "";
    String address = "";
    String category = "";
    String description = "";
    String information = "";

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



        //set up imageview onclick
        ImageView selectImage = (ImageView) findViewById(R.id.imageView);
        selectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("onClick", "selectImage click");
//                Toast.makeText(YourActivityName.this,
//                        "The favorite list would appear on clicking this icon",
//                        Toast.LENGTH_LONG).show();
                Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickPhoto , 1);//one can be replaced with any action code

            }
        });

        listview = (ListView) findViewById(R.id.listView);
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

        boolean[] checked = new boolean[]{false,
                false,
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

                if (position == 3) {
                    Intent intent = new Intent(getApplicationContext(), NewDescriptionActivity.class);
                    //intent.putExtra(EXTRA_MESSAGE, "asdf");
                    startActivityForResult(intent, NEW_DESCRIPTION_REQUEST);
                    overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                    //finish();// kill current activity
                }

                if (position == 4) {
                    Intent intent = new Intent(getApplicationContext(), NewInformationActivity.class);
                    //intent.putExtra(EXTRA_MESSAGE, "asdf");
                    startActivityForResult(intent, NEW_INFORMATION_REQUEST);
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
                address = result;
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
                category = result;
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Log.i("onActivityResult", "NEW_CATEGORY_REQUEST RESULT_CANCELED");
                //Write your code if there's no result
            }
        }

        if (requestCode == NEW_DESCRIPTION_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("result");
                Log.i("onActivityResult", "result = " + result);
                description = result;
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Log.i("onActivityResult", "NEW_DESCRIPTION_REQUEST RESULT_CANCELED");
                //Write your code if there's no result
            }
        }
        if (requestCode == NEW_INFORMATION_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("result");
                Log.i("onActivityResult", "result = " + result);
                information = result;
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Log.i("onActivityResult", "NEW_INFORMATION_REQUEST RESULT_CANCELED");
                //Write your code if there's no result
            }
        }


        //update view
        checkAllInformation();

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


     void checkAllInformation(){
        int counter = 0;

         Log.i("all", "title = "+title);
         Log.i("all", "address = "+address);
         Log.i("all", "category = "+category);
         Log.i("all", "description = "+description);
         Log.i("all", "information = "+information);



        if(title!=null&&!title.isEmpty()) {
            Log.i("checkAllInformation", "title!=null");
            counter++;
            setChecked(listview.getChildAt(0),title);
        }

         if(address!=null&&!address.isEmpty()) {
            Log.i("checkAllInformation", "address!=null");
            counter++;
            setChecked(listview.getChildAt(1),address);
        }

         if(category!=null&&!category.isEmpty()) {
            Log.i("checkAllInformation", "category!=null");
            counter++;
            setChecked(listview.getChildAt(2),category);
        }

         if(description!=null&&!description.isEmpty()) {
            Log.i("checkAllInformation", "description!=null");
            counter++;
            setChecked(listview.getChildAt(3),description);
        }

         if(information!=null&&!information.isEmpty()) {
            Log.i("checkAllInformation", "information!=null");
            counter++;
            setChecked(listview.getChildAt(4),information);
        }

        //update step left text view
         TextView textView_step_left = (TextView) findViewById(R.id.textView_step_left);
         textView_step_left.setText((5-counter)+" step left");

         //update progress bar
         ProgressBar pb = (ProgressBar)findViewById(R.id.progressBar);
         pb.setProgress(       (int)(100.0*(counter)/5.0 )   );

         //return counter;
    }

    void setChecked(View view,String in) {
        ImageView c = (ImageView) view.findViewById(R.id.imageView_check);
        c.setImageResource(R.drawable.ic_check_box_black_24dp);

        TextView title = (TextView) view.findViewById(R.id.title1);
        title.setTextColor(Color.RED);

        TextView description = (TextView) view.findViewById(R.id.description);
        description.setText(in);
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




