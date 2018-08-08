
package com.iblesa.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Social implements Parcelable
{

    @SerializedName("twitter")
    @Expose
    private Twitter twitter;
    public final static Parcelable.Creator<Social> CREATOR = new Creator<Social>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Social createFromParcel(Parcel in) {
            return new Social(in);
        }

        public Social[] newArray(int size) {
            return (new Social[size]);
        }

    }
    ;

    protected Social(Parcel in) {
        this.twitter = ((Twitter) in.readValue((Twitter.class.getClassLoader())));
    }

    public Social() {
    }

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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(twitter);
    }

    public int describeContents() {
        return  0;
    }

}
