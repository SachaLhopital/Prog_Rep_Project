package com.epul.entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Sachouw on 13/06/2017.
 */
@Entity
@Table(name = "obtient", schema = "permispiste", catalog = "")
@IdClass(ObtientEntityPK.class)
public class ObtientEntity {
    private int numapprenant;
    private Date datejour;
    private int numaction;
    private Integer valeurdebut;
    private Integer valeurfin;

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

    @Id
    @Column(name = "NUMACTION")
    public int getNumaction() {
        return numaction;
    }

    public void setNumaction(int numaction) {
        this.numaction = numaction;
    }

    @Basic
    @Column(name = "VALEURDEBUT")
    public Integer getValeurdebut() {
        return valeurdebut;
    }

    public void setValeurdebut(Integer valeurdebut) {
        this.valeurdebut = valeurdebut;
    }

    @Basic
    @Column(name = "VALEURFIN")
    public Integer getValeurfin() {
        return valeurfin;
    }

    public void setValeurfin(Integer valeurfin) {
        this.valeurfin = valeurfin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObtientEntity that = (ObtientEntity) o;

        if (numapprenant != that.numapprenant) return false;
        if (numaction != that.numaction) return false;
        if (datejour != null ? !datejour.equals(that.datejour) : that.datejour != null) return false;
        if (valeurdebut != null ? !valeurdebut.equals(that.valeurdebut) : that.valeurdebut != null) return false;
        if (valeurfin != null ? !valeurfin.equals(that.valeurfin) : that.valeurfin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numapprenant;
        result = 31 * result + (datejour != null ? datejour.hashCode() : 0);
        result = 31 * result + numaction;
        result = 31 * result + (valeurdebut != null ? valeurdebut.hashCode() : 0);
        result = 31 * result + (valeurfin != null ? valeurfin.hashCode() : 0);
        return result;
    }

    private ActionEntity action;

    @ManyToOne
    @JoinColumn(name = "NUMACTION", insertable=false, updatable=false)
    public ActionEntity getAction() {
        return action;
    }

    public void setAction(ActionEntity action) {
        this.action = action;
    }

    private ApprenantEntity apprenant;

    @ManyToOne
    @JoinColumn(name = "NUMAPPRENANT", insertable=false, updatable=false)
    public ApprenantEntity getApprenant() {
        return apprenant;
    }

    public void setApprenant(ApprenantEntity apprenant) {
        this.apprenant = apprenant;
    }
}
