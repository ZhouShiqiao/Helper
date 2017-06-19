package com.fjnu.edu.helper.datebase;


import com.fjnu.edu.helper.recipe.Recipe;
import com.fjnu.edu.helper.recipe.SimpleRecipe;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by ZhouShiqiao on 2017/6/18 0018.
 */

public class MySQLManager {
    public static ArrayList<SimpleRecipe> Query(String name) {
        return null;
    }

    public static ArrayList<SimpleRecipe> Query(String[] id) {
        return null;
    }

    public static Recipe QueryDetail(String id) {
        return null;
    }

    public static String[] recommend(String[] id,int numbers) {
        String items = id[0];
        for(int i=1;i<id.length;i++){
            items=items+"-"+id[i];
        }
        try {
            String str = "http://139.199.174.96:5000/predict?item="+items+"&num="+numbers;
            URL url = new URL(str);
            URLConnection conn = url.openConnection();
            HttpURLConnection httpConn = (HttpURLConnection) conn;
            httpConn.setRequestMethod("GET");
            httpConn.connect();
            if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream in = httpConn.getInputStream();
                String list = readString(in);
                list = list.replace("[", "");
                list = list.replace("]", "");
                String[] sourceStrArray = list.split(", ");
                return sourceStrArray;
            } else
                return null;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private static String readString(InputStream in) throws Exception {
        byte[]data = new byte[1024];
        int length = 0;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        while((length=in.read(data))!=-1){
            bout.write(data,0,length);
        }
        return new String(bout.toByteArray(),"UTF-8");

    }
}
