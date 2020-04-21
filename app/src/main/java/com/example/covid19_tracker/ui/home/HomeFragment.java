package com.example.covid19_tracker.ui.home;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.covid19_tracker.MainActivity;
import com.example.covid19_tracker.R;
import com.example.covid19_tracker.ui.Countries.CovidCountryAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.ReferenceQueue;

public class HomeFragment extends Fragment {

    private TextView tvComfirmd, tvDeaths, tvRecoverd;
    ProgressBar progressBar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        tvComfirmd = root.findViewById(R.id.tvTotalComfirmd);
        tvDeaths = root.findViewById(R.id.tvTotalDeath);
        tvRecoverd = root.findViewById(R.id.tvTotalRecoverd);
        progressBar = root.findViewById(R.id.progress_circular_home);
        getData();
        return root;
    }

    private void getData() {
        RequestQueue queue = Volley.newRequestQueue(getActivity());

        String url = "https://corona.lmao.ninja/v2/all";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);
                try {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    tvComfirmd.setText(jsonObject.getString("cases"));
                    tvDeaths.setText(jsonObject.getString("deaths"));
                    tvRecoverd.setText(jsonObject.getString("recovered"));
                    Toast.makeText(getActivity(), "vared shod", Toast.LENGTH_SHORT).show();


                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(), "vared nashod", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
            }

        });
        queue.add(stringRequest);
    }
}
