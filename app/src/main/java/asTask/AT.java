package asTask;

import android.os.AsyncTask;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import bean.ManHua;
import listener.Respon;
import utils.StringRead;

/**
 * Created by lenovo on 2017/4/27.
 */

public class AT extends AsyncTask<Object,Void,String> {


    private Respon  respon;
    private String io;

    public AT(Respon respon) {
        this.respon = respon;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Object... params) {


        try {

            String  path=(String) params[0];

            URL  url=new URL(path);

            HttpURLConnection  conn=(HttpURLConnection)url.openConnection();

           conn.setRequestMethod("GET");

            conn.setConnectTimeout(2000);
            conn.setReadTimeout(2000);

            if (conn.getResponseCode()==200){
                InputStream is = conn.getInputStream();

                io = StringRead.readIO(is);


            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return io;
    }


    @Override
    protected void onPostExecute(String list) {
        super.onPostExecute(list);

       if (respon!=null){
       if (list!=null){

        respon.success(list);
    }else{

         respon.fail();
       }


}else{

           respon.fail();
       }

}

    @Override
    protected void onCancelled() {
        super.onCancelled();

        if (respon!=null){

            respon.fail();

        }
    }
}
