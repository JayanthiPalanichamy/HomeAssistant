import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class HomeAssistantTest {
    HomeAssistant homeAssistant;
    AirConditioner airConditioner;
    Television tv;
    Fan fan;

    @Before
    public void setUp() {
        homeAssistant = new HomeAssistant();
        airConditioner = new AirConditioner();
        tv = new Television();
        fan = new Fan();
        ACOnCommand acOnCommand = new ACOnCommand(airConditioner);
        homeAssistant.addCommand("TurnOnAc", acOnCommand);
        ACOffCommand acOffCommand = new ACOffCommand(airConditioner);
        homeAssistant.addCommand("TurnOffAc", acOffCommand);
        TVOnCommand tvOnCommand = new TVOnCommand(tv);
        homeAssistant.addCommand("OnTv", tvOnCommand);
        TvOffCommand tvOffCommand = new TvOffCommand(tv);
        homeAssistant.addCommand("OffTv", tvOffCommand);
        FanIncreaseSpeedCommand fanIncreaseSpeedCommand = new FanIncreaseSpeedCommand(fan);
        homeAssistant.addCommand("IncreaseFanSpeed", fanIncreaseSpeedCommand);
        FanDecreaseSpeedCommand fanDecreaseSpeedCommand = new FanDecreaseSpeedCommand(fan);
        homeAssistant.addCommand("DecreaseFanSpeed", fanDecreaseSpeedCommand);
    }

    @Test
    public void homeAssistantShouldSwitchOnTheAC() {

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

    @Test
    public void homeAssistantShouldSwitchOnFan() {
        FanOnCommand fanOnCommand = new FanOnCommand(fan);
        homeAssistant.addCommand("SwitchOnFan", fanOnCommand);
        homeAssistant.listen("SwitchOnFan");

        assertTrue(fan.isOn());
    }

    @Test
    public void homeAssistantShouldSwitchOffFan() {
        FanOffCommand fanOffCommand = new FanOffCommand(fan);
        homeAssistant.addCommand("SwitchOffFan", fanOffCommand);
        homeAssistant.listen("SwitchOffFan");

        assertFalse(fan.isOn());
    }

    @Test
    public void homeAssistantShouldIncreaseSpeed() {
        homeAssistant.listen("IncreaseFanSpeed");

        assertEquals(2, fan.getSpeed());
    }

    @Test
    public void homeAssistantShouldDecreaseSpeed() {
        homeAssistant.listen("IncreaseFanSpeed");
        homeAssistant.listen("DecreaseFanSpeed");

        assertEquals(1, fan.getSpeed());
    }


}
