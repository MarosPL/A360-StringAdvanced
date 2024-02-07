package com.automationanywhere;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;

import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.STRING;

@BotCommand

//CommandPks adds required information to be dispalable on GUI.
@CommandPkg(
        //Unique name inside a package and label to display.
        name = "StringAdvancedCapitalizeFirstLetterOfSentence", label = "Capitalize First Letter Of Sentence",
        node_label = "Capitalize First Letter Of Sentence", description = "Capitalize first letter of sentence", icon = "string.svg",

        //Return type information. return_type ensures only the right kind of variable is provided on the UI.
        return_label = "Assign the output to variable", return_type = STRING, return_required = true)
public class CapitalizeFirstLetterOfSentence {
    //Messages read from full qualified property file name and provide i18n capability.
    private static final Messages MESSAGES = MessagesFactory
            .getMessages("com.automationanywhere.botcommand.samples.messages");

    //Identify the entry point for the action. Returns a Value<String> because the return type is String.
    @Execute
    public Value<String> action(
            //Idx 1 would be displayed first, with a text box for entering the value.
            @Idx(index = "1", type = TEXT)
            //UI labels.
            @Pkg(label = "Source string")
            //Ensure that a validation error is thrown when the value is null.
            @NotEmpty
            String inputString) {

        //Internal validation, to disallow empty strings. No null check needed as we have NotEmpty on firstString.
        if ("".equals(inputString.trim()))
            throw new BotCommandException(MESSAGES.getString("emptyInputString", "inputString"));

        //Business logic

        String result = inputString.substring(0, 1).toUpperCase() + inputString.substring(1);

        //Return StringValue.
        return new StringValue(result);
    }
}
