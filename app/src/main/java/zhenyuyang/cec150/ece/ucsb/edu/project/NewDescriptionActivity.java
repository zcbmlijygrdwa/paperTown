package zhenyuyang.cec150.ece.ucsb.edu.project;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewDescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_description);

        //add button
        Button button = (Button) findViewById(R.id.button_new_description);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent returnIntent = new Intent();
                EditText ev = (EditText) findViewById(R.id.editText_new_description);
                    returnIntent.putExtra("result", ev.getText().toString());
                    setResult(Activity.RESULT_OK, returnIntent);
                    finish();


                //if don't want to return data:
//                Intent returnIntent = new Intent();
//                setResult(Activity.RESULT_CANCELED, returnIntent);
//                finish();

            }

        });

    }
}
