package com.webfw.commands;

import com.webfw.ApplicationException;
import com.webfw.WebCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class HtmlCommand extends WebCommand {

    @Override
    protected void execute(HttpServletRequest req, HttpServletResponse resp) throws ApplicationException, IOException {
        String method = req.getMethod();
        if (method.equals("GET")) {
            resp.setContentType(getContentType());
            resp.getWriter().write(getHtml());
        } else {
            throw new ApplicationException("Method not supported for this resource", 501);
        }
    }

    @Override
    protected String getContentType() {
        return "text/html";
    }

    protected String getHtml(){
        return "";
    }
}
