package com.example.spacechallengekotlin

import com.example.spacechallengekotlin.entities.Item

interface SpaceShip {
    fun launch(): Boolean
    fun land(): Boolean
    fun canCarry(item : Item?): Boolean
    fun carry(item: Item?): Int
}