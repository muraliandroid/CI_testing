package murali.myapplication.databinding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import murali.myapplication.R;

public class Main7Activity extends AppCompatActivity {

    ToggleButton toggleButton;

    TextView tv1, tv2;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        tv1 = findViewById(R.id.textView5);
        tv2 = findViewById(R.id.textView6);
        toggleButton = findViewById(R.id.toggleButton);
        button = findViewById(R.id.button3);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    tv1.setVisibility(View.INVISIBLE);
                } else {
                    tv1.setVisibility(View.GONE);
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tv1.setVisibility(View.VISIBLE);
                    }
                });
            }
        });
    }
}
