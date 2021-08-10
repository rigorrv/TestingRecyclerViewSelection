package com.example.testingrecyclerviewselection.communicator

import com.example.testingrecyclerviewselection.model.DirectionJson


interface Communicator {
    fun getInformation(info: DirectionJson)
    fun addImagesAdapter(info : DirectionJson)
}