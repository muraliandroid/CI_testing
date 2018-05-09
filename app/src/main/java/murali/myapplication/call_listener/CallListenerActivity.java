package murali.myapplication.call_listener;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import murali.myapplication.R;

public class CallListenerActivity extends AppCompatActivity {

    CallListener callListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_listener);
    }

    @Override
    protected void onStart() {
        super.onStart();
        callListener = new CallListener();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PHONE_STATE");
        registerReceiver(callListener, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(callListener);
    }
}