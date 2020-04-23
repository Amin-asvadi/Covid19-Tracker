package com.example.covid19_tracker.ui.Countries;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covid19_tracker.R;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {


    TextView totalcases,todaycases,mdathe,todaydath,mrecoverd;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Bundle countryData = getIntent().getExtras();
        String cflag = countryData.getString("contryimg");
        imageView = findViewById(R.id.flagimg);
        Picasso.with(this).load(cflag).into(imageView);
        totalcases = findViewById(R.id.totoalsum);
        todaycases = findViewById(R.id.todaycases);
        mdathe = findViewById(R.id.dathesum);
        todaydath = findViewById(R.id.todaydathe);
        mrecoverd = findViewById(R.id.rcoverdtotal);
        mrecoverd.setText(countryData.getString("totalrecoverd"));
        todaydath.setText(countryData.getString("todayDeaths"));
        mdathe.setText(countryData.getString("deaths"));
        totalcases.setText(countryData.getString("totoalcases"));
        todaycases.setText(countryData.getString("todaycases"));

    }
}
