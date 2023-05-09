package com.automationanywhere;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestToDate {

    @Test
    public void testAction() {

        String inputString = "2002/03/12";
        String inputFormat = "yyyy/MM/dd";
        ToDate toDate = new ToDate();
        String test = toDate.action(inputString,inputFormat).toString();
        System.out.println(test);
        Assert.assertEquals(test, "2002-03-12T00:00:00+01:00[Europe/Paris]");
    }
}