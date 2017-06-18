package com.epul.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Sachouw on 13/06/2017.
 */
@Entity
@Table(name = "objectif", schema = "permispiste", catalog = "")
public class ObjectifEntity {
    private int numobjectif;
    private String libobjectif;

    @Id
    @Column(name = "NUMOBJECTIF")
    public int getNumobjectif() {
        return numobjectif;
    }

    public void setNumobjectif(int numobjectif) {
        this.numobjectif = numobjectif;
    }

    @Basic
    @Column(name = "LIBOBECTIF")
    public String getLibobjectif() {
        return libobjectif;
    }

    public void setLibobjectif(String libobectif) {
        this.libobjectif = libobectif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObjectifEntity that = (ObjectifEntity) o;

        if (numobjectif != that.numobjectif) return false;
        if (libobjectif != null ? !libobjectif.equals(that.libobjectif) : that.libobjectif != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numobjectif;
        result = 31 * result + (libobjectif != null ? libobjectif.hashCode() : 0);
        return result;
    }

    private List<EstAssocieEntity> estAssocie;

    @OneToMany
    @JoinColumn(name="NUMOBJECTIF", insertable = false, updatable = false)
    public List<EstAssocieEntity> getEstAssocie() {
        return estAssocie;
    }

    public void setEstAssocie(List<EstAssocieEntity> estAssocie) {
        this.estAssocie = estAssocie;
    }
}
