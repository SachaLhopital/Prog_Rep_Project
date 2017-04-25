package com.simulateurPermis.entities;

import javax.persistence.*;

/**
 * Created by Sachouw on 25/04/2017.
 */
@Entity
@Table(name = "possede", schema = "permispiste", catalog = "")
@IdClass(PossedeEntityPK.class)
public class PossedeEntity {
    private int numaction;
    private int numregle;
    private ActionEntity actionByNumaction;

    @Id
    @Column(name = "NUMACTION")
    public int getNumaction() {
        return numaction;
    }

    public void setNumaction(int numaction) {
        this.numaction = numaction;
    }

    @Id
    @Column(name = "NUMREGLE")
    public int getNumregle() {
        return numregle;
    }

    public void setNumregle(int numregle) {
        this.numregle = numregle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PossedeEntity that = (PossedeEntity) o;

        if (numaction != that.numaction) return false;
        if (numregle != that.numregle) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numaction;
        result = 31 * result + numregle;
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
