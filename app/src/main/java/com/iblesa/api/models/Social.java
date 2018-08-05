
package com.iblesa.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Social {

    @SerializedName("twitter")
    @Expose
    private Twitter twitter;

    public Twitter getTwitter() {
        return twitter;
    }

    public void setTwitter(Twitter twitter) {
        this.twitter = twitter;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("twitter", twitter).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(twitter).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Social) == false) {
            return false;
        }
        Social rhs = ((Social) other);
        return new EqualsBuilder().append(twitter, rhs.twitter).isEquals();
    }

}
