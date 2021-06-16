package com.dtl.timetable.models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class currentViewModel extends ViewModel {

    private final MutableLiveData<OneDay> selectedDay = new MutableLiveData<>();
    public void setDay(OneDay oneDay){
        selectedDay.setValue(oneDay);
    }
    public LiveData<OneDay>getDay(){
        return selectedDay;
    }
}
