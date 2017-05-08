package zhenyuyang.cec150.ece.ucsb.edu.project;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_information);

        //add button
        Button button = (Button) findViewById(R.id.button_new_information_done);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent returnIntent = new Intent();
                EditText ev1 = (EditText) findViewById(R.id.editText_new_firstName);
                EditText ev2 = (EditText) findViewById(R.id.editText_new_lastName);
                returnIntent.putExtra("result", ev1.getText().toString()+","+ev2.getText().toString());
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });

    }
}
