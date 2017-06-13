package com.fjnu.edu.helper.datebase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.fjnu.edu.helper.food.AddFoodInformation;
import com.fjnu.edu.helper.food.Food;
import com.fjnu.edu.helper.food.MyFood;

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
        String sql = "select * from food where 1 = 1 and materialName like '%" + str + "%'";
        Cursor c = db.rawQuery(sql, null);
        ArrayList<AddFoodInformation> list = new ArrayList<AddFoodInformation>();
        while (c.moveToNext()) {
            String id = c.getString(c.getColumnIndex("mno"));
            String name = c.getString(c.getColumnIndex("materialName"));
            String picture = c.getString(c.getColumnIndex("image"));
            AddFoodInformation afi = new AddFoodInformation(id, name, picture);
            list.add(afi);
        }
        c.close();
        return list;
    }

    public void InsertMyfood(MyFood food) {
        String sql = null;
        sql = "insert into myfood(No,Quantity,Inputdate,Unit)" +
                "values ('" + food.getMno() + "'," + food.getResidue() +
                ",datetime('now', 'localtime')," + food.getUnit() + "')";
        db.execSQL(sql);
    }

    public void UpdateMyfood(MyFood food){
        String sql=null;
        sql="update information set flag = 'T' where information_no = ";
        db.execSQL(sql);
    }

    public Food QueryFoodByNo(String mno) {
        String sql = "select * from food where materialName = '" + mno + "'";
        Cursor c = db.rawQuery(sql, null);
        Food food = null;
        while (c.moveToNext()) {
            String name = c.getString(c.getColumnIndex("materialName"));
            int storage1 = c.getInt(c.getColumnIndex("storage1"));
            int storage2 = c.getInt(c.getColumnIndex("storage2"));
            int storage3 = c.getInt(c.getColumnIndex("storage3"));
            food = new Food(mno, name, storage1, storage2, storage3);
        }
        return food;
    }
}
