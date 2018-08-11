
package com.iblesa.api.error;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Detail {

    @SerializedName("errorcode")
    @Expose
    private String errorcode;

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public Detail withErrorcode(String errorcode) {
        this.errorcode = errorcode;
        return this;
    }

}
