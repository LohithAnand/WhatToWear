package com.example.k00410868.whattowear;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();
        String weatherData = bundle.getString("weatherData");

        if(weatherData != null && !weatherData.isEmpty()) {
            try {
                JSONObject weatherDataJsonObject = new JSONObject(weatherData);
                JSONArray weatherJsonArray = weatherDataJsonObject.getJSONArray("weather");
                JSONObject weatherDetailsJsonObject = weatherJsonArray.getJSONObject(0);
                String weatherCondition = weatherDetailsJsonObject.getString("main");

                Toast.makeText(this, (String) weatherCondition, Toast.LENGTH_LONG).show();

                Integer weatherId = weatherDetailsJsonObject.getInt("id");

                displayApparelsBasedOnWeather(weatherCondition, weatherId);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, (String) "Weather data is empty", Toast.LENGTH_LONG).show();
        }

    }

    public void displayApparelsBasedOnWeather(String weatherCondition, Integer weatherID) {
        TextView acc_val = (TextView) findViewById(R.id.acces_val);
        TextView top_val = (TextView) findViewById(R.id.top_val);
        TextView bottom_val = (TextView) findViewById(R.id.bottom_val);
        TextView jacket_val = (TextView) findViewById(R.id.jacket_val);
        TextView shoe_val = (TextView) findViewById(R.id.shoe_val);
        TextView extra_val = (TextView) findViewById(R.id.extra_val);
        acc_val.setText("--");
        top_val.setText("--");
        bottom_val.setText("--");
        jacket_val.setText("--");
        shoe_val.setText("--");

        //https://openweathermap.org/weather-conditions
        if(weatherID >= 200 && weatherID < 300) {
            //Thunderstorm
            acc_val.setText("Water proof Rain cap");
            top_val.setText("2 layers shirt/tee");
            bottom_val.setText("Water proof Rain pants");
            jacket_val.setText("Water proof Rain coat");
            shoe_val.setText("Clogs/water proof boots");
            extra_val.setText("USe an umbrella. Try to stay indoors and be safe.");
        } else if(weatherID >= 300 && weatherID < 400) {
            //Drizzle
            acc_val.setText("Water proof Rain cap");
            top_val.setText("2 layers shirt/tee");
            bottom_val.setText("Water resistant Levis Denim");
            jacket_val.setText("Water resistant Jacket");
            shoe_val.setText("Water resistant shoes");
            extra_val.setText("Carry an umbrella and watchout for Rain.");
        } else if(weatherID >= 500 && weatherID < 600) {
            //Rain
            acc_val.setText("Water proof Rain cap");
            top_val.setText("2 layers shirt/tee");
            bottom_val.setText("Water resistant Levis Denim");
            jacket_val.setText("Water proof rain Jacket");
            shoe_val.setText("Water proof shoes");
            extra_val.setText("Use an umbrella and watchout for thuderstorms.");
        } else if(weatherID >= 600 && weatherID < 700) {
            //Snow
            acc_val.setText("Thermal cap");
            top_val.setText("Shirt over a thermals top");
            bottom_val.setText("Denim over a thermal bottom");
            jacket_val.setText("Winter jacket");
            shoe_val.setText("Snow proof boots");
            extra_val.setText("Enjoy the snow.");
        } else if(weatherID >= 700 && weatherID < 800) {
            //Atmosphere
            acc_val.setText("Shades to protect from wind and dust");
            top_val.setText("1 layer tee/shirt");
            bottom_val.setText("Shorts/Joggers/Denim");
            jacket_val.setText("Wind cheater/Summer jacket");
            shoe_val.setText("Slip on shoes/clogs");
            extra_val.setText("Watch out for fog, dust, mist..");
        } else if (weatherID == 800) {
            //Clear sky
            acc_val.setText("Light sunglasses");
            top_val.setText("Tee/Casual shirt");
            bottom_val.setText("Shorts/Chinos/Joggers");
            jacket_val.setText("--");
            shoe_val.setText("Flipflops/sandals/snikers");
            extra_val.setText("A perfect day to hangout and relax. Have fun!");
        } else if(weatherID >= 801 && weatherID < 900) {
            //Clouds
            acc_val.setText("Cap");
            top_val.setText("Tee/Casual shirt");
            bottom_val.setText("Shorts/Chinos/Joggers");
            jacket_val.setText("Water, wind resistant jacket");
            shoe_val.setText("Clogs/Sports shoe");
            extra_val.setText("Carry an umbrella or a rain coat as there is a chance of rain");
        } else if(weatherID >= 900 && weatherID < 1000) {
            //Extreme weather conditions. Stay home!
            extra_val.setText("The weather condition is Extreme. Try to stay at home!");
        } else {
            extra_val.setText("Sorry! The app is unable to determine the apparels at this moment. Please report to the developer.");
        }
    }

}
