package com.example.valuuttamuunnin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private float conversionRate = 1.0f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        conversionRate = intent.getFloatExtra("CONVERSION_RATE", 1.0f);

        String home_message = intent.getStringExtra("HOME_CURRENCY");
        TextView homeCurrencyTextView = findViewById(R.id.homeCurrencyTextView);

        if(home_message != null){
            homeCurrencyTextView.setText(home_message);
        }else {
            homeCurrencyTextView.setText(R.string.eur);
        }

        String destination_message = intent.getStringExtra("DESTINATION_CURRENCY");
        TextView destinationCurrencyTextView = findViewById(R.id.destinationCurrencyTextView);

        if(destination_message != null){
            destinationCurrencyTextView.setText(destination_message);
        }else{
            destinationCurrencyTextView.setText(R.string.usd);
        }

    }

    public void openSettings(View view) {
        //Todo: avaa asetukset näkymä ja välitä sinne viesti tästä aktiviteetista
       // TextView homeCurrencyTextView = findViewById(R.id.homeCurrencyTextView);
      //  homeCurrencyTextView.setText("Hello");
        Intent intent = new Intent(this, ConverterSettingsActivity.class);
        intent.putExtra("HELLO_MESSAGE", "Hello from main..");

        TextView homeCurrencyTextView = findViewById(R.id.homeCurrencyTextView);
        TextView destinationCurrencyTextView = findViewById(R.id.destinationCurrencyTextView);

        String homeCurrency = homeCurrencyTextView.getText().toString();
        String destinationCurrency = destinationCurrencyTextView.getText().toString();

        intent.putExtra("HOME_CURRENCY", homeCurrency);
        intent.putExtra("DESTINATION_CURRENCY", destinationCurrency);
        startActivity(intent);
    }

    public void convertCurrency(View view) {
        EditText homeCurrencyEditText = findViewById(R.id.homeCurrencyEditText);
        EditText destinationCurrencyEditText = findViewById(R.id.destinationCurrencyEditText);


        String homeCurrencyInput = homeCurrencyEditText.getText().toString();
        float homeCurrencyAmount = Float.parseFloat(homeCurrencyInput);

        float destinationCurrency = homeCurrencyAmount * conversionRate;

        destinationCurrencyEditText.setText(String.valueOf(destinationCurrency));

    }

    public void swapCurrency(View view) {

        TextView homeCurrencyTextView = findViewById(R.id.homeCurrencyTextView);
        TextView destinationCurrencyTextView = findViewById(R.id.destinationCurrencyTextView);

        EditText homeCurrencyEditText = findViewById(R.id.homeCurrencyEditText);
        EditText destinationCurrencyEditText = findViewById(R.id.destinationCurrencyEditText);

        String home = homeCurrencyEditText.getText().toString();
        String destination = destinationCurrencyEditText.getText().toString();

        float homeValue = Float.parseFloat(home);
        float destinationValue = Float.parseFloat(destination);

        homeCurrencyEditText.setText(String.valueOf(destinationValue));
        destinationCurrencyEditText.setText(String.valueOf(homeValue));

        String homeCurrency = homeCurrencyTextView.getText().toString();
        String destinationCurrency = destinationCurrencyTextView.getText().toString();

        homeCurrencyTextView.setText(destinationCurrency);
        destinationCurrencyTextView.setText(homeCurrency);

    }
}