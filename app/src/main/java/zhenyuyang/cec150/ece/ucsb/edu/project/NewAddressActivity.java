package zhenyuyang.cec150.ece.ucsb.edu.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class NewAddressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_address);



        SupportMapFragment mapFragment = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_new_address));

        if (mapFragment != null) {
            mapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap map) {


                    BitmapDescriptor icon1 = BitmapDescriptorFactory.fromResource(R.drawable.test_marker3);
                    BitmapDescriptor icon2 = BitmapDescriptorFactory.fromResource(R.drawable.test_marker3);
                    BitmapDescriptor icon3 = BitmapDescriptorFactory.fromResource(R.drawable.test_marker3);


                    //add markers
                    map.addMarker(new MarkerOptions().position(new LatLng(34.415320, -119.840233))
                            .title("Ohh!")
                            .snippet("TsadADSadsA")
                            .icon(icon1));

                    map.addMarker(new MarkerOptions().position(new LatLng(34.416875, -119.826565))
                            .title("Underclass beauty")
                            .snippet("Get sunburn in my head")
                            .icon(icon2));

                    map.addMarker(new MarkerOptions().position(new LatLng(34.409815, -119.845069))
                            .title("Big thing!")
                            .snippet("Meat carnival")
                            .icon(icon3));

                    //end of adding markers


                    //camera animation
                    //map.moveCamera(CameraUpdateFactory.newLatLngZoom(/*some location*/, 10));

                    if (map != null) {
                        map.moveCamera(
                                CameraUpdateFactory.newLatLngZoom(new LatLng(34.414913, -119.839406), 15));  //gps and zoom level
                    }


                    //end of camera animation


                }
            });
        } else {

            Log.i("manu", "Error - Map Fragment was null!!");
        }



    }
}
