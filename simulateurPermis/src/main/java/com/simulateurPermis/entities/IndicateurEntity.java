package com.simulateurPermis.entities;

import javax.persistence.*;

/**
 * Created by Sachouw on 25/04/2017.
 */
@Entity
@Table(name = "indicateur", schema = "permispiste", catalog = "")
public class IndicateurEntity {
    private String libindic;
    private Integer poids;
    private ActionEntity actionByNumaction;

    @Basic
    @Column(name = "LIBINDIC")
    public String getLibindic() {
        return libindic;
    }

    public void setLibindic(String libindic) {
        this.libindic = libindic;
    }

    @Basic
    @Column(name = "POIDS")
    public Integer getPoids() {
        return poids;
    }

    public void setPoids(Integer poids) {
        this.poids = poids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IndicateurEntity that = (IndicateurEntity) o;

        if (libindic != null ? !libindic.equals(that.libindic) : that.libindic != null) return false;
        if (poids != null ? !poids.equals(that.poids) : that.poids != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = libindic != null ? libindic.hashCode() : 0;
        result = 31 * result + (poids != null ? poids.hashCode() : 0);
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
