
package com.iblesa.api.error;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fault {

    @SerializedName("faultstring")
    @Expose
    private String faultstring;
    @SerializedName("detail")
    @Expose
    private Detail detail;

    public String getFaultstring() {
        return faultstring;
    }

    public void setFaultstring(String faultstring) {
        this.faultstring = faultstring;
    }

    public Fault withFaultstring(String faultstring) {
        this.faultstring = faultstring;
        return this;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public Fault withDetail(Detail detail) {
        this.detail = detail;
        return this;
    }

}
