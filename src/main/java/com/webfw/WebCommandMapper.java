package com.webfw;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

class WebCommandMapper {
    public static final Logger LOGGER = Logger.getLogger(WebCommandMapper.class.getName());
    public String basePackage;

    public WebCommandMapper(String basePackage) {
        this.basePackage = basePackage;
    }

    public WebCommand getCommand(HttpServletRequest request) throws ApplicationException {
        String reqName = request.getPathInfo();
        if (reqName == null) {
            return new HomeCommand();
        } else {
            reqName = reqName.replace("/", "");
            if (reqName.equals("")) {
                return new HomeCommand();
            } else {
                try {
                    String className = getCompleteClassName(reqName);
                    Class<?> clazz = Class.forName(className);
                    Constructor<?> constructor = clazz.getConstructor();
                    WebCommand command = (WebCommand) constructor.newInstance();
                    LOGGER.info(className + " has been initialized");
                    return command;
                } catch (ReflectiveOperationException | ClassCastException e) {
                    LOGGER.info("Failed to initialize command " + reqName);
                    LOGGER.info(e.getMessage());
                    throw new ApplicationException("Could not find resource " + reqName, 404);
                }
            }
        }
    }

    private String getCompleteClassName(String requestName) {
        return basePackage + '.' + requestName + "Command";
    }
}
