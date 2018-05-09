package murali.myapplication.intent_service;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import murali.myapplication.R;

/**
 * Created by shyleenrodrigues on 2/21/18.
 */

public class IntentServiceActivity extends AppCompatActivity implements MyIntentReceiver.CommuncateInterface {

    private MyIntentReceiver myIntentReceiver;
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_service_layout);

        textView = findViewById(R.id.intent_tv);
        editText = findViewById(R.id.intent_edit);
        Button button = findViewById(R.id.intent_btn);

        myIntentReceiver = new MyIntentReceiver(IntentServiceActivity.this);
        IntentFilter intentFilter = new IntentFilter(MyIntentReceiver.processString);
        intentFilter.addCategory(Intent.CATEGORY_DEFAULT);
        registerReceiver(myIntentReceiver, intentFilter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(IntentServiceActivity.this, MyIntentServiceExample.class);
                callIntent.putExtra("input_str", editText.getText().toString());
                startService(callIntent);
            }
        });

    }

    @Override
    public void communicate(String msg) {
        editText.setText("");
        textView.setText(msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myIntentReceiver);
    }
}