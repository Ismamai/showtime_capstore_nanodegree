
package com.iblesa.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class UpcomingEvents implements Parcelable
{

    @SerializedName("_total")
    @Expose
    private Integer total;
    @SerializedName("ticketmaster")
    @Expose
    private Integer ticketmaster;
    public final static Parcelable.Creator<UpcomingEvents> CREATOR = new Creator<UpcomingEvents>() {


        @SuppressWarnings({
            "unchecked"
        })
        public UpcomingEvents createFromParcel(Parcel in) {
            return new UpcomingEvents(in);
        }

        public UpcomingEvents[] newArray(int size) {
            return (new UpcomingEvents[size]);
        }

    }
    ;

    protected UpcomingEvents(Parcel in) {
        this.total = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.ticketmaster = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public UpcomingEvents() {
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTicketmaster() {
        return ticketmaster;
    }

    public void setTicketmaster(Integer ticketmaster) {
        this.ticketmaster = ticketmaster;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("total", total).append("ticketmaster", ticketmaster).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(total).append(ticketmaster).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UpcomingEvents) == false) {
            return false;
        }
        UpcomingEvents rhs = ((UpcomingEvents) other);
        return new EqualsBuilder().append(total, rhs.total).append(ticketmaster, rhs.ticketmaster).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(total);
        dest.writeValue(ticketmaster);
    }

    public int describeContents() {
        return  0;
    }

}
