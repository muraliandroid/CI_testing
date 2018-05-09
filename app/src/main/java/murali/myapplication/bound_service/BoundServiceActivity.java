package murali.myapplication.bound_service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import murali.myapplication.R;

/**
 * Created by shyleenrodrigues on 2/21/18.
 */

public class BoundServiceActivity extends AppCompatActivity {

    private BoundService mBoundService;
    private boolean boundStatus = false;
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bound_service_layout);
        textView = findViewById(R.id.bound_tv);
        editText = findViewById(R.id.bound_edit);
        Button button = findViewById(R.id.bound_btn);
        Button unBind = findViewById(R.id.bound_unbind_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = mBoundService.addNum(Integer.parseInt(editText.getText().toString()));
                Toast.makeText(BoundServiceActivity.this, "" + a, Toast.LENGTH_SHORT).show();
            }
        });

        unBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (boundStatus) {
                    if (mBoundService != null) {
                        unbindService(serviceConnection);
                    }
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Start bound service
        Intent intent = new Intent(BoundServiceActivity.this, BoundService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            BoundService.LocalBinder localBinder = (BoundService.LocalBinder) iBinder;
            mBoundService = localBinder.getService();
            boundStatus = true;
            Log.d("BoundService","service bounded");
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            boundStatus = false;
            Log.d("BoundService","service unbounded");
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        if (boundStatus) {
            if (mBoundService != null) {
                unbindService(serviceConnection);
            }
        }
    }
}