package com.epul.metier;

import javax.persistence.*;

/**
 * Created by lafay on 03/05/2017.
 */
@Entity
@Table(name = "est_associe", schema = "permispiste", catalog = "")
@IdClass(EstAssocieEntityPK.class)
public class EstAssocieEntity {
    private int numaction;
    private int numobjectif;
    private ActionEntity action;
    private ObjectifEntity objectif;

    @Id
    @Column(name = "NUMACTION")
    public int getNumaction() {
        return numaction;
    }

    public void setNumaction(int numaction) {
        this.numaction = numaction;
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

        EstAssocieEntity that = (EstAssocieEntity) o;

        if (numaction != that.numaction) return false;
        if (numobjectif != that.numobjectif) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numaction;
        result = 31 * result + numobjectif;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "NUMACTION", referencedColumnName = "NUMACTION", insertable = false, updatable = false)
    public ActionEntity getAction() {
        return action;
    }

    public void setAction(ActionEntity action) {
        this.action = action;
    }

    @ManyToOne
    @JoinColumn(name = "NUMJEU", referencedColumnName = "NUMJEU", insertable = false, updatable = false)
    public ObjectifEntity getObjectif() {
        return objectif;
    }

    public void setObjectif(ObjectifEntity objectif) {
        this.objectif = objectif;
    }
}
