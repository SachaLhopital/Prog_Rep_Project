package com.epul.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Sachouw on 13/06/2017.
 */
public class InscritEntityPK implements Serializable {
    private int numjeu;
    private int numapprenant;
    private Date datejour;

    @Column(name = "NUMJEU")
    @Id
    public int getNumjeu() {
        return numjeu;
    }

    public void setNumjeu(int numjeu) {
        this.numjeu = numjeu;
    }

    @Column(name = "NUMAPPRENANT")
    @Id
    public int getNumapprenant() {
        return numapprenant;
    }

    public void setNumapprenant(int numapprenant) {
        this.numapprenant = numapprenant;
    }

    @Column(name = "DATEJOUR")
    @Id
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

        InscritEntityPK that = (InscritEntityPK) o;

        if (numjeu != that.numjeu) return false;
        if (numapprenant != that.numapprenant) return false;
        if (datejour != null ? !datejour.equals(that.datejour) : that.datejour != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numjeu;
        result = 31 * result + numapprenant;
        result = 31 * result + (datejour != null ? datejour.hashCode() : 0);
        return result;
    }
}
