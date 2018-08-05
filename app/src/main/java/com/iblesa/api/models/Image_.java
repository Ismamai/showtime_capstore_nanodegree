
package com.iblesa.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Image_ {

    @SerializedName("ratio")
    @Expose
    private String ratio;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("fallback")
    @Expose
    private Boolean fallback;

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Boolean getFallback() {
        return fallback;
    }

    public void setFallback(Boolean fallback) {
        this.fallback = fallback;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("ratio", ratio).append("url", url).append("width", width).append("height", height).append("fallback", fallback).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(width).append(fallback).append(url).append(ratio).append(height).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Image_) == false) {
            return false;
        }
        Image_ rhs = ((Image_) other);
        return new EqualsBuilder().append(width, rhs.width).append(fallback, rhs.fallback).append(url, rhs.url).append(ratio, rhs.ratio).append(height, rhs.height).isEquals();
    }

}
