
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

public class Venue_ implements Parcelable
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
    @SerializedName("images")
    @Expose
    private List<Image_> images = new ArrayList<Image_>();
    @SerializedName("postalCode")
    @Expose
    private String postalCode;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("country")
    @Expose
    private Country country;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("markets")
    @Expose
    private List<Market> markets = new ArrayList<Market>();
    @SerializedName("dmas")
    @Expose
    private List<Dma> dmas = new ArrayList<Dma>();
    @SerializedName("boxOfficeInfo")
    @Expose
    private BoxOfficeInfo boxOfficeInfo;
    @SerializedName("accessibleSeatingDetail")
    @Expose
    private String accessibleSeatingDetail;
    @SerializedName("generalInfo")
    @Expose
    private GeneralInfo generalInfo;
    @SerializedName("upcomingEvents")
    @Expose
    private UpcomingEvents upcomingEvents;
    @SerializedName("ada")
    @Expose
    private Ada ada;
    @SerializedName("_links")
    @Expose
    private Links_ links;
    @SerializedName("social")
    @Expose
    private Social social;
    @SerializedName("parkingDetail")
    @Expose
    private String parkingDetail;
    public final static Parcelable.Creator<Venue_> CREATOR = new Creator<Venue_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Venue_ createFromParcel(Parcel in) {
            return new Venue_(in);
        }

        public Venue_[] newArray(int size) {
            return (new Venue_[size]);
        }

    }
    ;

    protected Venue_(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.test = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.locale = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.images, (com.iblesa.api.models.Image_.class.getClassLoader()));
        this.postalCode = ((String) in.readValue((String.class.getClassLoader())));
        this.timezone = ((String) in.readValue((String.class.getClassLoader())));
        this.city = ((City) in.readValue((City.class.getClassLoader())));
        this.country = ((Country) in.readValue((Country.class.getClassLoader())));
        this.address = ((Address) in.readValue((Address.class.getClassLoader())));
        this.location = ((Location) in.readValue((Location.class.getClassLoader())));
        in.readList(this.markets, (com.iblesa.api.models.Market.class.getClassLoader()));
        in.readList(this.dmas, (com.iblesa.api.models.Dma.class.getClassLoader()));
        this.boxOfficeInfo = ((BoxOfficeInfo) in.readValue((BoxOfficeInfo.class.getClassLoader())));
        this.accessibleSeatingDetail = ((String) in.readValue((String.class.getClassLoader())));
        this.generalInfo = ((GeneralInfo) in.readValue((GeneralInfo.class.getClassLoader())));
        this.upcomingEvents = ((UpcomingEvents) in.readValue((UpcomingEvents.class.getClassLoader())));
        this.ada = ((Ada) in.readValue((Ada.class.getClassLoader())));
        this.links = ((Links_) in.readValue((Links_.class.getClassLoader())));
        this.social = ((Social) in.readValue((Social.class.getClassLoader())));
        this.parkingDetail = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Venue_() {
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

    public List<Image_> getImages() {
        return images;
    }

    public void setImages(List<Image_> images) {
        this.images = images;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Market> getMarkets() {
        return markets;
    }

    public void setMarkets(List<Market> markets) {
        this.markets = markets;
    }

    public List<Dma> getDmas() {
        return dmas;
    }

    public void setDmas(List<Dma> dmas) {
        this.dmas = dmas;
    }

    public BoxOfficeInfo getBoxOfficeInfo() {
        return boxOfficeInfo;
    }

    public void setBoxOfficeInfo(BoxOfficeInfo boxOfficeInfo) {
        this.boxOfficeInfo = boxOfficeInfo;
    }

    public String getAccessibleSeatingDetail() {
        return accessibleSeatingDetail;
    }

    public void setAccessibleSeatingDetail(String accessibleSeatingDetail) {
        this.accessibleSeatingDetail = accessibleSeatingDetail;
    }

    public GeneralInfo getGeneralInfo() {
        return generalInfo;
    }

    public void setGeneralInfo(GeneralInfo generalInfo) {
        this.generalInfo = generalInfo;
    }

    public UpcomingEvents getUpcomingEvents() {
        return upcomingEvents;
    }

    public void setUpcomingEvents(UpcomingEvents upcomingEvents) {
        this.upcomingEvents = upcomingEvents;
    }

    public Ada getAda() {
        return ada;
    }

    public void setAda(Ada ada) {
        this.ada = ada;
    }

    public Links_ getLinks() {
        return links;
    }

    public void setLinks(Links_ links) {
        this.links = links;
    }

    public Social getSocial() {
        return social;
    }

    public void setSocial(Social social) {
        this.social = social;
    }

    public String getParkingDetail() {
        return parkingDetail;
    }

    public void setParkingDetail(String parkingDetail) {
        this.parkingDetail = parkingDetail;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("type", type).append("id", id).append("test", test).append("url", url).append("locale", locale).append("images", images).append("postalCode", postalCode).append("timezone", timezone).append("city", city).append("country", country).append("address", address).append("location", location).append("markets", markets).append("dmas", dmas).append("boxOfficeInfo", boxOfficeInfo).append("accessibleSeatingDetail", accessibleSeatingDetail).append("generalInfo", generalInfo).append("upcomingEvents", upcomingEvents).append("ada", ada).append("links", links).append("social", social).append("parkingDetail", parkingDetail).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(country).append(images).append(address).append(test).append(city).append(social).append(timezone).append(upcomingEvents).append(postalCode).append(generalInfo).append(type).append(locale).append(boxOfficeInfo).append(url).append(markets).append(dmas).append(accessibleSeatingDetail).append(name).append(parkingDetail).append(location).append(links).append(id).append(ada).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Venue_) == false) {
            return false;
        }
        Venue_ rhs = ((Venue_) other);
        return new EqualsBuilder().append(country, rhs.country).append(images, rhs.images).append(address, rhs.address).append(test, rhs.test).append(city, rhs.city).append(social, rhs.social).append(timezone, rhs.timezone).append(upcomingEvents, rhs.upcomingEvents).append(postalCode, rhs.postalCode).append(generalInfo, rhs.generalInfo).append(type, rhs.type).append(locale, rhs.locale).append(boxOfficeInfo, rhs.boxOfficeInfo).append(url, rhs.url).append(markets, rhs.markets).append(dmas, rhs.dmas).append(accessibleSeatingDetail, rhs.accessibleSeatingDetail).append(name, rhs.name).append(parkingDetail, rhs.parkingDetail).append(location, rhs.location).append(links, rhs.links).append(id, rhs.id).append(ada, rhs.ada).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(type);
        dest.writeValue(id);
        dest.writeValue(test);
        dest.writeValue(url);
        dest.writeValue(locale);
        dest.writeList(images);
        dest.writeValue(postalCode);
        dest.writeValue(timezone);
        dest.writeValue(city);
        dest.writeValue(country);
        dest.writeValue(address);
        dest.writeValue(location);
        dest.writeList(markets);
        dest.writeList(dmas);
        dest.writeValue(boxOfficeInfo);
        dest.writeValue(accessibleSeatingDetail);
        dest.writeValue(generalInfo);
        dest.writeValue(upcomingEvents);
        dest.writeValue(ada);
        dest.writeValue(links);
        dest.writeValue(social);
        dest.writeValue(parkingDetail);
    }

    public int describeContents() {
        return  0;
    }

}
