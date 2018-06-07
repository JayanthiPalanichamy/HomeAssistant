import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class FanTest {
    Fan fan;
    @Before
    public void setUp(){
        fan = new Fan();
    }
    @Test
    public void returnTrueWhenFanIsTurnedOn(){
        Fan fan = new Fan();
        fan.turnOn();

        assertTrue(fan.isOn());
    }

    @Test
    public void returnFalseWhenFanIsTurnedOff() {

    }
}
