
package com.iblesa.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Seatmap implements Parcelable
{

    @SerializedName("staticUrl")
    @Expose
    private String staticUrl;
    public final static Parcelable.Creator<Seatmap> CREATOR = new Creator<Seatmap>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Seatmap createFromParcel(Parcel in) {
            return new Seatmap(in);
        }

        public Seatmap[] newArray(int size) {
            return (new Seatmap[size]);
        }

    }
    ;

    protected Seatmap(Parcel in) {
        this.staticUrl = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Seatmap() {
    }

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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(staticUrl);
    }

    public int describeContents() {
        return  0;
    }

}
