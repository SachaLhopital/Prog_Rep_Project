package com.epul.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * Created by Sachouw on 12/06/2017.
 */
@Entity
@Table(name = "calendrier", schema = "permispiste", catalog = "")
public class CalendrierEntity {
    private Date datejour;

    @Id
    @Column(name = "DATEJOUR")
    public Date getDatejour() {
        return datejour;
    }

    public void setDatejour(Date datejour) {
        this.datejour = datejour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CalendrierEntity that = (CalendrierEntity) o;

        if (datejour != null ? !datejour.equals(that.datejour) : that.datejour != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return datejour != null ? datejour.hashCode() : 0;
    }
}
