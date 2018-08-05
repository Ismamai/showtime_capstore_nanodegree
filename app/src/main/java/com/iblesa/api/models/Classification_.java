
package com.iblesa.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Classification_ {

    @SerializedName("primary")
    @Expose
    private Boolean primary;
    @SerializedName("segment")
    @Expose
    private Segment_ segment;
    @SerializedName("genre")
    @Expose
    private Genre_ genre;
    @SerializedName("subGenre")
    @Expose
    private SubGenre_ subGenre;
    @SerializedName("type")
    @Expose
    private Type_ type;
    @SerializedName("subType")
    @Expose
    private SubType_ subType;
    @SerializedName("family")
    @Expose
    private Boolean family;

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    public Segment_ getSegment() {
        return segment;
    }

    public void setSegment(Segment_ segment) {
        this.segment = segment;
    }

    public Genre_ getGenre() {
        return genre;
    }

    public void setGenre(Genre_ genre) {
        this.genre = genre;
    }

    public SubGenre_ getSubGenre() {
        return subGenre;
    }

    public void setSubGenre(SubGenre_ subGenre) {
        this.subGenre = subGenre;
    }

    public Type_ getType() {
        return type;
    }

    public void setType(Type_ type) {
        this.type = type;
    }

    public SubType_ getSubType() {
        return subType;
    }

    public void setSubType(SubType_ subType) {
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
        if ((other instanceof Classification_) == false) {
            return false;
        }
        Classification_ rhs = ((Classification_) other);
        return new EqualsBuilder().append(subGenre, rhs.subGenre).append(segment, rhs.segment).append(genre, rhs.genre).append(subType, rhs.subType).append(type, rhs.type).append(family, rhs.family).append(primary, rhs.primary).isEquals();
    }

}
