
package com.iblesa.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Classification implements Parcelable
{

    @SerializedName("primary")
    @Expose
    private Boolean primary;
    @SerializedName("segment")
    @Expose
    private Segment segment;
    @SerializedName("genre")
    @Expose
    private Genre genre;
    @SerializedName("subGenre")
    @Expose
    private SubGenre subGenre;
    @SerializedName("type")
    @Expose
    private Type type;
    @SerializedName("subType")
    @Expose
    private SubType subType;
    @SerializedName("family")
    @Expose
    private Boolean family;
    public final static Parcelable.Creator<Classification> CREATOR = new Creator<Classification>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Classification createFromParcel(Parcel in) {
            return new Classification(in);
        }

        public Classification[] newArray(int size) {
            return (new Classification[size]);
        }

    }
    ;

    protected Classification(Parcel in) {
        this.primary = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.segment = ((Segment) in.readValue((Segment.class.getClassLoader())));
        this.genre = ((Genre) in.readValue((Genre.class.getClassLoader())));
        this.subGenre = ((SubGenre) in.readValue((SubGenre.class.getClassLoader())));
        this.type = ((Type) in.readValue((Type.class.getClassLoader())));
        this.subType = ((SubType) in.readValue((SubType.class.getClassLoader())));
        this.family = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public Classification() {
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    public Segment getSegment() {
        return segment;
    }

    public void setSegment(Segment segment) {
        this.segment = segment;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public SubGenre getSubGenre() {
        return subGenre;
    }

    public void setSubGenre(SubGenre subGenre) {
        this.subGenre = subGenre;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public SubType getSubType() {
        return subType;
    }

    public void setSubType(SubType subType) {
        this.subType = subType;
    }

    public Boolean getFamily() {
        return family;
    }

    public void setFamily(Boolean family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("primary", primary).append("segment", segment).append("genre", genre).append("subGenre", subGenre).append("type", type).append("subType", subType).append("family", family).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(subGenre).append(segment).append(genre).append(subType).append(type).append(family).append(primary).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Classification) == false) {
            return false;
        }
        Classification rhs = ((Classification) other);
        return new EqualsBuilder().append(subGenre, rhs.subGenre).append(segment, rhs.segment).append(genre, rhs.genre).append(subType, rhs.subType).append(type, rhs.type).append(family, rhs.family).append(primary, rhs.primary).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(primary);
        dest.writeValue(segment);
        dest.writeValue(genre);
        dest.writeValue(subGenre);
        dest.writeValue(type);
        dest.writeValue(subType);
        dest.writeValue(family);
    }

    public int describeContents() {
        return  0;
    }

}
