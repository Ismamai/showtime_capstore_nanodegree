
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

public class Attraction_ implements Parcelable
{

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
    @SerializedName("externalLinks")
    @Expose
    private ExternalLinks externalLinks;
    @SerializedName("images")
    @Expose
    private List<Image__> images = new ArrayList<Image__>();
    @SerializedName("classifications")
    @Expose
    private List<Classification_> classifications = new ArrayList<Classification_>();
    @SerializedName("upcomingEvents")
    @Expose
    private UpcomingEvents_ upcomingEvents;
    @SerializedName("_links")
    @Expose
    private Links__ links;
    public final static Parcelable.Creator<Attraction_> CREATOR = new Creator<Attraction_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Attraction_ createFromParcel(Parcel in) {
            return new Attraction_(in);
        }

        public Attraction_[] newArray(int size) {
            return (new Attraction_[size]);
        }

    }
    ;

    protected Attraction_(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.test = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.locale = ((String) in.readValue((String.class.getClassLoader())));
        this.externalLinks = ((ExternalLinks) in.readValue((ExternalLinks.class.getClassLoader())));
        in.readList(this.images, (com.iblesa.api.models.Image__.class.getClassLoader()));
        in.readList(this.classifications, (com.iblesa.api.models.Classification_.class.getClassLoader()));
        this.upcomingEvents = ((UpcomingEvents_) in.readValue((UpcomingEvents_.class.getClassLoader())));
        this.links = ((Links__) in.readValue((Links__.class.getClassLoader())));
    }

    public Attraction_() {
    }

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

    public ExternalLinks getExternalLinks() {
        return externalLinks;
    }

    public void setExternalLinks(ExternalLinks externalLinks) {
        this.externalLinks = externalLinks;
    }

    public List<Image__> getImages() {
        return images;
    }

    public void setImages(List<Image__> images) {
        this.images = images;
    }

    public List<Classification_> getClassifications() {
        return classifications;
    }

    public void setClassifications(List<Classification_> classifications) {
        this.classifications = classifications;
    }

    public UpcomingEvents_ getUpcomingEvents() {
        return upcomingEvents;
    }

    public void setUpcomingEvents(UpcomingEvents_ upcomingEvents) {
        this.upcomingEvents = upcomingEvents;
    }

    public Links__ getLinks() {
        return links;
    }

    public void setLinks(Links__ links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("type", type).append("id", id).append("test", test).append("url", url).append("locale", locale).append("externalLinks", externalLinks).append("images", images).append("classifications", classifications).append("upcomingEvents", upcomingEvents).append("links", links).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(classifications).append(images).append(test).append(upcomingEvents).append(name).append(externalLinks).append(links).append(id).append(type).append(locale).append(url).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Attraction_) == false) {
            return false;
        }
        Attraction_ rhs = ((Attraction_) other);
        return new EqualsBuilder().append(classifications, rhs.classifications).append(images, rhs.images).append(test, rhs.test).append(upcomingEvents, rhs.upcomingEvents).append(name, rhs.name).append(externalLinks, rhs.externalLinks).append(links, rhs.links).append(id, rhs.id).append(type, rhs.type).append(locale, rhs.locale).append(url, rhs.url).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(type);
        dest.writeValue(id);
        dest.writeValue(test);
        dest.writeValue(url);
        dest.writeValue(locale);
        dest.writeValue(externalLinks);
        dest.writeList(images);
        dest.writeList(classifications);
        dest.writeValue(upcomingEvents);
        dest.writeValue(links);
    }

    public int describeContents() {
        return  0;
    }

}
