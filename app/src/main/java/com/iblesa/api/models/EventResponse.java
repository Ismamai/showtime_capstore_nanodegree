
package com.iblesa.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EventResponse implements Parcelable
{

    @SerializedName("_embedded")
    @Expose
    private Embedded embedded;
    @SerializedName("_links")
    @Expose
    private Links___ links;
    @SerializedName("page")
    @Expose
    private Page page;
    public final static Parcelable.Creator<EventResponse> CREATOR = new Creator<EventResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public EventResponse createFromParcel(Parcel in) {
            return new EventResponse(in);
        }

        public EventResponse[] newArray(int size) {
            return (new EventResponse[size]);
        }

    }
    ;

    protected EventResponse(Parcel in) {
        this.embedded = ((Embedded) in.readValue((Embedded.class.getClassLoader())));
        this.links = ((Links___) in.readValue((Links___.class.getClassLoader())));
        this.page = ((Page) in.readValue((Page.class.getClassLoader())));
    }

    public EventResponse() {
    }

    public Embedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Embedded embedded) {
        this.embedded = embedded;
    }

    public Links___ getLinks() {
        return links;
    }

    public void setLinks(Links___ links) {
        this.links = links;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("embedded", embedded).append("links", links).append("page", page).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(links).append(page).append(embedded).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EventResponse) == false) {
            return false;
        }
        EventResponse rhs = ((EventResponse) other);
        return new EqualsBuilder().append(links, rhs.links).append(page, rhs.page).append(embedded, rhs.embedded).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(embedded);
        dest.writeValue(links);
        dest.writeValue(page);
    }

    public int describeContents() {
        return  0;
    }

}
