
package com.iblesa.api.models;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Embedded_ {

    @SerializedName("venues")
    @Expose
    private List<Venue_> venues = new ArrayList<Venue_>();
    @SerializedName("attractions")
    @Expose
    private List<Attraction_> attractions = new ArrayList<Attraction_>();

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

}
