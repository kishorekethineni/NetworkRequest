package com.kishore.resusablenetworkcall;

import android.app.Activity;
import android.content.res.Resources;
import android.util.Log;
import android.widget.Toast;
import java.io.IOException;

public class NetworkUtils {

    public static boolean isConnected(Activity activity,String msg,String ip) {
        Runtime runtime = Runtime.getRuntime();
        try {
            String pingCommand = ip==null?"/system/bin/ping -c " + "1" + " " + "8.8.8.8":"/system/bin/ping -c " + "1" + " " + ip;
            Process ipProcess = runtime.exec(pingCommand);
            int     exitValue = ipProcess.waitFor();
            Log.i("exitvalue",exitValue+"");
            if (exitValue == 0)
                return true;
            else{
                Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
                return false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(activity, "Given server not exists or not responding", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public static boolean isResource(Activity context, int resId){
        if (context != null){
            try {
                return context.getResources().getResourceName(resId) != null;
            } catch (Resources.NotFoundException ignore) {
                return false;
            }
        }
        return false;
    }

}
