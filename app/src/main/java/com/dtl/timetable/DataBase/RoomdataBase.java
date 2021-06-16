package com.dtl.timetable.DataBase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.dtl.timetable.data.DayDao;
import com.dtl.timetable.models.OneDay;
import com.dtl.timetable.models.Subjects;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities ={OneDay.class},version = 1,exportSchema = false)
public abstract class RoomdataBase extends RoomDatabase {


    public abstract DayDao getDao();
    private  static volatile RoomdataBase INSTANCE;
    private static final int NO_OF_THREADS = 4;
    public static ExecutorService writerExecutor = Executors.newFixedThreadPool(NO_OF_THREADS);

    public static RoomdataBase getInstance(Context context){
        if(INSTANCE==null){
            synchronized (RoomdataBase.class){
                if(INSTANCE==null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),RoomdataBase.class,"TimeTableDataBase")
                            .addCallback(initializer)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback initializer = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            writerExecutor.execute(() ->{
                DayDao dayDao = INSTANCE.getDao();
                OneDay mon = new OneDay("Monday",2,"OELE","CGV","CGVL","CGVL","SSCD","SSCDLT","CGVLT");
                OneDay tue = new OneDay("Tuesday",3, "ELE","WTA","OELE","CGV","SSCDL","SSCDL","Sports");
                OneDay wed = new OneDay("Wednesday",4, "SSCD","SSCD","OELE","ELE","---","---","---");
                OneDay thu = new OneDay("Thursday",5, "CGV","WTA","CGV","WTA","---","---","---");
                OneDay fri = new OneDay("Friday",6, "CGV","SSCD","MADL","MADL","proctoring","proctoring","proctoring");
                OneDay sat = new OneDay("Saturday",7, "WTA","SSCD","ELE","WTA","---","---","---");
                dayDao.insert(mon);
                dayDao.insert(tue);
                dayDao.insert(wed);
                dayDao.insert(thu);
                dayDao.insert(fri);
                dayDao.insert(sat);

            });
        }
    };
}
