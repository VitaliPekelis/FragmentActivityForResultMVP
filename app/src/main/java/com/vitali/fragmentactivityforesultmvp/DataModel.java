package com.vitali.fragmentactivityforesultmvp;

import java.io.Serializable;

public class DataModel implements Serializable {

    private String dataString;

    public String getDataString() {
        return dataString;
    }

    public DataModel setDataString(String dataString) {
        this.dataString = dataString;
        return this;
    }
}
