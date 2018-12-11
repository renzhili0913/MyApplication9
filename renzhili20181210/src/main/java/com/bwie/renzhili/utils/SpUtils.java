package com.bwie.renzhili.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SpUtils {
    private static final String SP_NAME ="OKHTTP_TEXT" ;
    /**
     * 保存
     * @param context 上下文
     * @param key key值
     * @param object value值
     */
    public static void save(Context context, String key, Object object){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);
        if (object instanceof String){
            sharedPreferences.edit().putString(key,(String)object).commit();
        }else if (object instanceof Boolean){
            sharedPreferences.edit().putBoolean(key,(Boolean) object).commit();
        }


    }
    /**
     * 获取字符串
     * @param context
     * @param key
     * @param object 默认值
     * @return
     */
    public static Object getString(Context context,String key,Object object){
        if (object instanceof String){
           return context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE).getString(key,(String)object);
        }else if (object instanceof Boolean){
            return context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE).getBoolean(key,(Boolean) object);
        }
       return null;
    }
}
