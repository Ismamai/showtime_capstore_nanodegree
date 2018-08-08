
package com.iblesa.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class TicketLimit implements Parcelable
{

    @SerializedName("info")
    @Expose
    private String info;
    public final static Parcelable.Creator<TicketLimit> CREATOR = new Creator<TicketLimit>() {


        @SuppressWarnings({
            "unchecked"
        })
        public TicketLimit createFromParcel(Parcel in) {
            return new TicketLimit(in);
        }

        public TicketLimit[] newArray(int size) {
            return (new TicketLimit[size]);
        }

    }
    ;

    protected TicketLimit(Parcel in) {
        this.info = ((String) in.readValue((String.class.getClassLoader())));
    }

    public TicketLimit() {
    }

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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(info);
    }

    public int describeContents() {
        return  0;
    }

}
