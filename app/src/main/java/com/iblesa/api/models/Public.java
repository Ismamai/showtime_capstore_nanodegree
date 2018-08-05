
package com.iblesa.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Public {

    @SerializedName("startDateTime")
    @Expose
    private String startDateTime;
    @SerializedName("startTBD")
    @Expose
    private Boolean startTBD;
    @SerializedName("endDateTime")
    @Expose
    private String endDateTime;

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Boolean getStartTBD() {
        return startTBD;
    }

    public void setStartTBD(Boolean startTBD) {
        this.startTBD = startTBD;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("startDateTime", startDateTime).append("startTBD", startTBD).append("endDateTime", endDateTime).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(startTBD).append(startDateTime).append(endDateTime).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Public) == false) {
            return false;
        }
        Public rhs = ((Public) other);
        return new EqualsBuilder().append(startTBD, rhs.startTBD).append(startDateTime, rhs.startDateTime).append(endDateTime, rhs.endDateTime).isEquals();
    }

}
