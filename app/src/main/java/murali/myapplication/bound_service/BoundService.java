package murali.myapplication.bound_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by shyleenrodrigues on 2/21/18.
 */

public class BoundService extends Service {

    public final IBinder mIBinder = new LocalBinder();
    private String TAG = "BoundService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mIBinder;
    }

    public int addNum(int num) {
        return num + 20;
    }

    public class LocalBinder extends Binder {
        public BoundService getService() {
            return BoundService.this;
        }
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}