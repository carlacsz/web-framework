package com.webfwtest;

import com.webfw.commands.HtmlCommand;

public class HelloWorldCommand extends HtmlCommand {

    @Override
    public String getJspPath() {
        return "/pages/hello.jsp";
    }

}
