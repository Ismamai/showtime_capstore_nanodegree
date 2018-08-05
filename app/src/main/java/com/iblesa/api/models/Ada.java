
package com.iblesa.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Ada {

    @SerializedName("adaPhones")
    @Expose
    private String adaPhones;
    @SerializedName("adaCustomCopy")
    @Expose
    private String adaCustomCopy;
    @SerializedName("adaHours")
    @Expose
    private String adaHours;

    public String getAdaPhones() {
        return adaPhones;
    }

    public void setAdaPhones(String adaPhones) {
        this.adaPhones = adaPhones;
    }

    public String getAdaCustomCopy() {
        return adaCustomCopy;
    }

    public void setAdaCustomCopy(String adaCustomCopy) {
        this.adaCustomCopy = adaCustomCopy;
    }

    public String getAdaHours() {
        return adaHours;
    }

    public void setAdaHours(String adaHours) {
        this.adaHours = adaHours;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("adaPhones", adaPhones).append("adaCustomCopy", adaCustomCopy).append("adaHours", adaHours).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(adaCustomCopy).append(adaPhones).append(adaHours).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Ada) == false) {
            return false;
        }
        Ada rhs = ((Ada) other);
        return new EqualsBuilder().append(adaCustomCopy, rhs.adaCustomCopy).append(adaPhones, rhs.adaPhones).append(adaHours, rhs.adaHours).isEquals();
    }

}
