package murali.myapplication.pack1.pack3;

import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.util.Log;
import android.widget.EditText;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import murali.myapplication.Main3Activity;
import murali.myapplication.R;
import murali.myapplication.rest_api_work.RestPresenter;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertThat;


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
//                assertThat(mainActivity3Context, is(IsNull.notNullValue()));
//                assertThat(restCallBackListener, is(IsNull.notNullValue()));
//                assertThat(restPresenter, is(IsNull.notNullValue()));
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

    @Test
    public void addNewEmployee2() throws Exception {
        final EditText e = (EditText) mainActivity3Context.findViewById(R.id.emp_name);

        Thread.sleep(10000);
        mainActivity3Context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //e.setText("dsfsd");
            }
        });
       // assertThat(e.getText().toString(), is("dsfsd"));
    }

    @After
    public void tearDown() throws Exception {
        mainActivity3Context = null;
        restPresenter = null;
        restCallBackListener = null;
        getInstrumentation().removeMonitor(activityMonitor);
    }
}