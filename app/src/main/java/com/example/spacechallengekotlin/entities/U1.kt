package com.example.spacechallengekotlin.entities

open class U1 : Rocket() {
    override var cost: Int = 100
    override var weight: Int = 10000
    override var maxWeight: Int = 18000

    override fun land(): Boolean {
        launchExplosion = 5 * (fillWeight / maxWeight)
        return launchExplosion < (0..10).random()
    }

    override fun launch(): Boolean {
        landingCrash = fillWeight / maxWeight
        return landingCrash < (0..4).random()
    }
}