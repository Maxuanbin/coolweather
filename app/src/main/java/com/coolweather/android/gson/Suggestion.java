package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

public class Suggestion {


    @SerializedName("comf")
    public Comfort comfort;

    @SerializedName("cw")
    public CarWash carWash;

    public Sport sport;


    public class Comfort{

        public String type;

        public String brf;

        @SerializedName("txt")
        public String info;
    }

    public class CarWash {

        public String type;

        public String brf;

        @SerializedName("txt")
        public String info;
    }

    public class Sport {

        public String type;

        public String brf;

        @SerializedName("txt")
        public String info;
    }
}
