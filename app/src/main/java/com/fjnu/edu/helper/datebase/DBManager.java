package com.fjnu.edu.helper.datebase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.fjnu.edu.helper.food.AddFoodInformation;

import java.util.ArrayList;

/**
 * Created by ZhouShiqiao on 2017/5/30 0030.
 */

public class DBManager {
    private DBHelper helper;
    protected SQLiteDatabase db;

    public DBManager(Context context) {
        helper = new DBHelper(context);
        db = helper.getWritableDatabase();
    }

    public ArrayList<AddFoodInformation> queryaddfoodinformation(String str) {
        String sql = "select * from food where 1 = 1 and materialName like '%"+str+"%'";
        Cursor c = db.rawQuery(sql, null);
        ArrayList<AddFoodInformation> list = new ArrayList<AddFoodInformation>();
        while(c.moveToNext()){
            String id=c.getString(c.getColumnIndex("mno"));
            String name=c.getString(c.getColumnIndex("materialName"));
            String picture=c.getString(c.getColumnIndex("image"));
            AddFoodInformation afi = new AddFoodInformation(id,name,picture);
            list.add(afi);
        }
        c.close();
        return list;
    }
}
