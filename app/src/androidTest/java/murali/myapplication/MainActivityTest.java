package murali.myapplication;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.lifecycle.ActivityLifecycleCallback;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.runner.lifecycle.Stage;
import android.widget.Button;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by shyleenrodrigues on 12/26/17.
 */
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    MainActivity mainActivityContext = null;
    Instrumentation.ActivityMonitor activityMonitor;
    Button testBtn;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(Main2Activity.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {
        mainActivityContext = mainActivityActivityTestRule.getActivity();
        activityMonitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);
    }

    @Test
    public void testMainActivityLaunched() {
        testBtn = mainActivityContext.findViewById(R.id.test_button);
        assertNotNull(testBtn);
        mainActivityContext.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                testBtn.performClick();
            }
        });
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);
        assertNotNull(secondActivity);
        TextView tv2 = secondActivity.findViewById(R.id.test_tv2);
        assertThat(tv2.getText().toString(), is("10"));

        ActivityLifecycleMonitorRegistry.getInstance().addLifecycleCallback(new ActivityLifecycleCallback() {
            @Override
            public void onActivityLifecycleChanged(Activity activity, Stage stage) {

            }
        });
    }

    @After
    public void tearDown() throws Exception {
        mainActivityContext = null;
        getInstrumentation().removeMonitor(activityMonitor);
        getInstrumentation().removeMonitor(monitor);
    }

}