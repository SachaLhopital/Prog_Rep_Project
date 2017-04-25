package com.simulateurPermis.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Sachouw on 25/04/2017.
 */
@Entity
@Table(name = "apprenant", schema = "permispiste", catalog = "")
public class ApprenantEntity {
    private String nomapprenant;
    private String prenomapprenant;

    @Basic
    @Column(name = "NOMAPPRENANT")
    public String getNomapprenant() {
        return nomapprenant;
    }

    public void setNomapprenant(String nomapprenant) {
        this.nomapprenant = nomapprenant;
    }

    @Basic
    @Column(name = "PRENOMAPPRENANT")
    public String getPrenomapprenant() {
        return prenomapprenant;
    }

    public void setPrenomapprenant(String prenomapprenant) {
        this.prenomapprenant = prenomapprenant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApprenantEntity that = (ApprenantEntity) o;

        if (nomapprenant != null ? !nomapprenant.equals(that.nomapprenant) : that.nomapprenant != null) return false;
        if (prenomapprenant != null ? !prenomapprenant.equals(that.prenomapprenant) : that.prenomapprenant != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nomapprenant != null ? nomapprenant.hashCode() : 0;
        result = 31 * result + (prenomapprenant != null ? prenomapprenant.hashCode() : 0);
        return result;
    }
}
