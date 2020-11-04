package com.example.covid_19updates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_country_data.*


class CountryData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_data)


        val actionBar = supportActionBar

        val country = intent.getStringExtra("country")
        val cases = intent.getStringExtra("cases")
        val todayCases = intent.getStringExtra("todayCases")
        val deaths = intent.getStringExtra("deaths")
        val todayDeaths = intent.getStringExtra("todayDeaths")
        val recovered = intent.getStringExtra("recovered")
        val active = intent.getStringExtra("active")
        val critical = intent.getStringExtra("critical")
        val casesPerOneMillion = intent.getStringExtra("casesPerOneMillion")
        val deathsPerOneMillion = intent.getStringExtra("deathsPerOneMillion")
        val totalTests = intent.getStringExtra("totalTests")
        val testsPerOneMillion = intent.getStringExtra("testsPerOneMillion")


        actionBar!!.title = country
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)


        CovidCases.text = cases
        CovidTodayCases.text = todayCases
        CovidDeaths.text = deaths
        CovidTodayDeaths.text = todayDeaths
        CovidRecovered.text = recovered
        CovidActive.text = active
        CovidCritical.text = critical
        CovidCasesPerOneMillion.text = casesPerOneMillion
        CovidDeathsPerOneMillion.text = deathsPerOneMillion
        CovidTotalTests.text = totalTests
        CovidTestsPerOneMillion.text = testsPerOneMillion
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
