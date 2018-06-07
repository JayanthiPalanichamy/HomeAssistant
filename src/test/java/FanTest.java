import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FanTest {
    Fan fan;
    @Before
    public void setUp(){
        fan = new Fan();
    }
    @Test
    public void returnTrueWhenFanIsTurnedOn(){
        fan.turnOn();

        assertTrue(fan.isOn());
    }

    @Test
    public void returnFalseWhenFanIsTurnedOff() {
        fan.turnOn();
        fan.turnOff();

        assertFalse(fan.isOn());
    }

    @Test
    public void returnIncreasedSpeedWhenIncreaseSpeedIsCalled(){
        fan.increaseSpeed();
        assertEquals(2,fan.getSpeed());

    }

}
