
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

public class ExternalLinks implements Parcelable
{

    @SerializedName("youtube")
    @Expose
    private List<Youtube> youtube = new ArrayList<Youtube>();
    @SerializedName("twitter")
    @Expose
    private List<Twitter_> twitter = new ArrayList<Twitter_>();
    @SerializedName("lastfm")
    @Expose
    private List<Lastfm> lastfm = new ArrayList<Lastfm>();
    @SerializedName("facebook")
    @Expose
    private List<Facebook> facebook = new ArrayList<Facebook>();
    @SerializedName("wiki")
    @Expose
    private List<Wiki> wiki = new ArrayList<Wiki>();
    @SerializedName("musicbrainz")
    @Expose
    private List<Musicbrainz> musicbrainz = new ArrayList<Musicbrainz>();
    @SerializedName("homepage")
    @Expose
    private List<Homepage> homepage = new ArrayList<Homepage>();
    public final static Parcelable.Creator<ExternalLinks> CREATOR = new Creator<ExternalLinks>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ExternalLinks createFromParcel(Parcel in) {
            return new ExternalLinks(in);
        }

        public ExternalLinks[] newArray(int size) {
            return (new ExternalLinks[size]);
        }

    }
    ;

    protected ExternalLinks(Parcel in) {
        in.readList(this.youtube, (com.iblesa.api.models.Youtube.class.getClassLoader()));
        in.readList(this.twitter, (com.iblesa.api.models.Twitter_.class.getClassLoader()));
        in.readList(this.lastfm, (com.iblesa.api.models.Lastfm.class.getClassLoader()));
        in.readList(this.facebook, (com.iblesa.api.models.Facebook.class.getClassLoader()));
        in.readList(this.wiki, (com.iblesa.api.models.Wiki.class.getClassLoader()));
        in.readList(this.musicbrainz, (com.iblesa.api.models.Musicbrainz.class.getClassLoader()));
        in.readList(this.homepage, (com.iblesa.api.models.Homepage.class.getClassLoader()));
    }

    public ExternalLinks() {
    }

    public List<Youtube> getYoutube() {
        return youtube;
    }

    public void setYoutube(List<Youtube> youtube) {
        this.youtube = youtube;
    }

    public List<Twitter_> getTwitter() {
        return twitter;
    }

    public void setTwitter(List<Twitter_> twitter) {
        this.twitter = twitter;
    }

    public List<Lastfm> getLastfm() {
        return lastfm;
    }

    public void setLastfm(List<Lastfm> lastfm) {
        this.lastfm = lastfm;
    }

    public List<Facebook> getFacebook() {
        return facebook;
    }

    public void setFacebook(List<Facebook> facebook) {
        this.facebook = facebook;
    }

    public List<Wiki> getWiki() {
        return wiki;
    }

    public void setWiki(List<Wiki> wiki) {
        this.wiki = wiki;
    }

    public List<Musicbrainz> getMusicbrainz() {
        return musicbrainz;
    }

    public void setMusicbrainz(List<Musicbrainz> musicbrainz) {
        this.musicbrainz = musicbrainz;
    }

    public List<Homepage> getHomepage() {
        return homepage;
    }

    public void setHomepage(List<Homepage> homepage) {
        this.homepage = homepage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("youtube", youtube).append("twitter", twitter).append("lastfm", lastfm).append("facebook", facebook).append("wiki", wiki).append("musicbrainz", musicbrainz).append("homepage", homepage).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(youtube).append(twitter).append(lastfm).append(facebook).append(wiki).append(musicbrainz).append(homepage).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ExternalLinks) == false) {
            return false;
        }
        ExternalLinks rhs = ((ExternalLinks) other);
        return new EqualsBuilder().append(youtube, rhs.youtube).append(twitter, rhs.twitter).append(lastfm, rhs.lastfm).append(facebook, rhs.facebook).append(wiki, rhs.wiki).append(musicbrainz, rhs.musicbrainz).append(homepage, rhs.homepage).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(youtube);
        dest.writeList(twitter);
        dest.writeList(lastfm);
        dest.writeList(facebook);
        dest.writeList(wiki);
        dest.writeList(musicbrainz);
        dest.writeList(homepage);
    }

    public int describeContents() {
        return  0;
    }

}
