package murali.myapplication.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import murali.myapplication.R;

public class Main6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMain6Binding binding = DataBindingUtil.setContentView(Main6Activity.this, R.layout.activity_main6);
        UserClass userInfo = new UserClass("Test", "User");
        binding.setUser(userInfo);
    }
}