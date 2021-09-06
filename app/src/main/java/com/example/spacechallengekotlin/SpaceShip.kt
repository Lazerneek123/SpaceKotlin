package com.example.spacechallengekotlin

internal interface SpaceShip {
    fun launch(): Boolean
    fun land(): Boolean
    fun canCarry(item : Item?): Boolean
    fun carry(item: Item?): Int
}