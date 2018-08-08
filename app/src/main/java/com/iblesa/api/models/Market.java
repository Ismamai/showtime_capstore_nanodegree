
package com.iblesa.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Market implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    public final static Parcelable.Creator<Market> CREATOR = new Creator<Market>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Market createFromParcel(Parcel in) {
            return new Market(in);
        }

        public Market[] newArray(int size) {
            return (new Market[size]);
        }

    }
    ;

    protected Market(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Market() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Market) == false) {
            return false;
        }
        Market rhs = ((Market) other);
        return new EqualsBuilder().append(id, rhs.id).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
    }

    public int describeContents() {
        return  0;
    }

}
