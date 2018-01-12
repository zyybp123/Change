package cn.bpzzr.change;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import cn.bpzzr.change.util.StringUtil;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("cn.bpzzr.change", appContext.getPackageName());
        boolean spaceStr = StringUtil.isSpaceStr("     \n" +
                "\n" +
                "\n" +
                "\t\t\n" +
                "\t\n" +
                "\t\n" +
                "     \n" +
                "          ");
        assert spaceStr;
    }
}
