package com.example.weatherapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getWeatherData(View view) {
        String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q=Tampere&appid=f1c838946ab2913a328da3dc7c8b3031&units=metric";
        StringRequest request = new StringRequest(Request.Method.GET, WEATHER_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Display the first 500 characters of the response string.
               // Toast.makeText(this, response, Toast.LENGTH_LONG).show();
                parseWeatherJsonAndUpdateUi(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
           //     Toast.makeText(this, "VERKKOVIRHE", Toast.LENGTH_LONG).show();
            }
        });
        // Lähetetään request
        Volley.newRequestQueue(this).add(request);
    }

    private void parseWeatherJsonAndUpdateUi(String response) {
        try {
            JSONObject weatherJSON = new JSONObject(response);
            String weather = weatherJSON.getJSONArray("weather").getJSONObject(0).getString("main");
            double temperature = weatherJSON.getJSONObject("main").getDouble("temp");
            double wind = weatherJSON.getJSONObject("wind").getDouble("speed");

            TextView temperatureTextView = findViewById(R.id.tempTextView);
            temperatureTextView.setText("" + temperature + "C");

            TextView windTextView = findViewById(R.id.windSpeedTextView);
            windTextView.setText("" + wind + "m/s");

            TextView weatherTextView = findViewById(R.id.weatherTextView);
            weatherTextView.setText(weather);
        } catch(JSONException e){
            throw new RuntimeException(e);
        }
    }

    public void openForeca(View view) {
        String foreca = "https://www.foreca.fi";
        Uri forecaUri = Uri.parse(foreca);
        Intent intent = new Intent(Intent.ACTION_VIEW, forecaUri);
        try{
            startActivity(intent);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}