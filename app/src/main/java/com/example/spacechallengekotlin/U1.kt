package com.example.spacechallengekotlin

open class U1 : Rocket() {
    init {
        cost = 100
        weight = 10000
        maxWeight = 18000
    }

    override fun land(): Boolean {
        launchExplosion = 5 * (fillWeight / maxWeight)
        return launchExplosion < (0..10).random()
    }

    override fun launch(): Boolean {
        landingCrash = fillWeight / maxWeight
        return landingCrash < (0..4).random()
    }
}