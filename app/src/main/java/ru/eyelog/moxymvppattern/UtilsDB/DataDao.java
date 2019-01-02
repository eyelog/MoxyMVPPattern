package ru.eyelog.moxymvppattern.UtilsDB;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface DataDao {

    @Query("SELECT * FROM Data")
    List<Data> getAll();

    @Query("SELECT * FROM Data WHERE id = :id")
    Data getById(long id);

    @Insert
    void insert(Data data);

    @Update
    void update(Data data);

    @Delete
    void delete(Data data);

}