package murali.myapplication;

import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.util.Log;
import android.widget.Button;

import org.hamcrest.Matchers;
import org.hamcrest.core.IsNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import murali.myapplication.rest_api_work.RestPresenter;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by shyleenrodrigues on 1/4/18.
 */
public class Main3ActivityTest {

    @Rule
    public ActivityTestRule<Main3Activity> mainActivity3TestRule = new ActivityTestRule<Main3Activity>(Main3Activity.class);
    Main3Activity mainActivity3Context = null;
    Instrumentation.ActivityMonitor activityMonitor;

    RestPresenter restPresenter;
    RestPresenter.RestCallBackListener restCallBackListener;

    int responseCode;

    @Before
    public void setUp() throws Exception {
        mainActivity3Context = mainActivity3TestRule.getActivity();
        activityMonitor = getInstrumentation().addMonitor(Main3Activity.class.getName(), null, false);
    }

    @Test
    public void addNewEmployee() throws Exception {
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
/*                assertThat(mainActivity3Context, is(IsNull.notNullValue()));
                assertThat(restCallBackListener, is(IsNull.notNullValue()));
                assertThat(restPresenter, is(IsNull.notNullValue()));*/
                restCallBackListener = new Main3Activity();
                restPresenter = new RestPresenter(mainActivity3Context, restCallBackListener);
            }
        });
        restPresenter.addNewEmployee("test", "test");
        getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 10000);
        responseCode = restPresenter.responseCode;
        assertThat(responseCode, Matchers.anyOf(Matchers.is(200), Matchers.is(201)));
        Log.d("*", String.valueOf(responseCode));
    }

    @After
    public void tearDown() throws Exception {
        mainActivity3Context = null;
        restPresenter = null;
        restCallBackListener = null;
        getInstrumentation().removeMonitor(activityMonitor);
    }
}