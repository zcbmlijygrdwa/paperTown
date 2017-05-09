package zhenyuyang.cec150.ece.ucsb.edu.project;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class SelectImageActivity extends AppCompatActivity {

    Uri[] imageUris;
    final int NEW_PHOTO_REQUEST = 5;
    GridView grid;
    String[] web = {
            "Google"
    } ;
    int[] imageId = {
            R.drawable.test,
            R.drawable.test,
            R.drawable.test,
            R.drawable.test,
            R.drawable.test,
            R.drawable.test,
            R.drawable.test,
            R.drawable.test,
            R.drawable.test,
            R.drawable.test,
            R.drawable.test,
            R.drawable.test,
            R.drawable.test,
            R.drawable.test,
            R.drawable.test

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_image);

        String s = getIntent().getStringExtra(EXTRA_MESSAGE);
        Log.i("onActivityResult", "getStringExtra = " + s);

//         imageUris = { Uri.parse(s),
//                Uri.parse(s),
//                Uri.parse(s)};

        imageUris = addUri(imageUris,Uri.parse(s));

        SelelctImageGrid adapter = new SelelctImageGrid(SelectImageActivity.this, web, imageUris);
        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Log.i("addOnItemTouchListener", "onItemClick position =" + position);
                //Toast.makeText(MainActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });



        Button button_add_more_image = (Button) findViewById(R.id.button_add_more_image);
        button_add_more_image.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //stat camera rool
                Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickPhoto , NEW_PHOTO_REQUEST);//one can be replaced with any action code
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to


        if (requestCode == NEW_PHOTO_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                Uri selectedImageURI = data.getData();
                Log.i("onActivityResult", "result = " + selectedImageURI.toString());

                //Uri[] imageUris = { selectedImageURI,selectedImageURI,selectedImageURI};
                imageUris = addUri(imageUris,selectedImageURI);

                SelelctImageGrid adapter = new SelelctImageGrid(SelectImageActivity.this, web, imageUris);
                Log.i("onActivityResult", "imageUris.length = " + imageUris.length);
                grid=(GridView)findViewById(R.id.grid);
                grid.setAdapter(adapter);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Log.i("onActivityResult", "NEW_TITLE_REQUEST RESULT_CANCELED");
                //Write your code if there's no result
            }
        }

    }

    Uri[] addUri(Uri[] urilist, Uri in) {
        if(urilist!=null) {
            Uri[] output = new Uri[urilist.length+1];

            for (int i = 0; i < urilist.length; i++) {
                output[i] = urilist[i];
            }
            output[urilist.length] = in;
            return output;
        }
        else{
            Uri[] output = {in};
            return output;
        }



    }

}
