package com.simulateurPermis.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Sachouw on 25/04/2017.
 */
@Entity
@Table(name = "est_associe", schema = "permispiste", catalog = "")
public class EstAssocieEntity {
    private ActionEntity actionByNumaction;

    @ManyToOne
    @JoinColumn(name = "NUMACTION", referencedColumnName = "Id", nullable = false)
    public ActionEntity getActionByNumaction() {
        return actionByNumaction;
    }

    public void setActionByNumaction(ActionEntity actionByNumaction) {
        this.actionByNumaction = actionByNumaction;
    }
}
