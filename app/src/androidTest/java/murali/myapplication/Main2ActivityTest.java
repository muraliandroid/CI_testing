package murali.myapplication;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.util.Log;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by shyleenrodrigues on 12/27/17.
 */
public class Main2ActivityTest {

    @Rule
    public ActivityTestRule<Main2Activity> main2ActivityActivityTestRule = new ActivityTestRule<Main2Activity>(Main2Activity.class) {
        @Override
        protected Intent getActivityIntent() {
            InstrumentationRegistry.getTargetContext();
            Intent intent = new Intent();
            intent.putExtra("key", 10);
            return intent;
        }
    };

    Main2Activity main2Activity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(Main2Activity.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {
        main2Activity = main2ActivityActivityTestRule.getActivity();
    }

    @Test
    public void checkValue() {
        TextView textView = main2Activity.findViewById(R.id.test_tv2);
        Log.d("textview", "value is " + textView.getText().toString());
        assertThat(Integer.parseInt(textView.getText().toString()), is(10));
//        getInstrumentation().waitForMonitor(monitor);

    }

    @After
    public void tearDown() throws Exception {
        main2Activity = null;
        getInstrumentation().removeMonitor(monitor);
    }
}