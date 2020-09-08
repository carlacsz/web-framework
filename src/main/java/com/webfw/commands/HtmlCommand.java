package com.webfw.commands;

import com.webfw.ApplicationException;
import com.webfw.WebCommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public abstract class HtmlCommand extends WebCommand {

    @Override
    protected void execute(HttpServletRequest req, HttpServletResponse resp) throws ApplicationException, IOException {
        String method = req.getMethod();
        if (method.equals("GET")) {
            try {
                RequestDispatcher dispatcher = req.getRequestDispatcher(getJspPath());
                dispatcher.forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                throw new ApplicationException("Not valid page found", 500);
            }
        } else {
            throw new ApplicationException("Method not supported for this resource", 501);
        }
    }

    @Override
    protected String getContentType() {
        return "text/html";
    }

    protected String getJspPath(){
        return null;
    }
}
