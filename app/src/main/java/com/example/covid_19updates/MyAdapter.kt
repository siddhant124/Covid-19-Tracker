package com.example.covid_19updates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row.view.*


class MyAdapter(private val items: ArrayList<Model>, private val listener: CountryClicked): RecyclerView.Adapter<CoronaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoronaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        val viewHolder = CoronaViewHolder(view)
        view.setOnClickListener {
            listener.onItemClicked(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CoronaViewHolder, position: Int) {
        val currentItem = items[position]
        holder.bindItem(currentItem)
    }

}

class CoronaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindItem(model: Model){
        itemView.covid_country.text = model.country
        itemView.covid_cases.text = model.cases
        itemView.covid_today_cases.text = model.todaycases
        itemView.covid_deaths.text = model.deaths
        itemView.covid_today_deaths.text = model.todaydeaths
        itemView.covid_recovered.text = model.recovered
        itemView.covid_active.text = model.active
        itemView.covid_critical.text = model.critical
        itemView.covid_cases_per_one_million.text = model.casesperonemillion
        itemView.covid_deaths_per_one_million.text = model.deathsperonemillion
        itemView.covid_total_tests.text = model.totaltests
        itemView.covid_tests_per_one_million.text = model.testsperonemillion
    }
}

interface CountryClicked{
    fun onItemClicked(item: Model)
}