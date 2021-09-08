package com.example.spacechallengekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.spacechallengekotlin.entities.Item

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startSimulation(view: View) {
        val inputStreamPhase1 = resources.openRawResource(R.raw.phase1)
        val inputStreamPhase2 = resources.openRawResource(R.raw.phase2)

        val simulation = Simulation()
        val arrayListItems1 = ArrayList<Item>()
        val arrayListItems2 = ArrayList<Item>()
        val outputInformation : TextView = findViewById(R.id.outputText)

        var generalInformation = resources.getString(R.string.textSimulationRocketU1Part1)
        //Simulation for rocket model U1
        //Phase 1
        simulation.loadItems(arrayListItems1, inputStreamPhase1)
        var totalCostSimulation1 = simulation.runSimulation(simulation.loadU1(arrayListItems1))
        //Phase 2
        simulation.loadItems(arrayListItems1, inputStreamPhase1)
        totalCostSimulation1 += simulation.runSimulation(simulation.loadU1(arrayListItems1))
        generalInformation += " " + totalCostSimulation1 + resources.getString(R.string.textSimulationRocketU1Part2)  + totalCostSimulation1 / 100

        generalInformation += resources.getString(R.string.textSimulationRocketU2Part1)
        //Simulation for rocket model U2
        //Phase 1
        simulation.loadItems(arrayListItems2, inputStreamPhase2)
        var totalCostSimulation2 = simulation.runSimulation(simulation.loadU2(arrayListItems2))
        //Phase 2
        simulation.loadItems(arrayListItems2, inputStreamPhase2)
        totalCostSimulation2 += simulation.runSimulation(simulation.loadU2(arrayListItems2))
        generalInformation += " " + totalCostSimulation2 + " " + resources.getString(R.string.textSimulationRocketU2Part2) + totalCostSimulation2 / 120

        outputInformation.text = generalInformation
    }
    //by Barmutov Roman
}
