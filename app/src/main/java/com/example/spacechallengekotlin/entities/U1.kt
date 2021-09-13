package com.example.spacechallengekotlin.entities

class U1(_cost: Int, _weight: Int, _maxWeight: Int) : Rocket() {
    init {
        cost = _cost
        weight = _weight
        maxWeight = _maxWeight
    }

    override fun land(): Boolean {
        launchExplosion = 5 * ((fillWeight - weight) / maxWeight)
        return launchExplosion < (0..10).random()
    }

    override fun launch(): Boolean {
        landingCrash = (fillWeight - weight) / maxWeight
        return landingCrash < (0..4).random()
    }
}