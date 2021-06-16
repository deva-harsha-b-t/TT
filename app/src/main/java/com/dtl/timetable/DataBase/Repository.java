package com.dtl.timetable.DataBase;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;

import com.dtl.timetable.data.DayDao;
import com.dtl.timetable.models.OneDay;

import java.util.List;

public class Repository {

    private DayDao dayDao;
    private LiveData<List<OneDay>> allDays;

    public Repository(Application application) {
        RoomdataBase db = RoomdataBase.getInstance(application);
        dayDao = db.getDao();
        allDays = dayDao.getALLDays();
    }
    public LiveData<List<OneDay>> getDays(){
        return allDays;
    }
    public void insert(OneDay oneDay){
        RoomdataBase.writerExecutor.execute(() ->{
            dayDao.insert(oneDay);
        });
    }

}
