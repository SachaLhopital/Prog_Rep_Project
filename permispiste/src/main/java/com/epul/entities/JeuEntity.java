package com.epul.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Sachouw on 13/06/2017.
 */
@Entity
@Table(name = "jeu", schema = "permispiste", catalog = "")
public class JeuEntity {
    private int numjeu;
    private String libellejeu;

    @Id
    @Column(name = "NUMJEU")
    public int getNumjeu() {
        return numjeu;
    }

    public void setNumjeu(int numjeu) {
        this.numjeu = numjeu;
    }

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

        if (numjeu != jeuEntity.numjeu) return false;
        if (libellejeu != null ? !libellejeu.equals(jeuEntity.libellejeu) : jeuEntity.libellejeu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numjeu;
        result = 31 * result + (libellejeu != null ? libellejeu.hashCode() : 0);
        return result;
    }

    private List<MissionEntity> missions;

    @OneToMany
    @JoinColumn(name = "NUMJEU", insertable=false, updatable=false)
    public List<MissionEntity> getMissions() {
        return missions;
    }

    public void setMissions(List<MissionEntity> missions) {
        this.missions = missions;
    }
}
