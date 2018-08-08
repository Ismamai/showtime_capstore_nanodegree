
package com.iblesa.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class BoxOfficeInfo implements Parcelable
{

    @SerializedName("phoneNumberDetail")
    @Expose
    private String phoneNumberDetail;
    @SerializedName("openHoursDetail")
    @Expose
    private String openHoursDetail;
    @SerializedName("willCallDetail")
    @Expose
    private String willCallDetail;
    public final static Parcelable.Creator<BoxOfficeInfo> CREATOR = new Creator<BoxOfficeInfo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BoxOfficeInfo createFromParcel(Parcel in) {
            return new BoxOfficeInfo(in);
        }

        public BoxOfficeInfo[] newArray(int size) {
            return (new BoxOfficeInfo[size]);
        }

    }
    ;

    protected BoxOfficeInfo(Parcel in) {
        this.phoneNumberDetail = ((String) in.readValue((String.class.getClassLoader())));
        this.openHoursDetail = ((String) in.readValue((String.class.getClassLoader())));
        this.willCallDetail = ((String) in.readValue((String.class.getClassLoader())));
    }

    public BoxOfficeInfo() {
    }

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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(phoneNumberDetail);
        dest.writeValue(openHoursDetail);
        dest.writeValue(willCallDetail);
    }

    public int describeContents() {
        return  0;
    }

}
