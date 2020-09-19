package com.webfwdynamicform.commands;

import com.webfw.commands.HtmlCommand;

public class FillFormCommand extends HtmlCommand {
    @Override
    protected String getJspPath() {
        return "/dynamic-form/pages/fill-form.jsp";
    }
}
