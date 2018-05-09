package murali.myapplication.call_listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by shyleenrodrigues on 2/23/18.
 */

public class CallListener extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Call", "incoming call received");
    }
}