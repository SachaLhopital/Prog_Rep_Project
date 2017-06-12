package com.epul.metier;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Sachouw on 12/06/2017.
 */
@Entity
@Table(name = "inscrit", schema = "permispiste", catalog = "")
@IdClass(InscritEntityPK.class)
public class InscritEntity {
    private int numjeu;
    private int numapprenant;
    private Date datejour;
    private ApprenantEntity apprenant;
    private JeuEntity jeu;

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
    @JoinColumn(name = "NUMAPPRENANT", referencedColumnName = "NUMAPPRENANT", insertable = false, updatable = false)
    public ApprenantEntity getApprenant() {
        return apprenant;
    }

    public void setApprenant(ApprenantEntity apprenant) {
        this.apprenant = apprenant;
    }

    @ManyToOne
    @JoinColumn(name = "NUMJEU", referencedColumnName = "NUMJEU", insertable = false, updatable = false)
    public JeuEntity getJeu() {
        return jeu;
    }

    public void setJeu(JeuEntity jeu) {
        this.jeu = jeu;
    }
}
