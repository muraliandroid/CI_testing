package murali.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button testBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testBtn = (Button) findViewById(R.id.test_button);
        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Button perform click action", Toast.LENGTH_SHORT).show();
                Log.d("btn", "btn clicked");
                Bundle bundle = new Bundle();
                bundle.putInt("key", 10);
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
