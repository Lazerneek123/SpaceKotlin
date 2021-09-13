package com.example.spacechallengekotlin

import com.example.spacechallengekotlin.entities.Item
import com.example.spacechallengekotlin.entities.Rocket
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import kotlin.io.bufferedReader
import kotlin.collections.ArrayList

class Simulation {

    fun loadItems(arrayListItems: ArrayList<Item>, inputStream: InputStream){

        val bufferedReader : BufferedReader = inputStream.bufferedReader()

        try {
            var eachLine = bufferedReader.readLine()
            while (eachLine != null){
                val words = eachLine.split("=")
                val item = Item()
                item.name = words[0]
                item.weight = Integer.parseInt(words[1])
                arrayListItems.add(item)
                eachLine = bufferedReader.readLine()
            }
        }
        catch (ex : IOException){
            val item = Item()
            item.name = ex.message.toString()
            arrayListItems.add(item)
        }
    }

    fun loadRocket(itemList: ArrayList<Item>, rocket: Rocket) : ArrayList<Rocket>{
        val rocketModelListU1 = ArrayList<Rocket>()

        for (item in itemList) {
            if (rocket.canCarry(item)) {
                rocket.carry(item)
                rocketModelListU1.add(rocket)
            } else {
                rocketModelListU1.add(rocket)
            }
        }

        return rocketModelListU1
    }

    fun runSimulation(rockets: ArrayList<Rocket>) : Int{
        var totalCost = 0

        for (rocket in rockets) {
            totalCost += rocket.cost

            while (!rocket.launch() || !rocket.land()) {
                totalCost += rocket.cost
            }
        }
        return totalCost
    }
}