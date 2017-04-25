package com.simulateurPermis.entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Sachouw on 25/04/2017.
 */
@Entity
@Table(name = "inscrit", schema = "permispiste", catalog = "")
@IdClass(InscritEntityPK.class)
public class InscritEntity {
    private int numjeu;
    private int numapprenant;
    private Date datejour;
    private ApprenantEntity apprenantByNumapprenant;
    private CalendrierEntity calendrierByDatejour;

    @Id
    @Column(name = "NUMJEU")
    public int getNumjeu() {
        return numjeu;
    }

    public void setNumjeu(int numjeu) {
        this.numjeu = numjeu;
    }

    @Id
    @Column(name = "NUMAPPRENANT")
    public int getNumapprenant() {
        return numapprenant;
    }

    public void setNumapprenant(int numapprenant) {
        this.numapprenant = numapprenant;
    }

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

        InscritEntity that = (InscritEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "NUMAPPRENANT", referencedColumnName = "NUMAPPRENANT", nullable = false)
    public ApprenantEntity getApprenantByNumapprenant() {
        return apprenantByNumapprenant;
    }

    public void setApprenantByNumapprenant(ApprenantEntity apprenantByNumapprenant) {
        this.apprenantByNumapprenant = apprenantByNumapprenant;
    }

    @ManyToOne
    @JoinColumn(name = "DATEJOUR", referencedColumnName = "DATEJOUR", nullable = false)
    public CalendrierEntity getCalendrierByDatejour() {
        return calendrierByDatejour;
    }

    public void setCalendrierByDatejour(CalendrierEntity calendrierByDatejour) {
        this.calendrierByDatejour = calendrierByDatejour;
    }
}
