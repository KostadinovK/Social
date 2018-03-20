package com.kosta.social;

import android.content.Context;
import android.graphics.Bitmap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Kostadin Kostadinov on 20/03/2018.
 */

public class FileUtils {

    public static File bitmapToTempFile(Context context, Bitmap bitmap){
        FileOutputStream out = null;
        String filename = "tempfile.png";
        File file = new File(context.getCacheDir(),filename);
        try{
            out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,out);

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(out != null){
                    out.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return file;

    }
}
