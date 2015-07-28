package com.mycompany.pickmeapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.content.Intent;
import android.app.ActionBar;
import android.view.View;



public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case R.id.action_addEvent:
                addEvent();
                return true;
            case R.id.action_fav:
                //           fav();
                return true;
            case R.id.action_sign:
                sign();
                return true;
            case R.id.action_settings:
                //           openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void addEvent() {
        Intent intent = new Intent(this, AddEventActivity.class);
        startActivity(intent);
    }

    public void sign() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


}
