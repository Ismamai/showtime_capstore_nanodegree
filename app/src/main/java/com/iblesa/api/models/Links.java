
package com.iblesa.api.models;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Links implements Parcelable
{

    @SerializedName("self")
    @Expose
    private Self self;
    @SerializedName("attractions")
    @Expose
    private List<Attraction> attractions = new ArrayList<Attraction>();
    @SerializedName("venues")
    @Expose
    private List<Venue> venues = new ArrayList<Venue>();
    public final static Parcelable.Creator<Links> CREATOR = new Creator<Links>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Links createFromParcel(Parcel in) {
            return new Links(in);
        }

        public Links[] newArray(int size) {
            return (new Links[size]);
        }

    }
    ;

    protected Links(Parcel in) {
        this.self = ((Self) in.readValue((Self.class.getClassLoader())));
        in.readList(this.attractions, (com.iblesa.api.models.Attraction.class.getClassLoader()));
        in.readList(this.venues, (com.iblesa.api.models.Venue.class.getClassLoader()));
    }

    public Links() {
    }

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("self", self).append("attractions", attractions).append("venues", venues).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(self).append(venues).append(attractions).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Links) == false) {
            return false;
        }
        Links rhs = ((Links) other);
        return new EqualsBuilder().append(self, rhs.self).append(venues, rhs.venues).append(attractions, rhs.attractions).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(self);
        dest.writeList(attractions);
        dest.writeList(venues);
    }

    public int describeContents() {
        return  0;
    }

}
