package com.dtl.timetable.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.dtl.timetable.models.OneDay;

import java.util.List;

@Dao
public interface DayDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(OneDay oneDay);

    @Query("DELETE FROM TIME_TABLE")
    void deleteALl();

    @Update
    void update(OneDay oneDay);

    @Delete
    void delete(OneDay oneDay);

    @Query("SELECT * FROM TIME_TABLE")
    LiveData<List<OneDay>> getALLDays();

}
