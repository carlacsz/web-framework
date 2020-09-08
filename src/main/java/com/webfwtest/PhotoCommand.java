package com.webfwtest;

import com.webfw.commands.PictureCommand;


public class PhotoCommand extends PictureCommand {
    @Override
    protected String getImagePath() {
        String path = getParameters().get("n");
        if(path != null){
            return "/resources/" + path;
        }
        return null;
    }
}
