package com.dtl.timetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.dtl.timetable.models.DayViewModel;
import com.dtl.timetable.models.OneDay;
import com.dtl.timetable.models.currentViewModel;
import com.google.android.material.chip.Chip;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DayViewModel dayViewModel;
    private OneDay Today;
    private currentViewModel oneViewModel;
    private  TextView day;
    private  TextView p1;
    private  TextView p2;
    private  TextView p3;
    private  TextView p4;
    private  TextView p5;
    private  TextView p6;
    private  TextView p7;
    private Chip GoToClass;
    private Chip GoToEle;
    private Chip GoToOele;
    private Chip GoToSSCDLab;
    private Chip GoToCGVLab;
    private Chip GoToMADLab;
    private ImageButton settings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oneViewModel = new ViewModelProvider(this).get(currentViewModel.class);
        p1 = findViewById(R.id.pe1);
        p2 = findViewById(R.id.pe2);
        p3 = findViewById(R.id.pe3);
        p4 = findViewById(R.id.pe4);
        p5 = findViewById(R.id.pe5);
        p6 = findViewById(R.id.pe6);
        p7 = findViewById(R.id.pe7);
        day = findViewById(R.id.TodayDay);
        GoToClass = findViewById(R.id.chipNormalClass);
        GoToCGVLab = findViewById(R.id.chipCGVL);
        GoToSSCDLab = findViewById(R.id.chipSSCDL);
        GoToEle = findViewById(R.id.chipELE);
        GoToOele = findViewById(R.id.chipOELE);
        GoToMADLab = findViewById(R.id.chipMADL);
        settings = findViewById(R.id.SettingsButton);
        SharedPreferences sPref = this.getPreferences(Context.MODE_PRIVATE);
        if(sPref.getString("ELE", "none").equals("none")){
            SharedPreferences.Editor editor = sPref.edit();
            editor.putString("ELE","https://meet.google.com/dbb-cxbg-gec");
            editor.putString("CGVL","http://meet.google.com/pdi-chme-fjt");
            editor.putString("SSCDL","https://meet.google.com/ktn-wevs-xzg");
            editor.putString("MADL","https://meet.google.com/lookup/gzgow55wtt?authuser=0&hs=179");
            editor.putString("NC","https://meet.google.com/gry-jxix-ydo");
            editor.putString("OELE","https://meet.google.com/kje-zaim-woa");
            editor.apply();
        }



        dayViewModel = new ViewModelProvider.AndroidViewModelFactory(this.getApplication())
                .create(DayViewModel.class);
        Calendar calendar = Calendar.getInstance();
        int todayNo = calendar.get(Calendar.DAY_OF_WEEK);
        dayViewModel.Days.observe(this, new Observer<List<OneDay>>() {
            @Override
            public void onChanged(List<OneDay> oneDays) {
                if(todayNo ==1 )
                    Today = oneDays.get(0);
                else
                    Today = oneDays.get(todayNo-2);
                oneViewModel.setDay(Today);
            }
        });
        oneViewModel.getDay().observe(this, new Observer<OneDay>() {
            @Override
            public void onChanged(OneDay oneDay) {
                day.setText(oneDay.getDay());
                p1.setText(oneDay.getP1());
                p2.setText(oneDay.getP2());
                p3.setText(oneDay.getP3());
                p4.setText(oneDay.getP4());
                p5.setText(oneDay.getP5());
                p6.setText(oneDay.getP6());
                p7.setText(oneDay.getP7());
            }
        });

        GoToMADLab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl(sPref.getString("MADL","https://meet.google.com/lookup/gzgow55wtt?authuser=0&hs=179"));

            }
        });
        GoToClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl(sPref.getString("NC","https://meet.google.com/gry-jxix-ydo"));


            }
        });
        GoToCGVLab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl(sPref.getString("CGVL","http://meet.google.com/pdi-chme-fjt)"));

            }
        });
        GoToSSCDLab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl(sPref.getString("SSCDL","https://meet.google.com/ktn-wevs-xzg"));

            }
        });
        GoToEle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl(sPref.getString("ELE","https://meet.google.com/dbb-cxbg-gec"));

            }
        });
        GoToOele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl(sPref.getString("OELE","https://meet.google.com/kje-zaim-woa"));

            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this,v);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId()){
                            case R.id.ChangeLinks:
                                changeLinks();
                                    return true;
                            case R.id.ChangeTimeTable:
                                    return true;
                            case R.id.showAllDays:
                                    return true;
                            case R.id.about:
                                    return true;
                            default: return false;
                        }
                    }
                });
                popupMenu.inflate(R.menu.menu);
                popupMenu.show();
            }

        });
    }

    private void changeLinks() {



    }

    private void openUrl(String url) {
        Uri webPage = Uri.parse(url);
        Intent intent =new Intent(Intent.ACTION_VIEW,webPage);
        startActivity(intent);
    }

}