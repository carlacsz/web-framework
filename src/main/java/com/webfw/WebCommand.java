package com.webfw;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class WebCommand {


    Map<String, String> parameters = new HashMap<>();

    protected abstract void execute(HttpServletRequest req, HttpServletResponse resp) throws ApplicationException, IOException;

    protected abstract String getContentType();

    public Map<String, String> getParameters() {
        return parameters;
    }

    protected void setParameters(HttpServletRequest request) {
        for (Object key : request.getParameterMap().keySet()) {
            parameters.put(key.toString(), extractParameter(request.getParameterValues(key.toString())));
        }
    }

    private String extractParameter(String[] values) {
        if (values == null || values.length == 0) {
            return "";
        } else if (values.length == 1) {
            return values[0];
        } else {
            return String.join(",", values);
        }
    }
}
