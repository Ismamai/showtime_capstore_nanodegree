
package com.iblesa.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Wiki implements Parcelable
{

    @SerializedName("url")
    @Expose
    private String url;
    public final static Parcelable.Creator<Wiki> CREATOR = new Creator<Wiki>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Wiki createFromParcel(Parcel in) {
            return new Wiki(in);
        }

        public Wiki[] newArray(int size) {
            return (new Wiki[size]);
        }

    }
    ;

    protected Wiki(Parcel in) {
        this.url = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Wiki() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("url", url).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(url).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Wiki) == false) {
            return false;
        }
        Wiki rhs = ((Wiki) other);
        return new EqualsBuilder().append(url, rhs.url).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url);
    }

    public int describeContents() {
        return  0;
    }

}
