
package com.iblesa.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Twitter {

    @SerializedName("handle")
    @Expose
    private String handle;

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("handle", handle).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(handle).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Twitter) == false) {
            return false;
        }
        Twitter rhs = ((Twitter) other);
        return new EqualsBuilder().append(handle, rhs.handle).isEquals();
    }

}
