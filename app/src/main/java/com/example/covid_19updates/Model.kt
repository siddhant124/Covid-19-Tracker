package com.example.covid_19updates

data class Model(
    val country: String,
    val cases: String,
    val todaycases: String,
    val deaths: String,
    val todaydeaths: String,
    val recovered: String,
    val active: String,
    val critical: String,
    val casesperonemillion: String,
    val deathsperonemillion: String,
    val totaltests: String,
    val testsperonemillion: String
)