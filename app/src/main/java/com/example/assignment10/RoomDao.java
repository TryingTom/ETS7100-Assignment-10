package com.example.assignment10;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RoomDao {

    @Insert
    void insert(Taulu entity);

    @Update
    void update(Taulu entity);

    @Query("Select * FROM taulukko")
    List<Taulu> getAllEntitys();

    @Delete
    void delete (Taulu taulu);
}
