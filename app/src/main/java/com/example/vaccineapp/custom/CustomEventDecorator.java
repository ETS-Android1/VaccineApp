package com.example.vaccineapp.custom;

import com.example.vaccineapp.Activities.MainActivity;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CustomEventDecorator implements DayViewDecorator {

    private final int[] colors;
    private final HashSet<CalendarDay> dates;


    public CustomEventDecorator(Collection<CalendarDay> dates, int[] colors) {
        //this.color = color;
        this.dates = new HashSet<>(dates);

        this.colors = colors;

    }


    /*public CustomEventDecorator(List<MainActivity.Filter> filteredEvents) {
        //this.color = color;

        this.dates = new HashSet<>(filteredEvents.get(0).calDayArr);
        int[] colors = new int[1];
        colors[0] = filteredEvents.get(0).color;
        this.colors = colors;

    }*/

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return dates.contains(day);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan((new CustomMultipleDotSpan(5,colors)));

    }


}