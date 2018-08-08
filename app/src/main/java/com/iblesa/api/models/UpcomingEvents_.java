
package com.iblesa.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class UpcomingEvents_ implements Parcelable
{

    @SerializedName("_total")
    @Expose
    private Integer total;
    @SerializedName("mfx-dk")
    @Expose
    private Integer mfxDk;
    @SerializedName("tmr")
    @Expose
    private Integer tmr;
    @SerializedName("mfx-nl")
    @Expose
    private Integer mfxNl;
    @SerializedName("mfx-de")
    @Expose
    private Integer mfxDe;
    @SerializedName("ticketmaster")
    @Expose
    private Integer ticketmaster;
    public final static Parcelable.Creator<UpcomingEvents_> CREATOR = new Creator<UpcomingEvents_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public UpcomingEvents_ createFromParcel(Parcel in) {
            return new UpcomingEvents_(in);
        }

        public UpcomingEvents_[] newArray(int size) {
            return (new UpcomingEvents_[size]);
        }

    }
    ;

    protected UpcomingEvents_(Parcel in) {
        this.total = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.mfxDk = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.tmr = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.mfxNl = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.mfxDe = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.ticketmaster = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public UpcomingEvents_() {
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getMfxDk() {
        return mfxDk;
    }

    public void setMfxDk(Integer mfxDk) {
        this.mfxDk = mfxDk;
    }

    public Integer getTmr() {
        return tmr;
    }

    public void setTmr(Integer tmr) {
        this.tmr = tmr;
    }

    public Integer getMfxNl() {
        return mfxNl;
    }

    public void setMfxNl(Integer mfxNl) {
        this.mfxNl = mfxNl;
    }

    public Integer getMfxDe() {
        return mfxDe;
    }

    public void setMfxDe(Integer mfxDe) {
        this.mfxDe = mfxDe;
    }

    public Integer getTicketmaster() {
        return ticketmaster;
    }

    public void setTicketmaster(Integer ticketmaster) {
        this.ticketmaster = ticketmaster;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("total", total).append("mfxDk", mfxDk).append("tmr", tmr).append("mfxNl", mfxNl).append("mfxDe", mfxDe).append("ticketmaster", ticketmaster).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(mfxDe).append(total).append(mfxDk).append(tmr).append(ticketmaster).append(mfxNl).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UpcomingEvents_) == false) {
            return false;
        }
        UpcomingEvents_ rhs = ((UpcomingEvents_) other);
        return new EqualsBuilder().append(mfxDe, rhs.mfxDe).append(total, rhs.total).append(mfxDk, rhs.mfxDk).append(tmr, rhs.tmr).append(ticketmaster, rhs.ticketmaster).append(mfxNl, rhs.mfxNl).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(total);
        dest.writeValue(mfxDk);
        dest.writeValue(tmr);
        dest.writeValue(mfxNl);
        dest.writeValue(mfxDe);
        dest.writeValue(ticketmaster);
    }

    public int describeContents() {
        return  0;
    }

}
