package com.automationanywhere;

import org.testng.annotations.Test;

public class RandomLettersTest {

    @Test
    public void testActionLowercase() {
        Double length = 5.0;

        RandomLetters randomLetters = new RandomLetters();
        String output = String.valueOf(randomLetters.action(length,false));
        System.out.println(output);
    }
    @Test
    public void testActionUppercase() {
        Double length = 5.0;

        RandomLetters randomLetters = new RandomLetters();
        String output = String.valueOf(randomLetters.action(length,true));
        System.out.println(output);
    }
    @Test
    public void testActionWrongInput() {
        Double length = -1.0;

        RandomLetters randomLetters = new RandomLetters();
        String output = String.valueOf(randomLetters.action(length,true));
        System.out.println(output);
    }

}