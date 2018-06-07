import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class HomeAssistantTest {
    HomeAssistant homeAssistant;
    AirConditioner airConditioner;
    Television tv;

    @Before
    public void setUp(){
        homeAssistant = new HomeAssistant();
        airConditioner = new AirConditioner();
        tv = new Television();
        ACOnCommand acOnCommand = new ACOnCommand(airConditioner);
        homeAssistant.addCommand("TurnOnAc",acOnCommand);
        ACOffCommand acOffCommand = new ACOffCommand(airConditioner);
        homeAssistant.addCommand("TurnOffAc",acOffCommand);
        TVOnCommand tvOnCommand = new TVOnCommand(tv);
        homeAssistant.addCommand("OnTv",tvOnCommand);
        TvOffCommand tvOffCommand = new TvOffCommand(tv);
        homeAssistant.addCommand("OffTv",tvOffCommand);
    }
    @Test
    public void homeAssistantShouldSwitchOnTheAC(){

        homeAssistant.listen("TurnOnAc");

        assertTrue(airConditioner.isOn());
    }
    @Test
    public void homeAssistantShouldSwitchOffTheAc() {
        homeAssistant.listen("TurnOffAc");

        assertFalse(airConditioner.isOn());
    }

    @Test
    public void homeAssistantShouldSwitchOnTheTv() {
        homeAssistant.listen("OnTv");

        assertTrue(tv.isOn());
    }

    @Test
    public void homeAssistantShouldSwitchOffTheTv() {
        homeAssistant.listen("OffTv");

        assertFalse(tv.isOn());
    }
}
