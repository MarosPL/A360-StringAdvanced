package com.automationanywhere;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;

import java.util.Random;

import static com.automationanywhere.commandsdk.model.AttributeType.*;
import static com.automationanywhere.commandsdk.model.DataType.STRING;


@BotCommand

//CommandPks adds required information to be dispalable on GUI.
@CommandPkg(
        //Unique name inside a package and label to display.
        name = "StringAdvancedRandomLetters", label = "Random letters",
        node_label = "Random letters", description = "Generate a string of alphabetic characters and assigns it to a string variable", icon = "string.svg",

        //Return type information. return_type ensures only the right kind of variable is provided on the UI.
        return_label = "Assign the output to variable", return_type = STRING, return_required = true)
public class RandomLetters {
    //Messages read from full qualified property file name and provide i18n capability.
    private static final Messages MESSAGES = MessagesFactory
            .getMessages("com.automationanywhere.botcommand.samples.messages");

    //Identify the entry point for the action. Returns a Value<String> because the return type is String.
    @Execute
    public Value<String> action(
            //Idx 1 would be displayed first, with a text box for entering the value.
            @Idx(index = "1", type = NUMBER)
            //UI labels.
            @Pkg(label = "String Length")
            //Ensure that a validation error is thrown when the value is null.
            @NotEmpty
            Double length,

            @Idx(index = "2", type = BOOLEAN)
            @Pkg(label = "Uppercase")
            @NotEmpty
            Boolean uppercase){

        //Internal validation, to disallow empty strings. No null check needed as we have NotEmpty on firstString.
        if (length <= 0) throw new BotCommandException(MESSAGES.getString("lengthEqualsZero","length"));

        String letters = uppercase ? "ABCDEFGHIJKLMNOPQRSTUVWXYZ" : "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();

        StringBuilder sb = new StringBuilder(length.intValue());
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(letters.length());
            char randomChar = letters.charAt(index);
            sb.append(randomChar);
        }
        return new StringValue(sb.toString());
    }
}
