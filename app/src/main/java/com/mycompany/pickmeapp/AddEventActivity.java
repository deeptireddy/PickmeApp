package com.mycompany.pickmeapp;

import android.app.Activity;

import android.app.Notification;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.EditText;




import android.content.Context;
import android.widget.Button;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;


public class AddEventActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        // Initializing
        final EditText name = (EditText) findViewById(R.id.name);
        final EditText source=(EditText)findViewById(R.id.source);
        final EditText destination=(EditText)findViewById(R.id.destination);
        final EditText departure=(EditText)findViewById(R.id.departure);
        final EditText pay=(EditText)findViewById(R.id.pay);
        final EditText track=(EditText)findViewById(R.id.track);
        final EditText ppl=(EditText) findViewById(R.id.ppl);
        final Button btnsave = (Button) findViewById(R.id.btnsave);

        //Registering event Handlers

        final SQLiteDatabase db = openOrCreateDatabase("TRAVELLERDB", Context.MODE_PRIVATE, null);
        btnsave.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view) {
                // Adding a record
                if (view == btnsave) {
                    // Checking empty fields
                    if (source.getText().toString().trim().length() == 0 ||
                            destination.getText().toString().trim().length() == 0 ||
                            departure.getText().toString().trim().length() == 0) {
                        Toast.makeText(getApplicationContext(), "ERROR!!! Try Again =)",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                    // Inserting record
                    db.execSQL("INSERT INTO traveller VALUES('" + source.getText() + "','" + destination.getText() +
                            "','" + departure.getText() + "','" + pay.getText() + "','" + track.getText() + "','" + ppl.getText() + "');");
                    Toast.makeText(getApplicationContext(), "SUCCESS!!! Record Saved =)",
                            Toast.LENGTH_SHORT).show();
                    name.setText("");
                    source.setText("");
                    destination.setText("");
                    departure.setText("");
                    pay.setText("");
                    track.setText("");
                    ppl.setText("");
                    name.requestFocus();

                }
            }
            });

        // Creating Database

        db.execSQL("CREATE TABLE IF NOT EXISTS traveller(name VARCHAR,source VARCHAR,destination VARCHAR,departure VARCHAR,pay VARCHAR,track VARCHAR,ppl VARCHAR);");


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_event, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
