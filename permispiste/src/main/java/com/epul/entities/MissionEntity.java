package com.epul.entities;

import javax.persistence.*;

/**
 * Created by Sachouw on 13/06/2017.
 */
@Entity
@Table(name = "mission", schema = "permispiste", catalog = "")
public class MissionEntity {
    private int nummission;
    private int numjeu;
    private String libmission;
    private JeuEntity game;

    @Id
    @Column(name = "NUMMISSION")
    public int getNummission() {
        return nummission;
    }

    public void setNummission(int nummission) {
        this.nummission = nummission;
    }

    @Basic
    @Column(name = "LIBMISSION")
    public String getLibmission() {
        return libmission;
    }

    public void setLibmission(String libmission) {
        this.libmission = libmission;
    }

    @Basic
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

        MissionEntity that = (MissionEntity) o;

        if (nummission != that.nummission) return false;
        if (libmission != null ? !libmission.equals(that.libmission) : that.libmission != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nummission;
        result = 31 * result + (libmission != null ? libmission.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "NUMJEU", insertable=false, updatable=false)
    public JeuEntity getGame() {
        return game;
    }

    public void setGame(JeuEntity game) {
        this.game = game;
    }
}
