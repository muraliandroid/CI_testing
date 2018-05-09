package murali.myapplication.intent_service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

/**
 * Created by shyleenrodrigues on 2/21/18.
 */

public class MyIntentReceiver extends BroadcastReceiver {

    CommuncateInterface communcateInterface;

    public static final String processString = "MyIntentReceiver_send";

    public MyIntentReceiver(CommuncateInterface communcateInterface) {
        this.communcateInterface = communcateInterface;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        communcateInterface.communicate(intent.getStringExtra(MyIntentServiceExample.msg));
    }

    public interface CommuncateInterface {
        public void communicate(String msg);
    }
}