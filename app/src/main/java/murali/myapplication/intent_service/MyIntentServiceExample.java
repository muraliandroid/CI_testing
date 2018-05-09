package murali.myapplication.intent_service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by shyleenrodrigues on 2/21/18.
 */

public class MyIntentServiceExample extends IntentService {

    public static final String msg = "intent_service";
    private final String TAG = "intent service";

    public MyIntentServiceExample() {
        super("MyIntentServiceExample");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String uCase = intent.getStringExtra("input_str").toUpperCase();
        Intent broadCastIntent = new Intent();
        broadCastIntent.setAction(MyIntentReceiver.processString);
        broadCastIntent.addCategory(Intent.CATEGORY_DEFAULT);
        broadCastIntent.putExtra(msg, uCase);
        sendBroadcast(broadCastIntent);
        Log.d(TAG, "inside onHandleIntent");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "inside onDestroy");
    }
}