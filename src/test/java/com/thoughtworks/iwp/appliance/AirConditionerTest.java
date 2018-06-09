package com.thoughtworks.iwp.appliance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AirConditionerTest {
    AirConditioner airConditioner;

    @Before
    public void setUp() {
        airConditioner = new AirConditioner();
    }

    @Test
    public void returnTrueWhenAcIsTurnedOn() {
        airConditioner.turnOn();
        assertTrue(airConditioner.isOn());
    }

    @Test
    public void returnFalseWhenAcIsTurnedOff() {
        airConditioner.turnOff();
        assertFalse(airConditioner.isOn());
    }
}
