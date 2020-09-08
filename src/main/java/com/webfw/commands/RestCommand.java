package com.webfw.commands;

import com.webfw.ApplicationException;
import com.webfw.WebCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class RestCommand extends WebCommand {

    @Override
    protected void execute(HttpServletRequest req, HttpServletResponse resp) throws ApplicationException, IOException {
        String method = req.getMethod();
        if (method.equals("GET")) {
            this.get(req, resp);
        } else if (method.equals("POST")) {
            this.post(req, resp);
        } else if (method.equals("PUT")) {
            this.put(req, resp);
        } else if (method.equals("DELETE")) {
            this.delete(req, resp);
        } else {
            throw new ApplicationException("Method not supported for this resource", 501);
        }
    }

    protected void get(HttpServletRequest req, HttpServletResponse resp) throws ApplicationException, IOException {
    }

    protected void post(HttpServletRequest req, HttpServletResponse resp) throws ApplicationException, IOException {
    }

    protected void put(HttpServletRequest req, HttpServletResponse resp) throws ApplicationException, IOException {
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ApplicationException, IOException {
    }
}
