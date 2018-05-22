package com.aspose.diagram.examples;

import com.aspose.diagram.License;

import java.io.File;

public class Utils {

    public static String getDataDir(Class c) {
        File dir = new File(System.getProperty("user.dir"));
        dir = new File(dir, "src");
        dir = new File(dir, "main");
        dir = new File(dir, "resources");

        for (String s : c.getName().split("\\.")) 
        {
            dir = new File(dir, s);
            if (dir.isDirectory() == false)
                dir.mkdir();
        }

        System.out.println("Using data directory: " + dir.toString());
        return dir.toString() + File.separator;
    }
    
    public static String getSharedDataDir(Class c) {
        File dir = new File(System.getProperty("user.dir"));
        dir = new File(dir, "src");
        dir = new File(dir, "main");
        dir = new File(dir, "resources");
        
        return dir.toString() + File.separator;
    }
}
