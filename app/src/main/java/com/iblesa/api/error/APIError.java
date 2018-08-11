
package com.iblesa.api.error;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class APIError {

    @SerializedName("fault")
    @Expose
    private Fault fault;

    public Fault getFault() {
        return fault;
    }

    public void setFault(Fault fault) {
        this.fault = fault;
    }

    public com.iblesa.api.error.APIError withFault(Fault fault) {
        this.fault = fault;
        return this;
    }

}
