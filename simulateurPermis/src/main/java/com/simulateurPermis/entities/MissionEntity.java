package com.simulateurPermis.entities;

import javax.persistence.*;

/**
 * Created by Sachouw on 25/04/2017.
 */
@Entity
@Table(name = "mission", schema = "permispiste", catalog = "")
public class MissionEntity {
    private String libmission;
    private JeuEntity jeuByNumjeu;

    @Basic
    @Column(name = "LIBMISSION")
    public String getLibmission() {
        return libmission;
    }

    public void setLibmission(String libmission) {
        this.libmission = libmission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MissionEntity that = (MissionEntity) o;

        if (libmission != null ? !libmission.equals(that.libmission) : that.libmission != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return libmission != null ? libmission.hashCode() : 0;
    }

    @ManyToOne
    @JoinColumn(name = "NUMJEU", referencedColumnName = "NUMJEU", nullable = false)
    public JeuEntity getJeuByNumjeu() {
        return jeuByNumjeu;
    }

    public void setJeuByNumjeu(JeuEntity jeuByNumjeu) {
        this.jeuByNumjeu = jeuByNumjeu;
    }
}
