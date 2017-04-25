package com.simulateurPermis.entities;

import javax.persistence.*;

/**
 * Created by Sachouw on 25/04/2017.
 */
@Entity
@Table(name = "action", schema = "permispiste")
public class ActionEntity {

    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(generator = "actionSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "actionSeq", sequenceName = "action_Id_seq")
    private int id;

    public int getId() {
        return id;
    }

    private String libaction;
    private Integer scoremin;
    private ActionEntity actionByActNumaction;

    @Basic
    @Column(name = "LIBACTION")
    public String getLibaction() {
        return libaction;
    }

    public void setLibaction(String libaction) {
        this.libaction = libaction;
    }

    @Basic
    @Column(name = "SCOREMIN")
    public Integer getScoremin() {
        return scoremin;
    }

    public void setScoremin(Integer scoremin) {
        this.scoremin = scoremin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActionEntity that = (ActionEntity) o;

        if(id != that.getId()) return false;
        if (libaction != null ? !libaction.equals(that.libaction) : that.libaction != null) return false;
        if (scoremin != null ? !scoremin.equals(that.scoremin) : that.scoremin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = libaction != null ? libaction.hashCode() : 0;
        result = 31 * result + (scoremin != null ? scoremin.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ACT_NUMACTION", referencedColumnName = "Id")
    public ActionEntity getActionByActNumaction() {
        return actionByActNumaction;
    }

    public void setActionByActNumaction(ActionEntity actionByActNumaction) {
        this.actionByActNumaction = actionByActNumaction;
    }
}
