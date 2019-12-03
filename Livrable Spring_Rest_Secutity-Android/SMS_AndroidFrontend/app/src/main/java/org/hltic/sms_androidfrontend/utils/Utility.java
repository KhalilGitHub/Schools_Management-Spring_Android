package org.hltic.sms_androidfrontend.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;


import org.hltic.sms_androidfrontend.R;

import java.math.BigDecimal;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Khalil Hisseine  hamdane.khalil.hisseine@gmail.com on 07/2019.
 */

public class Utility{


    public static String BASE_URL_USERS = "http://192.168.1.101:8080/users/";

    public static String BASE_URL_REGISTRATIONS = "http://192.168.1.101:8080/registration/api/";

    public static String BASE_URL_RECRUITMENTS = "http://192.168.1.101:8080/recrutment/api/";

    // trouve ID  de l'image correspondant à partie du nom de l'image (dans le repertoire ressource drawable).
    public static  int getDrawableResIdByNom(Context context, String resNom)  {
        String pkgName = context.getPackageName();
        // Return 0 si non trouve.
        int resID = context.getResources().getIdentifier(resNom , "drawable", pkgName);
        Log.i("Utility", "Resource Name : "+ resNom+"==> Resource ID = "+ resID);
        return resID;
    }



    public static String getPreferredToken(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(context.getString(R.string.pref_token_key),
                context.getString(R.string.pref_token_default));
    }
    public static void setPreferredToken(Context context, String token) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(context.getString(R.string.pref_token_key), token);
        editor.commit();
    }

    public static OkHttpClient getClientHttpForAll(Context context) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);

        return builder.build();

    }


    public static BigDecimal convertStringToBigDecimal(String bdStr)
    {
        BigDecimal result = null;
        try
        {
            double valueDouble = Double.parseDouble(bdStr);
            result = BigDecimal.valueOf(valueDouble);
        }
        catch(Exception ex)
        {
            System.out.println("Valeur invalid. Valeur par defaut to 0.0");
            result = BigDecimal.valueOf(0.0);
        }
        return result;
    }



}
