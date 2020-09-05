package com.webfwtest;

import com.webfw.commands.PictureCommand;


public class PhotoCommand extends PictureCommand {
    @Override
    protected String getImagePath() {
        return getParameters().get("n");
    }
}
