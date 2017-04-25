package com.simulateurPermis.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Sachouw on 25/04/2017.
 */
@Entity
@Table(name = "jeu", schema = "permispiste", catalog = "")
public class JeuEntity {
    private String libellejeu;

    @Basic
    @Column(name = "LIBELLEJEU")
    public String getLibellejeu() {
        return libellejeu;
    }

    public void setLibellejeu(String libellejeu) {
        this.libellejeu = libellejeu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JeuEntity jeuEntity = (JeuEntity) o;

        if (libellejeu != null ? !libellejeu.equals(jeuEntity.libellejeu) : jeuEntity.libellejeu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return libellejeu != null ? libellejeu.hashCode() : 0;
    }
}
