package com.webfwdynamicform.commands;

import com.webfw.commands.HtmlCommand;

public class PrintFormCommand extends HtmlCommand {
    @Override
    protected String getJspPath() {
        return "/dynamic-form/pages/print-form.jsp";
    }
}
