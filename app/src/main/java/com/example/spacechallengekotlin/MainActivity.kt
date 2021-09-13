package com.example.spacechallengekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.spacechallengekotlin.entities.Item
import com.example.spacechallengekotlin.entities.Rocket
import com.example.spacechallengekotlin.entities.U1
import com.example.spacechallengekotlin.entities.U2

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startSimulation(view: View) {
        val inputStreamPhase1 = resources.openRawResource(R.raw.phase1)
        val inputStreamPhase2 = resources.openRawResource(R.raw.phase2)

        val simulation = Simulation()
        val listItems1 = ArrayList<Item>()
        val listItems2 = ArrayList<Item>()
        val outputInformation : TextView = findViewById(R.id.outputText)

        var generalInformation = resources.getString(R.string.textSimulationRocketU1Part1)
        //Simulation for rocket model U1
        //Phase 1
        simulation.loadItems(listItems1, inputStreamPhase1)
        val rocketU1: Rocket = U1(resources.getInteger(R.integer.countRocketU1), resources.getInteger(R.integer.weightRocketU1), resources.getInteger(R.integer.maxWeightRocketU1))
        var totalCostSimulation1 = simulation.runSimulation(simulation.loadRocket(listItems1, rocketU1))
        //Phase 2
        simulation.loadItems(listItems1, inputStreamPhase1)
        totalCostSimulation1 += simulation.runSimulation(simulation.loadRocket(listItems1, rocketU1))
        generalInformation += " " + totalCostSimulation1 + " " + resources.getString(R.string.textSimulationRocketU1Part2)  + totalCostSimulation1 / 100
        generalInformation += " " + resources.getString(R.string.textItem)

        for(item in listItems1){
            generalInformation += " " + item.name + ", "
        }

        generalInformation += resources.getString(R.string.textSimulationRocketU2Part1)
        //Simulation for rocket model U2
        //Phase 1
        simulation.loadItems(listItems2, inputStreamPhase2)
        val rocketU2: Rocket = U2(resources.getInteger(R.integer.countRocketU2), resources.getInteger(R.integer.weightRocketU2), resources.getInteger(R.integer.maxWeightRocketU2))
        var totalCostSimulation2 = simulation.runSimulation(simulation.loadRocket(listItems2, rocketU2))
        //Phase 2
        simulation.loadItems(listItems2, inputStreamPhase2)
        totalCostSimulation2 += simulation.runSimulation(simulation.loadRocket(listItems2, rocketU2))
        generalInformation += " " + totalCostSimulation2 + " " + resources.getString(R.string.textSimulationRocketU2Part2) + totalCostSimulation2 / 120
        generalInformation += " " + resources.getString(R.string.textItem)

        for(item in listItems2){
            generalInformation += " " + item.name + ", "
        }

        outputInformation.text = generalInformation
    }
    //by Barmutov Roman
}
