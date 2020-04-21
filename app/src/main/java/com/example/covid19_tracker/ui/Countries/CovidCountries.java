package com.example.covid19_tracker.ui.Countries;

public class CovidCountries {
    String mCovidCountries, mCases,mTodayCases,mDeaths,mTodayDeaths,mRecovered,mCritial,imgcountry;

    public CovidCountries() {
    }

    public CovidCountries(String mCovidCountries, String mCases,String imgcountry) {
        this.mCovidCountries = mCovidCountries;
        this.mCases = mCases;
        this.imgcountry = imgcountry;
        this.mTodayCases = mTodayCases;
        this.mDeaths = mDeaths;
        this.mTodayDeaths = mTodayDeaths;
        this.mRecovered = mRecovered;
        this.mCritial = mCritial;
    }
    public String getImgcountry() {
        return imgcountry;
    }

    public String getmCovidCountries() {
        return mCovidCountries;
    }

    public String getmCases() {
        return mCases;
    }
}
