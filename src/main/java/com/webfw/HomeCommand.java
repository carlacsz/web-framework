package com.webfw;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeCommand extends WebCommand {
    @Override
    protected void execute(HttpServletRequest req, HttpServletResponse resp) throws ApplicationException, IOException {
        try {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new ApplicationException(e.getMessage(), 500);
        }
    }

    @Override
    protected String getContentType() {
        return "text/hmtl";
    }
}
