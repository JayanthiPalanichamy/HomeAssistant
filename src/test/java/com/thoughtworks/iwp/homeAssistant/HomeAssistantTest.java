package com.thoughtworks.iwp.homeAssistant;

import com.thoughtworks.iwp.appliance.AirConditioner;
import com.thoughtworks.iwp.appliance.Fan;
import com.thoughtworks.iwp.appliance.Television;
import com.thoughtworks.iwp.commands.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class HomeAssistantTest {
    private HomeAssistant homeAssistant;
    private AirConditioner airConditioner;
    private Television tv;
    private Fan fan;

    @Before
    public void setUp() {
        homeAssistant = new HomeAssistant();
        airConditioner = new AirConditioner();
        tv = new Television();
        fan = new Fan();
        ACOnCommand acOnCommand = new ACOnCommand(airConditioner);
        ACOffCommand acOffCommand = new ACOffCommand(airConditioner);
        TvOnCommand tvOnCommand = new TvOnCommand(tv);
        TvOffCommand tvOffCommand = new TvOffCommand(tv);
        FanOnCommand fanOnCommand = new FanOnCommand(fan);
        FanOffCommand fanOffCommand = new FanOffCommand(fan);
        FanIncreaseSpeedCommand fanIncreaseSpeedCommand = new FanIncreaseSpeedCommand(fan);
        FanDecreaseSpeedCommand fanDecreaseSpeedCommand = new FanDecreaseSpeedCommand(fan);
        homeAssistant.setupCommand("TurnOnAc", acOnCommand);
        homeAssistant.setupCommand("TurnOffAc", acOffCommand);
        homeAssistant.setupCommand("OnTv", tvOnCommand);
        homeAssistant.setupCommand("OffTv", tvOffCommand);
        homeAssistant.setupCommand("SwitchOnFan", fanOnCommand);
        homeAssistant.setupCommand("SwitchOffFan", fanOffCommand);
        homeAssistant.setupCommand("IncreaseFanSpeed", fanIncreaseSpeedCommand);
        homeAssistant.setupCommand("DecreaseFanSpeed", fanDecreaseSpeedCommand);
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
        homeAssistant.listen("SwitchOnFan");

        assertTrue(fan.isOn());
    }

    @Test
    public void homeAssistantShouldSwitchOffFan() {
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

    @Test
    public void homeAssistantShouldUndoThePreviousTask() {
        homeAssistant.listen("SwitchOnFan");
        homeAssistant.listen("undo");

        assertFalse(fan.isOn());
    }

    @Test
    public void homeAssistantShouldUndoMultiplePreviousTask() {
        homeAssistant.listen("OnTv");
        homeAssistant.listen("IncreaseFanSpeed");
        homeAssistant.listen("IncreaseFanSpeed");

        homeAssistant.listen("undo");
        homeAssistant.listen("undo");

        assertEquals(1, fan.getSpeed());
        assertTrue(tv.isOn());
    }
}
