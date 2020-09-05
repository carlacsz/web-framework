package com.webfwtest;

import com.webfw.commands.PlainTextCommand;


public class ReverseStringCommand extends PlainTextCommand {

    @Override
    protected String getPlainText() {
        String str = getParameters().get("str");
        if (str == null) {
            return "Not a valid word defined";
        }
        StringBuilder reverseStr = new StringBuilder();
        reverseStr.append(str);
        reverseStr = reverseStr.reverse();
        return reverseStr.toString();
    }
}
