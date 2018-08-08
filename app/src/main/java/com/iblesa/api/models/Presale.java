
package com.iblesa.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Presale implements Parcelable
{

    @SerializedName("startDateTime")
    @Expose
    private String startDateTime;
    @SerializedName("endDateTime")
    @Expose
    private String endDateTime;
    @SerializedName("name")
    @Expose
    private String name;
    public final static Parcelable.Creator<Presale> CREATOR = new Creator<Presale>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Presale createFromParcel(Parcel in) {
            return new Presale(in);
        }

        public Presale[] newArray(int size) {
            return (new Presale[size]);
        }

    }
    ;

    protected Presale(Parcel in) {
        this.startDateTime = ((String) in.readValue((String.class.getClassLoader())));
        this.endDateTime = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Presale() {
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("startDateTime", startDateTime).append("endDateTime", endDateTime).append("name", name).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(startDateTime).append(endDateTime).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Presale) == false) {
            return false;
        }
        Presale rhs = ((Presale) other);
        return new EqualsBuilder().append(name, rhs.name).append(startDateTime, rhs.startDateTime).append(endDateTime, rhs.endDateTime).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(startDateTime);
        dest.writeValue(endDateTime);
        dest.writeValue(name);
    }

    public int describeContents() {
        return  0;
    }

}
