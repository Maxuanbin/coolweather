package com.coolweather.android.util;

import android.text.TextUtils;

import com.coolweather.android.db.City;
import com.coolweather.android.db.County;
import com.coolweather.android.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {

    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response){

        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allProvince = new JSONArray(response);

                for (int i = 0; i < allProvince.length(); i++){
                    JSONObject provinceObject = allProvince.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.setProvinceName(provinceObject.getString("name"));
                    province.save();
                }

                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(String response,int provinceId){

        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allCitys = new JSONArray(response);

                for (int i = 0; i < allCitys.length(); i ++){
                    JSONObject cityObject = allCitys.getJSONObject(i);

                    City city = new City();
                    city.setCityCode(cityObject.getInt("id"));
                    city.setCityName(cityObject.getString("name"));
                    city.setProvinceId(provinceId);
                    city.save();
                }

                return true;

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return false;
    }


    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountyResponse(String response,int cityId){
        if (TextUtils.isEmpty(response)){
            return false;
        }

        try {
            JSONArray allCountys = new JSONArray(response);

            for (int i = 0 ; i < allCountys.length();i ++){
                JSONObject countyObject = allCountys.getJSONObject(i);

                County county = new County();
                county.setCountyName(countyObject.getString("name"));
                county.setWeatherId(countyObject.getString("weather_id"));
                county.setCityId(cityId);
                county.save();
            }
            return true;

        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }

    }


}
