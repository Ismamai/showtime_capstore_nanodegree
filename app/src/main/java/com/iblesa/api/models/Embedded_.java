
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

public class Embedded_ implements Parcelable
{

    @SerializedName("venues")
    @Expose
    private List<Venue_> venues = new ArrayList<Venue_>();
    @SerializedName("attractions")
    @Expose
    private List<Attraction_> attractions = new ArrayList<Attraction_>();
    public final static Parcelable.Creator<Embedded_> CREATOR = new Creator<Embedded_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Embedded_ createFromParcel(Parcel in) {
            return new Embedded_(in);
        }

        public Embedded_[] newArray(int size) {
            return (new Embedded_[size]);
        }

    }
    ;

    protected Embedded_(Parcel in) {
        in.readList(this.venues, (com.iblesa.api.models.Venue_.class.getClassLoader()));
        in.readList(this.attractions, (com.iblesa.api.models.Attraction_.class.getClassLoader()));
    }

    public Embedded_() {
    }

    public List<Venue_> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue_> venues) {
        this.venues = venues;
    }

    public List<Attraction_> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction_> attractions) {
        this.attractions = attractions;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("venues", venues).append("attractions", attractions).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(venues).append(attractions).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Embedded_) == false) {
            return false;
        }
        Embedded_ rhs = ((Embedded_) other);
        return new EqualsBuilder().append(venues, rhs.venues).append(attractions, rhs.attractions).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(venues);
        dest.writeList(attractions);
    }

    public int describeContents() {
        return  0;
    }

}
