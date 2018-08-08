
package com.iblesa.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Dma implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    public final static Parcelable.Creator<Dma> CREATOR = new Creator<Dma>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Dma createFromParcel(Parcel in) {
            return new Dma(in);
        }

        public Dma[] newArray(int size) {
            return (new Dma[size]);
        }

    }
    ;

    protected Dma(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Dma() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        if ((other instanceof Dma) == false) {
            return false;
        }
        Dma rhs = ((Dma) other);
        return new EqualsBuilder().append(id, rhs.id).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
    }

    public int describeContents() {
        return  0;
    }

}
