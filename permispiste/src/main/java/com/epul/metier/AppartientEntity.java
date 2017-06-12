package com.epul.metier;

import javax.persistence.*;

/**
 * Created by lafay on 03/05/2017.
 */
@Entity
@Table(name = "appartient", schema = "permispiste", catalog = "")
@IdClass(AppartientEntityPK.class)
public class AppartientEntity {
    private int numjeu;
    private int numaction;
    private ActionEntity action;
    private JeuEntity jeu;

    @Id
    @Column(name = "NUMJEU")
    @GeneratedValue(strategy=GenerationType.AUTO)
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
    @JoinColumn(name = "NUMACTION", referencedColumnName = "NUMACTION", insertable = false, updatable = false)
    public ActionEntity getAction() {
        return action;
    }

    public void setAction(ActionEntity action) {
        this.action = action;
    }

    @ManyToOne
    @JoinColumn(name = "NUMJEU", referencedColumnName = "NUMJEU", insertable = false, updatable = false)
    public JeuEntity getJeu() {
        return jeu;
    }

    public void setJeu(JeuEntity jeu) {
        this.jeu = jeu;
    }
}
