package com.dtl.timetable.models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.dtl.timetable.DataBase.Repository;
import com.dtl.timetable.data.DayDao;

import java.util.List;

public class DayViewModel extends AndroidViewModel{
    public static Repository repository;
    public final LiveData<List<OneDay>> Days;

    public DayViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        Days = repository.getDays();
    }

    public static void insert(OneDay oneDay){
        repository.insert(oneDay);
    }
}
