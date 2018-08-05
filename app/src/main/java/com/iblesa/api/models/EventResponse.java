
package com.iblesa.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EventResponse {

    @SerializedName("_embedded")
    @Expose
    private Embedded embedded;
    @SerializedName("_links")
    @Expose
    private Links___ links;
    @SerializedName("page")
    @Expose
    private Page page;

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

}
