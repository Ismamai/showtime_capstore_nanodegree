
package com.iblesa.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Links__ implements Parcelable
{

    @SerializedName("self")
    @Expose
    private Self__ self;
    public final static Parcelable.Creator<Links__> CREATOR = new Creator<Links__>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Links__ createFromParcel(Parcel in) {
            return new Links__(in);
        }

        public Links__[] newArray(int size) {
            return (new Links__[size]);
        }

    }
    ;

    protected Links__(Parcel in) {
        this.self = ((Self__) in.readValue((Self__.class.getClassLoader())));
    }

    public Links__() {
    }

    public Self__ getSelf() {
        return self;
    }

    public void setSelf(Self__ self) {
        this.self = self;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("self", self).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(self).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Links__) == false) {
            return false;
        }
        Links__ rhs = ((Links__) other);
        return new EqualsBuilder().append(self, rhs.self).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(self);
    }

    public int describeContents() {
        return  0;
    }

}
