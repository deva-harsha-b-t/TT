package com.dtl.timetable.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TIME_TABLE")
public class OneDay {

    @PrimaryKey
    @ColumnInfo(name = "day_no")
    private int dayNo;

    @ColumnInfo(name = "day")
    private String day;

    @ColumnInfo(name = "P_1")
    private String P1;

    @ColumnInfo(name = "P_2")
    private String P2;

    @ColumnInfo(name = "P_3")
    private String P3;

    @ColumnInfo(name = "P_4")
    private String P4;

    @ColumnInfo(name = "P_5")
    private String P5;

    @ColumnInfo(name = "P_6")
    private String P6;

    @ColumnInfo(name = "P_7")
    private String P7;

    public int getDayNo() {
        return dayNo;
    }

    public void setDayNo(int dayNo) {
        this.dayNo = dayNo;
    }

    public String getP1() {
        return P1;
    }

    public void setP1(String p1) {
        P1 = p1;
    }

    public String getP2() {
        return P2;
    }

    public void setP2(String p2) {
        P2 = p2;
    }

    public String getP3() {
        return P3;
    }

    public void setP3(String p3) {
        P3 = p3;
    }

    public String getP4() {
        return P4;
    }

    public void setP4(String p4) {
        this.P4 = p4;
    }

    public String getP5() {
        return P5;
    }

    public void setP5(String p5) {
        this.P5 = p5;
    }

    public String getP6() {
        return P6;
    }

    public void setP6(String p6) {
        P6 = p6;
    }

    public String getP7() {
        return P7;
    }

    public void setP7(String p7) {
        P7 = p7;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public OneDay(String day, int dayNo, String P1, String P2, String P3, String P4, String P5, String P6, String P7) {
        this.day = day;
        this.dayNo = dayNo;
        this.P1 = P1;
        this.P2 = P2;
        this.P3 = P3;
        this.P4 = P4;
        this.P5 = P5;
        this.P6 = P6;
        this.P7 = P7;
    }
}
