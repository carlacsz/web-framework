package com.webfw;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RequestRouterServlet extends HttpServlet {
    public static final Logger LOGGER = Logger.getLogger("com.webfw");
    private static WebCommandMapper webCommandMapper;

    @Override
    public void init() {
        LOGGER.setLevel(Level.INFO);
        webCommandMapper = new WebCommandMapper(getServletConfig().getInitParameter("basePackage"));
        LOGGER.info("RequestRouterServlet has been initialized");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            WebCommand webCommand = webCommandMapper.getCommand(req);
            webCommand.setParameters(req);
            webCommand.execute(req, resp);
        } catch (ApplicationException e) {
            LOGGER.info(e.getMessage());
            resp.sendError(e.getStatusCode(), e.getMessage());
        }
    }
}
