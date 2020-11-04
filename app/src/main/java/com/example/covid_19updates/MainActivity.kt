package com.example.covid_19updates

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONException

class MainActivity : AppCompatActivity(), CountryClicked {

    var arrayList = ArrayList<Model>()
    val myAdapter:MyAdapter = MyAdapter(arrayList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getUpdates()

        refresh_btn.setOnClickListener {
            getUpdates()
        }

    }

    private fun getUpdates() {
        // Instantiate the RequestQueue.
        val url = "https://coronavirus-19-api.herokuapp.com/countries"
        val requestQueue: RequestQueue = Volley.newRequestQueue(this)
        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, url,
                null, Response.Listener<JSONArray?> { response ->
            try {
                for (i in 0 until response!!.length()) {
                    val obj = response.getJSONObject(i)
                    arrayList.add(Model(obj.getString("country"), "Cases: " +obj!!.getString("cases"), "Today Cases: "+obj.getString("todayCases"), "Deaths: "+obj.getString("deaths"), "Today Deaths: "+obj.getString("todayDeaths"), "Recovered: "+obj.getString("recovered"), "Active: "+obj.getString("active"), "Critical: "+obj.getString("critical"), "Cases Per One Million: "+obj.getString("casesPerOneMillion"), "Deaths Per One Million: "+obj.getString("deathsPerOneMillion"), "Total Tests: "+obj.getString("totalTests"),"Tests Per One Million: "+ obj.getString("testsPerOneMillion")))
                    recycler_view.layoutManager = LinearLayoutManager(this)
                    recycler_view.adapter = myAdapter
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }, Response.ErrorListener {
            Toast.makeText(this@MainActivity, "Something went wrong!", Toast.LENGTH_SHORT).show()
        })

        // Add the request to the RequestQueue.
        MySingleton.getInstance(this).addToRequestQueue(jsonArrayRequest)
    }

    override fun onItemClicked(item: Model) {
        val country = item.country
        val cases = item.cases
        val todayCases = item.todaycases
        val deaths = item.deaths
        val todayDeaths = item.todaydeaths
        val recovered = item.recovered
        val active = item.active
        val critical = item.critical
        val casesPerOneMillion = item.casesperonemillion
        val deathsPerOneMillion = item.deathsperonemillion
        val totalTests = item.totaltests
        val testsPerOneMillion = item.testsperonemillion

        val intent = Intent(this, CountryData::class.java)
        intent.putExtra("country", country)
        intent.putExtra("cases", cases)
        intent.putExtra("todayCases", todayCases)
        intent.putExtra("deaths", deaths)
        intent.putExtra("todayDeaths", todayDeaths)
        intent.putExtra("recovered", recovered)
        intent.putExtra("active", active)
        intent.putExtra("critical", critical)
        intent.putExtra("casesPerOneMillion", casesPerOneMillion)
        intent.putExtra("deathsPerOneMillion", deathsPerOneMillion)
        intent.putExtra("totalTests", totalTests)
        intent.putExtra("testsPerOneMillion", testsPerOneMillion)
        startActivity(intent)
//        Toast.makeText(this, "Clicked Country is: ${item.country}", Toast.LENGTH_SHORT).show()
    }
}