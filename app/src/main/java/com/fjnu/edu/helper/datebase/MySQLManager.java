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
    public static void recommend(String[] id,int numbers) {
        try {
            String str = "http://139.199.174.96:5000/predict?item=56753-282252-291604-54405-984231&num=5";
            URL url = new URL(str);//创建URL
            URLConnection conn = url.openConnection();//打开连接对象
            HttpURLConnection httpConn = (HttpURLConnection) conn;
            httpConn.setRequestMethod("GET");//get请求
            httpConn.connect();
            if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {//如果正常返回
                InputStream in = httpConn.getInputStream();
                System.out.println(readString(in));
            }

        } catch (IOException e) {

        }
        catch(Exception e){
            e.printStackTrace();
        }
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
