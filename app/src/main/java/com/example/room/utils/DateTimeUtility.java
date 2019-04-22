package com.example.room.utils;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.TextView;

import java.util.Calendar;

public class DateTimeUtility {

    public static void showDateDialog(Context context, final TextView displayView){
        Calendar myCalendar = Calendar.getInstance();
        new DatePickerDialog(context, (view,  year,  month,  dayOfMonth)->{
            String date = String.valueOf(month + 1) + "-" + String.valueOf(dayOfMonth) + "-" + String.valueOf(year);
            displayView.setText(date);
        }, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    public static void showDateDialogUpdate(Context context, final TextView displayView){
        Calendar myCalendar = Calendar.getInstance();
        new DatePickerDialog(context, (view,  year,  month,  dayOfMonth)->{
            String date =String.valueOf(dayOfMonth) + "-" +String.valueOf(month + 1) + "-" + String.valueOf(year);
            displayView.setText(date);
        }, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }

}
