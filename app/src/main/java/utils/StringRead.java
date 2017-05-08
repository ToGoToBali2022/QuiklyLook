package utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lenovo on 2017/4/12.
 */

public class StringRead {

    public static  String readIO(InputStream is){
        ByteArrayOutputStream  baos=new ByteArrayOutputStream();

        int len=0;
        byte[] buffer=new byte[1024];

        try {
            while ((len=is.read(buffer))!=-1){
                baos.write(buffer,0,len);

            }




        } catch (IOException e) {
            e.printStackTrace();
        }
     return   baos.toString();
    }
}
