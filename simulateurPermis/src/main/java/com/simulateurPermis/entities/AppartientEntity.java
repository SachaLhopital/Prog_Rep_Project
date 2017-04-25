package com.simulateurPermis.entities;

import javax.persistence.*;

/**
 * Created by Sachouw on 25/04/2017.
 */
@Entity
@Table(name = "appartient", schema = "permispiste", catalog = "")
@IdClass(AppartientEntityPK.class)
public class AppartientEntity {
    private int numjeu;
    private int numaction;
    private ActionEntity actionByNumaction;

    @Id
    @Column(name = "NUMJEU")
    public int getNumjeu() {
        return numjeu;
    }

    public void setNumjeu(int numjeu) {
        this.numjeu = numjeu;
    }

    @Id
    @Column(name = "NUMACTION")
    public int getNumaction() {
        return numaction;
    }

    public void setNumaction(int numaction) {
        this.numaction = numaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppartientEntity that = (AppartientEntity) o;

        if (numjeu != that.numjeu) return false;
        if (numaction != that.numaction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numjeu;
        result = 31 * result + numaction;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "NUMACTION", referencedColumnName = "Id", nullable = false)
    public ActionEntity getActionByNumaction() {
        return actionByNumaction;
    }

    public void setActionByNumaction(ActionEntity actionByNumaction) {
        this.actionByNumaction = actionByNumaction;
    }
}
