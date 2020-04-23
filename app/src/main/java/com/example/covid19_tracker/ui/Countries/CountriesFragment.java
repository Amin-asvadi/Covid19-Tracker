package com.example.covid19_tracker.ui.Countries;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.covid19_tracker.MainActivity;
import com.example.covid19_tracker.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CountriesFragment extends Fragment{

RecyclerView rvcounteryes;
ProgressBar progressBar;
ArrayList<CovidCountries> covidCountries;
    JSONObject obj;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contries, container, false);
            rvcounteryes = root.findViewById(R.id.rvCovidCountry);
            progressBar =root.findViewById(R.id.progress_circular_country);
            rvcounteryes.setLayoutManager(new LinearLayoutManager(getActivity()));
            GetDataFromServer();
        return root;
    }
    private void showRecyclerView(){

        CovidCountryAdapter covidCountryAdapter = new CovidCountryAdapter(covidCountries,getContext());
        rvcounteryes.setAdapter(covidCountryAdapter);

    }

    private void GetDataFromServer() {
        String url = "https://corona.lmao.ninja/v2/countries";
        covidCountries = new ArrayList<>();
        final StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    progressBar.setVisibility(View.GONE);
                    try {
                        JSONArray jsonArray = new JSONArray(response);

                      /*  JSONObject j=new JSONObject(s)
                        j.getString("flag")*/
                        //String flag= response.getJsonArray("countryInfo").getString("flag");

                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject data = jsonArray.getJSONObject(i);
                            for (int j =0; j < jsonArray.length(); j++ ){
                                 obj = data.getJSONObject("countryInfo");

                            }
                            covidCountries.add(new CovidCountries(data.getString("country"),
                                    data.getString("cases"),
                                    obj.getString("flag"),
                                    data.getString("todayCases"),
                                    data.getString("deaths"),
                                    data.getString("todayDeaths"),
                                    data.getString("recovered")));

                        }
                        showRecyclerView();
                    } catch (JSONException e) {
                        e.printStackTrace()  ;
                    }

                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressBar.setVisibility(View.GONE);
                    }

    });
        Volley.newRequestQueue(getActivity()).add(stringRequest);
    }

}
