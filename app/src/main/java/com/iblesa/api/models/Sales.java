
package com.iblesa.api.models;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Sales {

    @SerializedName("public")
    @Expose
    private Public _public;
    @SerializedName("presales")
    @Expose
    private List<Presale> presales = new ArrayList<Presale>();

    public Public getPublic() {
        return _public;
    }

    public void setPublic(Public _public) {
        this._public = _public;
    }

    public List<Presale> getPresales() {
        return presales;
    }

    public void setPresales(List<Presale> presales) {
        this.presales = presales;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("_public", _public).append("presales", presales).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(presales).append(_public).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Sales) == false) {
            return false;
        }
        Sales rhs = ((Sales) other);
        return new EqualsBuilder().append(presales, rhs.presales).append(_public, rhs._public).isEquals();
    }

}
