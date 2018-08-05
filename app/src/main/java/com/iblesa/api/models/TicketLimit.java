
package com.iblesa.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class TicketLimit {

    @SerializedName("info")
    @Expose
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("info", info).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(info).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TicketLimit) == false) {
            return false;
        }
        TicketLimit rhs = ((TicketLimit) other);
        return new EqualsBuilder().append(info, rhs.info).isEquals();
    }

}
