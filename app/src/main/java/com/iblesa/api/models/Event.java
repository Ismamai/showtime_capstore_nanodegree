
package com.iblesa.api.models;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Event {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("test")
    @Expose
    private Boolean test;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("locale")
    @Expose
    private String locale;
    @SerializedName("images")
    @Expose
    private List<Image> images = new ArrayList<Image>();
    @SerializedName("sales")
    @Expose
    private Sales sales;
    @SerializedName("dates")
    @Expose
    private Dates dates;
    @SerializedName("classifications")
    @Expose
    private List<Classification> classifications = new ArrayList<Classification>();
    @SerializedName("promoter")
    @Expose
    private Promoter promoter;
    @SerializedName("promoters")
    @Expose
    private List<Promoter_> promoters = new ArrayList<Promoter_>();
    @SerializedName("pleaseNote")
    @Expose
    private String pleaseNote;
    @SerializedName("seatmap")
    @Expose
    private Seatmap seatmap;
    @SerializedName("ticketLimit")
    @Expose
    private TicketLimit ticketLimit;
    @SerializedName("_links")
    @Expose
    private Links links;
    @SerializedName("_embedded")
    @Expose
    private Embedded_ embedded;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getTest() {
        return test;
    }

    public void setTest(Boolean test) {
        this.test = test;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public List<Classification> getClassifications() {
        return classifications;
    }

    public void setClassifications(List<Classification> classifications) {
        this.classifications = classifications;
    }

    public Promoter getPromoter() {
        return promoter;
    }

    public void setPromoter(Promoter promoter) {
        this.promoter = promoter;
    }

    public List<Promoter_> getPromoters() {
        return promoters;
    }

    public void setPromoters(List<Promoter_> promoters) {
        this.promoters = promoters;
    }

    public String getPleaseNote() {
        return pleaseNote;
    }

    public void setPleaseNote(String pleaseNote) {
        this.pleaseNote = pleaseNote;
    }

    public Seatmap getSeatmap() {
        return seatmap;
    }

    public void setSeatmap(Seatmap seatmap) {
        this.seatmap = seatmap;
    }

    public TicketLimit getTicketLimit() {
        return ticketLimit;
    }

    public void setTicketLimit(TicketLimit ticketLimit) {
        this.ticketLimit = ticketLimit;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Embedded_ getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Embedded_ embedded) {
        this.embedded = embedded;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("type", type).append("id", id).append("test", test).append("url", url).append("locale", locale).append("images", images).append("sales", sales).append("dates", dates).append("classifications", classifications).append("promoter", promoter).append("promoters", promoters).append("pleaseNote", pleaseNote).append("seatmap", seatmap).append("ticketLimit", ticketLimit).append("links", links).append("embedded", embedded).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(images).append(test).append(seatmap).append(dates).append(type).append(locale).append(url).append(sales).append(classifications).append(ticketLimit).append(name).append(pleaseNote).append(promoter).append(links).append(id).append(promoters).append(embedded).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Event) == false) {
            return false;
        }
        Event rhs = ((Event) other);
        return new EqualsBuilder().append(images, rhs.images).append(test, rhs.test).append(seatmap, rhs.seatmap).append(dates, rhs.dates).append(type, rhs.type).append(locale, rhs.locale).append(url, rhs.url).append(sales, rhs.sales).append(classifications, rhs.classifications).append(ticketLimit, rhs.ticketLimit).append(name, rhs.name).append(pleaseNote, rhs.pleaseNote).append(promoter, rhs.promoter).append(links, rhs.links).append(id, rhs.id).append(promoters, rhs.promoters).append(embedded, rhs.embedded).isEquals();
    }

}
