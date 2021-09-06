package com.example.spacechallengekotlin

open class Item {
    var name = ""

    var weight = 0
        set(value){
            if((value>0))
                field = value
        }
        get() = field
}