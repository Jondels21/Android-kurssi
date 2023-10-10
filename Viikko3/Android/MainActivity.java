package com.example.elinkaari;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String message = "Counter: ";
    private int clickCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            clickCounter = savedInstanceState.getInt("COUNTER_VALUE", 0);
        }

        TextView helloText = findViewById(R.id.helloTextView);
        helloText.setText(message + clickCounter);

        Log.d("CREATE", "Activity onCreate");
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);

        // talletetaan counterin nykyinen arvo
        bundle.putInt("COUNTER_VALUE", clickCounter);

    }

    @Override
    protected void onRestoreInstanceState(Bundle bundle){
        super.onRestoreInstanceState(bundle);
        
    }

    public void buttonClicked(View view){
        clickCounter++;
        TextView helloText = findViewById(R.id.helloTextView);

        helloText.setText(message + clickCounter);
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("PAUSE", "Activity onPause");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("RESUME", "Activity onResume");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("DESTROY", "Activity onDestroy");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("START", "Activity onStart");
    }




}