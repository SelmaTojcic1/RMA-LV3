package com.example.inspiringpeople.database

import androidx.room.Room
import com.example.inspiringpeople.InspiringPeopleApp

object InspiringPeopleDatabaseBuilder {

    private var instance: InspiringPeopleDatabase? = null

    fun getInstance(): InspiringPeopleDatabase {
        synchronized(InspiringPeopleDatabase::class) {
            if (instance == null) {
                instance = buildDatabase()
            }
        }
        return instance!!
    }

    private fun buildDatabase(): InspiringPeopleDatabase {
        return Room.databaseBuilder(
            InspiringPeopleApp.application, InspiringPeopleDatabase::class.java, InspiringPeopleDatabase.NAME
        )
            .allowMainThreadQueries()
            .build()
    }
}