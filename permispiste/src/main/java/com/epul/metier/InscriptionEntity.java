package com.epul.metier;

import javax.persistence.*;

/**
 * Created by lafay on 03/05/2017.
 */
@Entity
@Table(name = "inscription", schema = "permispiste", catalog = "")
@IdClass(InscriptionEntityPK.class)
public class InscriptionEntity {
    private int numapprenant;
    private int numjeu;
    private ApprenantEntity apprenant;
    private JeuEntity jeu;

    @Id
    @Column(name = "NUMAPPRENANT")
    public int getNumapprenant() {
        return numapprenant;
    }

    public void setNumapprenant(int numapprenant) {
        this.numapprenant = numapprenant;
    }

    @Id
    @Column(name = "NUMJEU")
    public int getNumjeu() {
        return numjeu;
    }

    public void setNumjeu(int numjeu) {
        this.numjeu = numjeu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InscriptionEntity that = (InscriptionEntity) o;

        if (numapprenant != that.numapprenant) return false;
        if (numjeu != that.numjeu) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numapprenant;
        result = 31 * result + numjeu;
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
