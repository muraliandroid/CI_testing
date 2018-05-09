package murali.myapplication.pack1;

import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.widget.Button;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import murali.myapplication.Main4Activity;
import murali.myapplication.R;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by shyleenrodrigues on 2/7/18.
 */

public class Main4ActivityTest {

    @Rule
    public ActivityTestRule<Main4Activity> mainActivity4TestRule = new ActivityTestRule<Main4Activity>(Main4Activity.class);
    Main4Activity mainActivity4Context = null;
    Instrumentation.ActivityMonitor activityMonitor;

    Button btnForTest;

    @Before
    public void setUp() throws Exception {
        mainActivity4Context = mainActivity4TestRule.getActivity();
        activityMonitor = getInstrumentation().addMonitor(Main4Activity.class.getName(), null, false);
    }

    @Test
    public void testTextInButton() {
        btnForTest = (Button) mainActivity4Context.findViewById(R.id.start_btn);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mainActivity4Context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                btnForTest.setText("testing");
                assertThat(btnForTest.getText().toString(), is("testing"));
            }
        });

    }

    @After
    public void tearDown() throws Exception {
        mainActivity4Context = null;
        getInstrumentation().removeMonitor(activityMonitor);
    }
}