package com.example.appwidgetmanager;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Implementation of App Widget functionality.
 */
public class CatDaysAppWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        //for (int appWidgetId : appWidgetIds) {
        //    updateAppWidget(context, appWidgetManager, appWidgetId);
        //}
        final int N = appWidgetIds.length;
        for (int i = 0; i < N; i++) {
            updateAppWidget(context, appWidgetManager, appWidgetIds[i]);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,int appWidgetId) {

        Calendar catDay = new GregorianCalendar(2016, 2, 1);
        Calendar today = Calendar.getInstance();
        long days = ((catDay.getTimeInMillis() - today.getTimeInMillis()) / (24 * 60 * 60 * 1000)) + 1;

        //CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.cat_days_app_widget);
        // views.setTextViewText(R.id.appwidget_text, widgetText);

        views.setTextViewText(R.id.appwidget_text, "Осталось дней: " + days);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

}

