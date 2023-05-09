package com.automationanywhere;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.DateTimeValue;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.DATETIME;


@BotCommand

//CommandPks adds required information to be dispalable on GUI.
@CommandPkg(
        //Unique name inside a package and label to display.
        name = "StringAdvancedtoDate", label = "To date",
        node_label = "To date", description = "Converts string to date variable - format ISO_LOCAL_DATE ('2023-05-08')", icon = "string.svg",

        //Return type information. return_type ensures only the right kind of variable is provided on the UI.
        return_label = "Assign the output to variable", return_type = DATETIME, return_required = true)
public class ToDate {
    //Messages read from full qualified property file name and provide i18n capability.
    private static final Messages MESSAGES = MessagesFactory
            .getMessages("com.automationanywhere.botcommand.samples.messages");

    //Identify the entry point for the action. Returns a Value<String> because the return type is String.
    @Execute
    public Value<ZonedDateTime> action(
            //Idx 1 would be displayed first, with a text box for entering the value.
            @Idx(index = "1", type = TEXT)
            //UI labels.
            @Pkg(label = "Source string")
            //Ensure that a validation error is thrown when the value is null.
            @NotEmpty
            String inputString,

            @Idx(index = "2", type = TEXT)
            @Pkg(label = "Date format of provided string")
            @NotEmpty
            String inputFormat){

        //Internal validation, to disallow empty strings. No null check needed as we have NotEmpty on firstString.
        if (null==inputString||inputString.isEmpty())
            throw new BotCommandException(MESSAGES.getString("emptyInputString", "inputString"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(inputFormat);
        LocalDate date = LocalDate.parse(inputString,formatter);
        ZonedDateTime zonedDateTime = date.atStartOfDay(ZoneId.systemDefault());
        return new DateTimeValue(zonedDateTime);

    }
}
