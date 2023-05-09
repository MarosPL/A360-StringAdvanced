package com.automationanywhere;

import com.automationanywhere.Proper;
import com.automationanywhere.botcommand.data.Value;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestProper {

    @Test
    public void TestStringAdvancedAction(){
        String inputString = "aLa mA koTa";

        Proper proper = new Proper();

        Value<String> properString =  proper.action(inputString);

        System.out.println(properString.toString());
        Assert.assertEquals(properString.toString(),"Ala Ma Kota");
    }
}
