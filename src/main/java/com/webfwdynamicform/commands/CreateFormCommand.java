package com.webfwdynamicform.commands;

import com.webfw.ApplicationException;
import com.webfw.commands.HtmlCommand;
import com.webfw.commands.RestCommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateFormCommand extends RestCommand {

    @Override
    protected String getContentType() {
        return null;
    }

    @Override
    protected void get(HttpServletRequest req, HttpServletResponse resp) throws ApplicationException, IOException {
        try {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/dynamic-form/pages/create-form.jsp");
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new ApplicationException(e.getMessage(), 500);
        }
    }

    @Override
    protected void post(HttpServletRequest req, HttpServletResponse resp) throws ApplicationException, IOException {
        String some = "";
    }
}
