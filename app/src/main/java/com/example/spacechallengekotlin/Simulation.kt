package com.example.spacechallengekotlin

import com.example.spacechallengekotlin.entities.Item
import com.example.spacechallengekotlin.entities.Rocket
import com.example.spacechallengekotlin.entities.U1
import com.example.spacechallengekotlin.entities.U2
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import kotlin.io.bufferedReader
import kotlin.collections.ArrayList

open class Simulation {

    open fun loadItems(arrayListItems: ArrayList<Item>, inputStream: InputStream){

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

    open fun loadU1(itemList: ArrayList<Item>) : ArrayList<Rocket>{
        val rocketModelListU1 = ArrayList<Rocket>()
        var rocket = U1()

        for (item in itemList) {
            if (rocket.canCarry(item)) {
                rocket.carry(item)
                rocketModelListU1.add(rocket)
            } else {
                rocket = U1()
                rocketModelListU1.add(rocket)
            }
        }

        return rocketModelListU1
    }

    open fun loadU2(itemList: ArrayList<Item>) : ArrayList<Rocket>{
        val rocketModelListU2 = ArrayList<Rocket>()
        var rocket = U2()

        for (item in itemList) {
            if (rocket.canCarry(item)) {
                rocket.carry(item)
                rocketModelListU2.add(rocket)
            } else {
                rocket = U2()
                rocketModelListU2.add(rocket)
            }
        }

        return rocketModelListU2
    }

    open fun runSimulation(rockets: ArrayList<Rocket>) : Int{
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