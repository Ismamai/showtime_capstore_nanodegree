
package com.iblesa.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class BoxOfficeInfo {

    @SerializedName("phoneNumberDetail")
    @Expose
    private String phoneNumberDetail;
    @SerializedName("openHoursDetail")
    @Expose
    private String openHoursDetail;
    @SerializedName("willCallDetail")
    @Expose
    private String willCallDetail;

    public String getPhoneNumberDetail() {
        return phoneNumberDetail;
    }

    public void setPhoneNumberDetail(String phoneNumberDetail) {
        this.phoneNumberDetail = phoneNumberDetail;
    }

    public String getOpenHoursDetail() {
        return openHoursDetail;
    }

    public void setOpenHoursDetail(String openHoursDetail) {
        this.openHoursDetail = openHoursDetail;
    }

    public String getWillCallDetail() {
        return willCallDetail;
    }

    public void setWillCallDetail(String willCallDetail) {
        this.willCallDetail = willCallDetail;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("phoneNumberDetail", phoneNumberDetail).append("openHoursDetail", openHoursDetail).append("willCallDetail", willCallDetail).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(willCallDetail).append(openHoursDetail).append(phoneNumberDetail).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BoxOfficeInfo) == false) {
            return false;
        }
        BoxOfficeInfo rhs = ((BoxOfficeInfo) other);
        return new EqualsBuilder().append(willCallDetail, rhs.willCallDetail).append(openHoursDetail, rhs.openHoursDetail).append(phoneNumberDetail, rhs.phoneNumberDetail).isEquals();
    }

}
