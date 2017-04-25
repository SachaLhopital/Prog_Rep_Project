package com.simulateurPermis.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Sachouw on 25/04/2017.
 */
@Entity
@Table(name = "regle", schema = "permispiste", catalog = "")
public class RegleEntity {
    private String libregle;
    private Integer scoremin;

    @Basic
    @Column(name = "LIBREGLE")
    public String getLibregle() {
        return libregle;
    }

    public void setLibregle(String libregle) {
        this.libregle = libregle;
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

        RegleEntity that = (RegleEntity) o;

        if (libregle != null ? !libregle.equals(that.libregle) : that.libregle != null) return false;
        if (scoremin != null ? !scoremin.equals(that.scoremin) : that.scoremin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = libregle != null ? libregle.hashCode() : 0;
        result = 31 * result + (scoremin != null ? scoremin.hashCode() : 0);
        return result;
    }
}
