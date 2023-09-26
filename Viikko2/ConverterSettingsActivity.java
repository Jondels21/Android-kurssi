package com.example.valuuttamuunnin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ConverterSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter_settings);
        // Luetaan intent josta tämä käynnistettiin
        Intent intent = getIntent();
        String message = intent.getStringExtra("HELLO_MESSAGE");

        String homeCurrency = intent.getStringExtra("HOME_CURRENCY");
        String destinationCurrency = intent.getStringExtra("DESTINATION_CURRENCY");

        EditText homeCurrencyEditSettings = findViewById(R.id.homeCurrencyEditSettings);
        EditText destinationCurrencyEditSettings = findViewById(R.id.destinationCurrencyEditSettings);

        homeCurrencyEditSettings.setText(homeCurrency);
        destinationCurrencyEditSettings.setText(destinationCurrency);

        // Laitetaan viesti näytölle
        TextView messageTextView = findViewById(R.id.messageTextView);
        messageTextView.setText(message);
    }

    public void backToConverter(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        EditText editTextConversionRate = findViewById(R.id.editTextConversionRate);

        String conversionRateInput = editTextConversionRate.getText().toString();

        float conversionRate = Float.parseFloat(conversionRateInput);
        intent.putExtra("CONVERSION_RATE", conversionRate);

        EditText homeCurrencyEditSettings = findViewById(R.id.homeCurrencyEditSettings);
        String HOME_CURRENCY = homeCurrencyEditSettings.getText().toString();
        intent.putExtra("HOME_CURRENCY", HOME_CURRENCY);

        EditText destinationCurrencyEditSettings = findViewById(R.id.destinationCurrencyEditSettings);
        String DESTINATION_CURRENCY = destinationCurrencyEditSettings.getText().toString();
        intent.putExtra("DESTINATION_CURRENCY", DESTINATION_CURRENCY);

        startActivity(intent);
    }
}