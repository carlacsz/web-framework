package com.webfw.commands;

import com.webfw.ApplicationException;
import com.webfw.WebCommand;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public abstract class PictureCommand extends WebCommand {

    @Override
    protected void execute(HttpServletRequest req, HttpServletResponse resp) throws ApplicationException, IOException {
        String method = req.getMethod();
        if (method.equals("GET")) {
            this.renderImage(req, resp);
        } else {
            throw new ApplicationException("Method not supported for this resource", 501);
        }
    }

    @Override
    protected String getContentType() {
        return "image";
    }

    protected String getImagePath() {
        return null;
    }

    private void renderImage(HttpServletRequest req, HttpServletResponse resp) throws ApplicationException, IOException {

        ServletContext cntx = req.getServletContext();
        String filename = cntx.getRealPath(getImagePath());
        String mime = cntx.getMimeType(getImagePath());
        if (filename == null || mime == null) {
            throw new ApplicationException("Not a valid image defined", 400);
        }
        File file = new File(filename);
        resp.setContentLength((int) file.length());

        try (FileInputStream in = new FileInputStream(file); OutputStream out = resp.getOutputStream()) {
            // Copy the contents of the file to the output stream
            byte[] buf = new byte[1024];
            int count = 0;
            while ((count = in.read(buf)) >= 0) {
                out.write(buf, 0, count);
            }
        } catch (FileNotFoundException e) {
            throw new ApplicationException("Image not found", 404);
        }

    }
}
