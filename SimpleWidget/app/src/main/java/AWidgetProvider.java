import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;

import ca.nait.jmattson4.simplewidget.R;

/**
 * Created by jmattson4 on 2/27/2019.
 */

public class AWidgetProvider extends AppWidgetProvider
{

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
    {
        ComponentName component = new ComponentName(context, AWidgetProvider.class);
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
        appWidgetManager.updateAppWidget(component, views);
    }
}
