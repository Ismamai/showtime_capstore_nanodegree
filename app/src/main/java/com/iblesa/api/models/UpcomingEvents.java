
package com.iblesa.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class UpcomingEvents {

    @SerializedName("_total")
    @Expose
    private Integer total;
    @SerializedName("ticketmaster")
    @Expose
    private Integer ticketmaster;

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

}
