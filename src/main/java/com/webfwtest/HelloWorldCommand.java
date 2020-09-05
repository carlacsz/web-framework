package com.webfwtest;

import com.webfw.commands.HtmlCommand;

public class HelloWorldCommand extends HtmlCommand {

    @Override
    public String getHtml() {
        return "<h1>hello World!</h1>";
    }

}
