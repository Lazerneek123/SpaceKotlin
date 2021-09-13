package com.example.spacechallengekotlin.entities

class U2(_cost: Int, _weight: Int, _maxWeight: Int) : Rocket() {
    init {
        cost = _cost
        weight = _weight
        maxWeight = _maxWeight
    }

    override fun land(): Boolean {
        launchExplosion = 4 * ((fillWeight - weight) / maxWeight)
        return launchExplosion < (0..8).random()
    }

    override fun launch(): Boolean {
        landingCrash = 8 * ((fillWeight - weight) / maxWeight)
        return landingCrash < (0..16).random()
    }
}