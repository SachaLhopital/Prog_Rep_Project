package com.epul.metier;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by lafay on 03/05/2017.
 */
@Entity
@Table(name = "mission", schema = "permispiste", catalog = "")
public class MissionEntity {

    private int nummission;
    private int numjeu;
    private String libmission;
    public JeuEntity game;

    @Id
    @Column(name = "NUMMISSION")
    public int getNummission() {
        return nummission;
    }

    public void setNummission(int nummission) {
        this.nummission = nummission;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NUMJEU", referencedColumnName = "NUMJEU")
    public JeuEntity getGame() {
        return game;
    }

    public void setGame(JeuEntity game) {
        this.game = game;
    }

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

        if (nummission != that.nummission) return false;
        if (numjeu != that.numjeu) return false;
        if (libmission != null ? !libmission.equals(that.libmission) : that.libmission != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nummission;
        result = 31 * result + numjeu;
        result = 31 * result + (libmission != null ? libmission.hashCode() : 0);
        return result;
    }
}
