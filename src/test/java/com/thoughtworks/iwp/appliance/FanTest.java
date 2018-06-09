package com.thoughtworks.iwp.appliance;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FanTest {
    Fan fan;

    @Before
    public void setUp() {
        fan = new Fan();
    }

    @Test
    public void returnTrueWhenFanIsTurnedOn() {
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
    public void returnIncreasedSpeedWhenIncreaseSpeedIsCalled() {
        fan.increaseSpeed();

        assertEquals(2, fan.getSpeed());
    }

    @Test
    public void returnDecreasedSpeedWhenDecreaseSpeedIsCalled() {
        fan.increaseSpeed();
        fan.decreaseSpeed();

        assertEquals(1, fan.getSpeed());
    }

    @Test
    public void shouldNotIncreaseSpeedAboveFive() {
        fan.increaseSpeed();
        fan.increaseSpeed();
        fan.increaseSpeed();
        fan.increaseSpeed();
        fan.increaseSpeed();
        fan.increaseSpeed();

        assertEquals(5, fan.getSpeed());
    }

    @Test
    public void shouldNotDecreaseBelowOne() {
        fan.decreaseSpeed();
        fan.decreaseSpeed();
        fan.decreaseSpeed();

        assertEquals(1, fan.getSpeed());
    }
}
