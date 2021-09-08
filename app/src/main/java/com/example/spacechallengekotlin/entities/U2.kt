package com.example.spacechallengekotlin.entities

open class U2 : Rocket() {
    override var cost: Int = 120
    override var weight: Int = 18000
    override var maxWeight: Int = 29000

    override fun land(): Boolean {
        launchExplosion = 4 * (fillWeight / maxWeight)
        return launchExplosion < (0..8).random()
    }

    override fun launch(): Boolean {
        landingCrash = 8 * (fillWeight / maxWeight)
        return landingCrash < (0..16).random()
    }
}