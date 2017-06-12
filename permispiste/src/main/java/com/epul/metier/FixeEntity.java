package com.epul.metier;

import javax.persistence.*;

/**
 * Created by lafay on 03/05/2017.
 */
@Entity
@Table(name = "fixe", schema = "permispiste", catalog = "")
@IdClass(FixeEntityPK.class)
public class FixeEntity {
    private int nummission;
    private int numobjectif;
    private MissionEntity mission;
    private ObjectifEntity objectif;

    @Id
    @Column(name = "NUMMISSION")
    public int getNummission() {
        return nummission;
    }

    public void setNummission(int nummission) {
        this.nummission = nummission;
    }

    @Id
    @Column(name = "NUMOBJECTIF")
    public int getNumobjectif() {
        return numobjectif;
    }

    public void setNumobjectif(int numobjectif) {
        this.numobjectif = numobjectif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FixeEntity that = (FixeEntity) o;

        if (nummission != that.nummission) return false;
        if (numobjectif != that.numobjectif) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nummission;
        result = 31 * result + numobjectif;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "NUMMISSION", referencedColumnName = "NUMMISSION", insertable = false, updatable = false)
    public MissionEntity getMission() {
        return mission;
    }

    public void setMission(MissionEntity mission) {
        this.mission = mission;
    }

    @ManyToOne
    @JoinColumn(name = "NUMOBJECTIF", referencedColumnName = "NUMOBJECTIF", insertable = false, updatable = false)
    public ObjectifEntity getObjectif() {
        return objectif;
    }

    public void setObjectif(ObjectifEntity objectif) {
        this.objectif = objectif;
    }
}
