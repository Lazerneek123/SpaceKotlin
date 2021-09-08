package com.example.spacechallengekotlin.entities

import com.example.spacechallengekotlin.SpaceShip

open class Rocket : SpaceShip {

    open var cost: Int = 0
    protected open var weight = 0
    protected open var maxWeight = 0

    var fillWeight = 0
        set(value){
            if(value>0)
                field = value
        }
        get() = field

    var launchExplosion = 0
        set(value){
            if(value>0)
                field = value
        }
        get() = field

    var landingCrash = 0
        set(value){
            if(value>0)
                field = value
        }
        get() = field

    override fun launch(): Boolean { return true }
    override fun land(): Boolean{ return true }

    override fun canCarry(item: Item?): Boolean{
        return fillWeight + item!!.weight <= maxWeight
    }

    override fun carry(item: Item?): Int{
        fillWeight += item!!.weight
        return fillWeight
    }
}