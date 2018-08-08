
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

public class Embedded implements Parcelable
{

    @SerializedName("events")
    @Expose
    private List<Event> events = new ArrayList<Event>();
    public final static Parcelable.Creator<Embedded> CREATOR = new Creator<Embedded>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Embedded createFromParcel(Parcel in) {
            return new Embedded(in);
        }

        public Embedded[] newArray(int size) {
            return (new Embedded[size]);
        }

    }
    ;

    protected Embedded(Parcel in) {
        in.readList(this.events, (com.iblesa.api.models.Event.class.getClassLoader()));
    }

    public Embedded() {
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("events", events).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(events).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Embedded) == false) {
            return false;
        }
        Embedded rhs = ((Embedded) other);
        return new EqualsBuilder().append(events, rhs.events).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(events);
    }

    public int describeContents() {
        return  0;
    }

}
