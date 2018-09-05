package murali.myapplication;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        String routingId1 = System.getenv("routingId");
        assertEquals("seasons@comcast.com", routingId1);

        String routingId = System.getenv("ROUTING_ID");
        assertEquals("seasons@comcast.com", routingId);
        //assertEquals("murali.myapplication", appContext.getPackageName());
    }
}
