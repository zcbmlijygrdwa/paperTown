package zhenyuyang.cec150.ece.ucsb.edu.project;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class NewCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_category);


        Button button1 = (Button) findViewById(R.id.button_cate1);
        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result","place");
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });

        Button button2 = (Button) findViewById(R.id.button_cate2);
        button2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result","creature");
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });

        Button button3 = (Button) findViewById(R.id.button_cate3);
        button3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result","event");
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });



    }
}
