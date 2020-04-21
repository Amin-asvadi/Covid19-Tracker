package com.example.covid19_tracker.ui.Countries;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.covid19_tracker.R;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {



    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Bundle countryData = getIntent().getExtras();
        String cflag = countryData.getString("contryimg");
        imageView = findViewById(R.id.flagimg);
        Picasso.with(this).load(cflag).into(imageView);
    }
}
