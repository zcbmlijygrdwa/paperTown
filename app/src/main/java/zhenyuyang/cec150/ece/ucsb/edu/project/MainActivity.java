package zhenyuyang.cec150.ece.ucsb.edu.project;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    MapView mapView;
    GoogleMap map;


    Context context;
    private List<Person> persons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


        context = getApplicationContext();
        RecyclerView rv = (RecyclerView)findViewById(R.id.recyclerview);
        rv.setHasFixedSize(true);  //If you are sure that the size of the RecyclerView won't be changing, you can add the following to improve performance
        LinearLayoutManager llm = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,
                false);
        rv.setLayoutManager(llm);

        initializeData();

        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);

        rv.addOnItemTouchListener(
                new RecyclerItemClickListener(context, rv ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Log.i("addOnItemTouchListener","onItemClick position ="+position);
                        // do whatever
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );


    }

    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Emma asdfasdffsda", "asdfasdffsda", R.drawable.test));
        persons.add(new Person("asdfasdffsda Maiss", "asdfasdffsda years asdfasdffsda", R.drawable.test));
        persons.add(new Person("asdfasdffsda Watts", "35 years asdfasdffsda", R.drawable.test));
        persons.add(new Person("asdfasdffsda Maiss", "sadf asdfasdffsda old", R.drawable.test));
        persons.add(new Person(" asdfasdffsda Maiss", "sadf years asdfasdffsda", R.drawable.test));
        persons.add(new Person("Lavasdery asdfasdffsda", "25 years asdfasdffsda", R.drawable.test));
        persons.add(new Person("asdfasdffsda dWatts", "ss asdfasdffsda old", R.drawable.test));
        persons.add(new Person("Lsadf Maiss", "asdfasdffsda years old", R.drawable.test));
        persons.add(new Person("Lsadf Maiss", "asdfasdffsda years asdfasdffsda", R.drawable.test));
        persons.add(new Person("Lavery Maiss", "asdfasdffsda years old", R.drawable.test));
        persons.add(new Person("L olewdy Maiss", "25 asdfasdffsda asdfasdffsda", R.drawable.test));
        persons.add(new Person("Lillidsae Watts", "35 asdfasdffsda asdfasdffsda", R.drawable.test));
        persons.add(new Person("Lavery Maiss", "25 years asdfasdffsda", R.drawable.test));
        persons.add(new Person("Laveasdry Maiss", "25 years old", R.drawable.test));
        persons.add(new Person("Laverery Maiss", "25 years old", R.drawable.test));
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

        if (id == R.id.action_search) {
            Log.i("manu","action_search");
            return true;
        }


        if (id == R.id.action_create) {
            Log.i("manu","action_create");

            Intent intent = new Intent(this, newTown.class);
            intent.putExtra(EXTRA_MESSAGE, "asdf");
            startActivity(intent);
            overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
