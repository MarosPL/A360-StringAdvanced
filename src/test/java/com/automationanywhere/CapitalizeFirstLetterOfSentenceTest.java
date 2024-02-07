package com.automationanywhere;

import com.automationanywhere.botcommand.data.Value;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CapitalizeFirstLetterOfSentenceTest {

    @Test
    public void testAction() {
        String inputString = "ala ma kota";

        CapitalizeFirstLetterOfSentence capitalizeFirstLetterOfSentence = new CapitalizeFirstLetterOfSentence();

        Value<String> CapitalizedSentece = capitalizeFirstLetterOfSentence.action(inputString);

        System.out.println(CapitalizedSentece);
        Assert.assertEquals(CapitalizedSentece.toString(),"Ala ma kota");

    }
}