package murali.myapplication.service_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import murali.myapplication.R;

public class SimpleServiceActivity extends AppCompatActivity {

    private Button start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_service);

        start = findViewById(R.id.service_start_btn);
        stop = findViewById(R.id.service_stop_btn);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SimpleServiceActivity.this, SimpleService.class);
                startService(intent);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(SimpleServiceActivity.this, SimpleService.class));
            }
        });

    }
}
