package ca.nait.jmattson4.randomnumberwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import java.util.Random;

/**
 * Created by jmattson4 on 3/4/2019.
 */

public class RandomNumberWidgetProvider extends AppWidgetProvider
{
    RemoteViews views;
    public static int currentColor = 1;

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
    {
        ComponentName thisWidget = new ComponentName(context, RandomNumberWidgetProvider.class);
        //ensures we have an array of the current ids
        int[] currentWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
        for (int widgetId : currentWidgetIds)
        {
            int number = new Random().nextInt(100);
            switch (currentColor)
            {
                case 1:
                {
                    views = new RemoteViews(context.getPackageName(), R.layout.widget_layout_red);
                    currentColor = 2;
                    break;
                }
                case 2:
                {
                    views = new RemoteViews(context.getPackageName(), R.layout.widget_layout_green);
                    currentColor = 3;
                    break;
                }
                case 3:
                {
                    views = new RemoteViews(context.getPackageName(), R.layout.widget_layout_blue);
                    currentColor = 1;
                    break;
                }
            } //CLOSE SWITCH
            Intent intent = new Intent(context, RandomNumberWidgetProvider.class);
            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            views.setOnClickPendingIntent(R.id.textview_random_number, pendingIntent);
            views.setTextViewText(R.id.textview_random_number, String.valueOf(number));//String.Valueof(int) converts number to String
            appWidgetManager.updateAppWidget(widgetId, views);
        }
    }
}
