package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConditionerTest {
    Conditioner conditioner = new Conditioner();

    @Test
    public void shouldCreateNewConditioner() {
        String name = "MorozMatic";
        conditioner.setName(name);
        assertEquals(name,conditioner.getName());
        System.out.println("Conditioner: " + conditioner.getName());
    }

    @Test
    public void turnOn(){
        conditioner.setOn(true);
        System.out.println("Conditioner is on = " + conditioner.isOn());
    }

    @Test
    public void turnOff(){
        conditioner.setOn(false);
        System.out.println("Conditioner is on = " + conditioner.isOn());
    }

    @Test
    public void shouldSetDeltaTemperature(){
        conditioner.setMinTemperature(5);
        conditioner.setMaxTemperature(35);
        assertEquals(5,conditioner.getMinTemperature());
        assertEquals(35,conditioner.getMaxTemperature());
        System.out.println("Temperature was set: min = " + conditioner.getMinTemperature() + " max = " + conditioner.getMaxTemperature());
    }

    @Test
    public void shouldSetCurrentTemperature(){
        conditioner.setCurrentTemperature(25);
        assertEquals(25,conditioner.getCurrentTemperature());
        System.out.println("Current temperature = " + conditioner.getCurrentTemperature());
    }

    @Test
    public void shouldSetCurrentTemperatureOverMax(){
        conditioner.setCurrentTemperature(50);
        assertEquals(20,conditioner.getCurrentTemperature());
        System.out.println("Current temperature = " + conditioner.getCurrentTemperature());
    }

    @Test
    public void shouldSetCurrentTemperatureBelowMin(){
        conditioner.setCurrentTemperature(5);
        assertEquals(20,conditioner.getCurrentTemperature());
        System.out.println("Current temperature = " + conditioner.getCurrentTemperature());
    }

    @Test
    public void shouldRaiseTemperatureNoHigherThanMaximum(){
        System.out.println("Started method shouldRaiseTemperatureNoHigherThanMaximum()");
        for (int i = conditioner.getCurrentTemperature(); i < (conditioner.getMaxTemperature() + 3); i++){
            conditioner.increaseCurrentTemperature();
        }
    }

    @Test
    public void shouldLowerTemperatureNoLowerThanMinimum(){
        System.out.println("Started method shouldLowerTemperatureNoLowerThanMinimum()");
        for (int i = conditioner.getCurrentTemperature(); i > (conditioner.getMinTemperature() - 3); i--) {
            conditioner.decreaseCurrentTemperature();
        }
    }

}