
package com.iblesa.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Start implements Parcelable
{

    @SerializedName("localDate")
    @Expose
    private String localDate;
    @SerializedName("localTime")
    @Expose
    private String localTime;
    @SerializedName("dateTime")
    @Expose
    private String dateTime;
    @SerializedName("dateTBD")
    @Expose
    private Boolean dateTBD;
    @SerializedName("dateTBA")
    @Expose
    private Boolean dateTBA;
    @SerializedName("timeTBA")
    @Expose
    private Boolean timeTBA;
    @SerializedName("noSpecificTime")
    @Expose
    private Boolean noSpecificTime;
    public final static Parcelable.Creator<Start> CREATOR = new Creator<Start>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Start createFromParcel(Parcel in) {
            return new Start(in);
        }

        public Start[] newArray(int size) {
            return (new Start[size]);
        }

    }
    ;

    protected Start(Parcel in) {
        this.localDate = ((String) in.readValue((String.class.getClassLoader())));
        this.localTime = ((String) in.readValue((String.class.getClassLoader())));
        this.dateTime = ((String) in.readValue((String.class.getClassLoader())));
        this.dateTBD = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.dateTBA = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.timeTBA = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.noSpecificTime = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public Start() {
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Boolean getDateTBD() {
        return dateTBD;
    }

    public void setDateTBD(Boolean dateTBD) {
        this.dateTBD = dateTBD;
    }

    public Boolean getDateTBA() {
        return dateTBA;
    }

    public void setDateTBA(Boolean dateTBA) {
        this.dateTBA = dateTBA;
    }

    public Boolean getTimeTBA() {
        return timeTBA;
    }

    public void setTimeTBA(Boolean timeTBA) {
        this.timeTBA = timeTBA;
    }

    public Boolean getNoSpecificTime() {
        return noSpecificTime;
    }

    public void setNoSpecificTime(Boolean noSpecificTime) {
        this.noSpecificTime = noSpecificTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("localDate", localDate).append("localTime", localTime).append("dateTime", dateTime).append("dateTBD", dateTBD).append("dateTBA", dateTBA).append("timeTBA", timeTBA).append("noSpecificTime", noSpecificTime).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(dateTime).append(localTime).append(dateTBA).append(noSpecificTime).append(timeTBA).append(localDate).append(dateTBD).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Start) == false) {
            return false;
        }
        Start rhs = ((Start) other);
        return new EqualsBuilder().append(dateTime, rhs.dateTime).append(localTime, rhs.localTime).append(dateTBA, rhs.dateTBA).append(noSpecificTime, rhs.noSpecificTime).append(timeTBA, rhs.timeTBA).append(localDate, rhs.localDate).append(dateTBD, rhs.dateTBD).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(localDate);
        dest.writeValue(localTime);
        dest.writeValue(dateTime);
        dest.writeValue(dateTBD);
        dest.writeValue(dateTBA);
        dest.writeValue(timeTBA);
        dest.writeValue(noSpecificTime);
    }

    public int describeContents() {
        return  0;
    }

}
