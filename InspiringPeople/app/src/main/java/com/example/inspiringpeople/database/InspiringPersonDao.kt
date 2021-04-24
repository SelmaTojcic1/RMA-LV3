package com.example.inspiringpeople.database

import androidx.room.*
import com.example.inspiringpeople.model.InspiringPerson

@Dao
interface InspiringPersonDao {

    @Query("SELECT * FROM inspiringPeople")
    fun getInspiringPeople(): List<InspiringPerson>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(inspiringPerson: InspiringPerson)

    @Delete
    fun delete(inspiringPerson: InspiringPerson)

    @Query("DELETE FROM inspiringPeople")
    fun deleteAll()

    @Query("SELECT * FROM inspiringPeople WHERE id=:id")
    fun getInspiringPerson(id: Long): InspiringPerson
}