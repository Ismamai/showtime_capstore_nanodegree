
package com.iblesa.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class GeneralInfo {

    @SerializedName("generalRule")
    @Expose
    private String generalRule;
    @SerializedName("childRule")
    @Expose
    private String childRule;

    public String getGeneralRule() {
        return generalRule;
    }

    public void setGeneralRule(String generalRule) {
        this.generalRule = generalRule;
    }

    public String getChildRule() {
        return childRule;
    }

    public void setChildRule(String childRule) {
        this.childRule = childRule;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("generalRule", generalRule).append("childRule", childRule).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(generalRule).append(childRule).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GeneralInfo) == false) {
            return false;
        }
        GeneralInfo rhs = ((GeneralInfo) other);
        return new EqualsBuilder().append(generalRule, rhs.generalRule).append(childRule, rhs.childRule).isEquals();
    }

}
