
package com.iblesa.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Links___ implements Parcelable
{

    @SerializedName("first")
    @Expose
    private First first;
    @SerializedName("self")
    @Expose
    private Self___ self;
    @SerializedName("next")
    @Expose
    private Next next;
    @SerializedName("last")
    @Expose
    private Last last;
    public final static Parcelable.Creator<Links___> CREATOR = new Creator<Links___>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Links___ createFromParcel(Parcel in) {
            return new Links___(in);
        }

        public Links___[] newArray(int size) {
            return (new Links___[size]);
        }

    }
    ;

    protected Links___(Parcel in) {
        this.first = ((First) in.readValue((First.class.getClassLoader())));
        this.self = ((Self___) in.readValue((Self___.class.getClassLoader())));
        this.next = ((Next) in.readValue((Next.class.getClassLoader())));
        this.last = ((Last) in.readValue((Last.class.getClassLoader())));
    }

    public Links___() {
    }

    public First getFirst() {
        return first;
    }

    public void setFirst(First first) {
        this.first = first;
    }

    public Self___ getSelf() {
        return self;
    }

    public void setSelf(Self___ self) {
        this.self = self;
    }

    public Next getNext() {
        return next;
    }

    public void setNext(Next next) {
        this.next = next;
    }

    public Last getLast() {
        return last;
    }

    public void setLast(Last last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("first", first).append("self", self).append("next", next).append("last", last).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(next).append(self).append(last).append(first).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Links___) == false) {
            return false;
        }
        Links___ rhs = ((Links___) other);
        return new EqualsBuilder().append(next, rhs.next).append(self, rhs.self).append(last, rhs.last).append(first, rhs.first).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(first);
        dest.writeValue(self);
        dest.writeValue(next);
        dest.writeValue(last);
    }

    public int describeContents() {
        return  0;
    }

}
