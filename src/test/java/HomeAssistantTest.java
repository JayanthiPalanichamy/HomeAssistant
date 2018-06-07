import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class HomeAssistantTest {
    HomeAssistant homeAssistant;
    AirConditioner airConditioner;

    @Before
    public void setUp(){
        homeAssistant = new HomeAssistant();
        airConditioner = new AirConditioner();
        homeAssistant.addAirConditioner(airConditioner);
    }
    @Test
    public void homeAssistantShouldSwitchOnTheAC(){
        homeAssistant.doCommand("TurnOnAc");

        assertTrue(airConditioner.isOn());
    }

    @Test
    public void homeAssistantShouldSwitchOffTheAc() {
        homeAssistant.doCommand("TurnOffAc");

        assertFalse(airConditioner.isOn());
    }

    @Test
    public void homeAssistantShouldSwitchOnTheTv() {
        Television television = new Television();
        homeAssistant.addTelevision(television);
        homeAssistant.doCommand("OnTv");

        assertTrue(television.isOn());
    }

    @Test
    public void homeAssistantShouldSwitchOffTheTv() {
        Television television = new Television();
        homeAssistant.addTelevision(television);
        homeAssistant.doCommand("OffTv");

        assertFalse(television.isOn());
    }
}
