package com.simulateurPermis.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Sachouw on 25/04/2017.
 */
public class PossedeEntityPK implements Serializable {
    private int numaction;
    private int numregle;

    @Column(name = "NUMACTION")
    @Id
    public int getNumaction() {
        return numaction;
    }

    public void setNumaction(int numaction) {
        this.numaction = numaction;
    }

    @Column(name = "NUMREGLE")
    @Id
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

        PossedeEntityPK that = (PossedeEntityPK) o;

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
}
