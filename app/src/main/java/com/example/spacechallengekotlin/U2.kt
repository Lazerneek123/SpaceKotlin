package com.example.spacechallengekotlin

open class U2 : Rocket() {
    init {
        cost = 120
        weight = 18000
        maxWeight = 29000
    }

    override fun land(): Boolean {
        launchExplosion = 4 * (fillWeight / maxWeight)
        return launchExplosion < (0..8).random()
    }

    override fun launch(): Boolean {
        landingCrash = 8 * (fillWeight / maxWeight)
        return landingCrash < (0..16).random()
    }
}