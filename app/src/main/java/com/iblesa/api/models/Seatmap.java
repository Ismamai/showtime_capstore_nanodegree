
package com.iblesa.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Seatmap {

    @SerializedName("staticUrl")
    @Expose
    private String staticUrl;

    public String getStaticUrl() {
        return staticUrl;
    }

    public void setStaticUrl(String staticUrl) {
        this.staticUrl = staticUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("staticUrl", staticUrl).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(staticUrl).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Seatmap) == false) {
            return false;
        }
        Seatmap rhs = ((Seatmap) other);
        return new EqualsBuilder().append(staticUrl, rhs.staticUrl).isEquals();
    }

}
