
package com.iblesa.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Dates {

    @SerializedName("start")
    @Expose
    private Start start;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("spanMultipleDays")
    @Expose
    private Boolean spanMultipleDays;

    public Start getStart() {
        return start;
    }

    public void setStart(Start start) {
        this.start = start;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Boolean getSpanMultipleDays() {
        return spanMultipleDays;
    }

    public void setSpanMultipleDays(Boolean spanMultipleDays) {
        this.spanMultipleDays = spanMultipleDays;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("start", start).append("timezone", timezone).append("status", status).append("spanMultipleDays", spanMultipleDays).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(start).append(timezone).append(status).append(spanMultipleDays).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Dates) == false) {
            return false;
        }
        Dates rhs = ((Dates) other);
        return new EqualsBuilder().append(start, rhs.start).append(timezone, rhs.timezone).append(status, rhs.status).append(spanMultipleDays, rhs.spanMultipleDays).isEquals();
    }

}
