package murali.myapplication.service_example;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by shyleenrodrigues on 2/23/18.
 */

public class SimpleService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("simple", "simple service started");

        try {
            Thread.sleep(5000);
            stopSelf();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("simple", "simple service destroyed");
    }
}