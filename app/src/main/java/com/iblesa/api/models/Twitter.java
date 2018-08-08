
package com.iblesa.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Twitter implements Parcelable
{

    @SerializedName("handle")
    @Expose
    private String handle;
    public final static Parcelable.Creator<Twitter> CREATOR = new Creator<Twitter>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Twitter createFromParcel(Parcel in) {
            return new Twitter(in);
        }

        public Twitter[] newArray(int size) {
            return (new Twitter[size]);
        }

    }
    ;

    protected Twitter(Parcel in) {
        this.handle = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Twitter() {
    }

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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(handle);
    }

    public int describeContents() {
        return  0;
    }

}
