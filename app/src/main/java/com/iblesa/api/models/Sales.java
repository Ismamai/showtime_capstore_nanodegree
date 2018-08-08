
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

public class Sales implements Parcelable
{

    @SerializedName("public")
    @Expose
    private Public _public;
    @SerializedName("presales")
    @Expose
    private List<Presale> presales = new ArrayList<Presale>();
    public final static Parcelable.Creator<Sales> CREATOR = new Creator<Sales>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Sales createFromParcel(Parcel in) {
            return new Sales(in);
        }

        public Sales[] newArray(int size) {
            return (new Sales[size]);
        }

    }
    ;

    protected Sales(Parcel in) {
        this._public = ((Public) in.readValue((Public.class.getClassLoader())));
        in.readList(this.presales, (com.iblesa.api.models.Presale.class.getClassLoader()));
    }

    public Sales() {
    }

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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_public);
        dest.writeList(presales);
    }

    public int describeContents() {
        return  0;
    }

}
