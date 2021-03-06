package com.example.covid19_tracker.ui.Countries;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.covid19_tracker.MainActivity;
import com.example.covid19_tracker.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.app.PendingIntent.getActivity;

public class CovidCountryAdapter extends RecyclerView.Adapter<CovidCountryAdapter.ViewHolder> {
    ArrayList<CovidCountries> covidCountries;
Context context;
    public CovidCountryAdapter(ArrayList<CovidCountries> covidCountries, Context context){
        this.covidCountries = covidCountries;
        this.context = context;
    }
    @NonNull
    @Override
    public CovidCountryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_covid_contries,parent,false);


        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull CovidCountryAdapter.ViewHolder holder, final int position) {
final CovidCountries covidCountry = covidCountries.get(position);
holder.tvConteryName.setText(covidCountry.getmCovidCountries());
holder.tvTotalCases.setText(covidCountry.getmCases());
Picasso.with(context).load(covidCountry.getImgcountry()).into(holder.imageView);
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent details = new Intent(context,DetailsActivity.class);
        details.putExtra("contryimg",covidCountry.getImgcountry());
        details.putExtra("totoalcases",covidCountry.getmCases());
        details.putExtra("todaycases",covidCountry.getmTodayCases());
        details.putExtra("deaths",covidCountry.getmDeaths());
        details.putExtra("todayDeaths",covidCountry.getmTodayDeaths());
        details.putExtra("totalrecoverd",covidCountry.getmRecovered());
        context.startActivity(details);

    }
});
    }

    @Override
    public int getItemCount() {
        return covidCountries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTotalCases,tvConteryName;
        ImageView imageView;
        View mview;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mview = itemView;
            imageView = itemView.findViewById(R.id.imgcountry);
            tvTotalCases = itemView.findViewById(R.id.tvTotalcases);
            tvConteryName = itemView.findViewById(R.id.tvTotalCountries);
        }

    }
}
