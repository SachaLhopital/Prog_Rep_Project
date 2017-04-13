package com.simulateurPermis.metier;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Sachouw on 13/04/2017.
 */
@Entity(name = "action")
public class Action {

    @Id
    private int Id;

    @Basic
    private String Act_NumAction;

    @Basic
    private String LibAction;

    @Basic
    private String ScoreMin;

    public int getId() {
        return Id;
    }

    public String getAct_NumAction() {
        return Act_NumAction;
    }

    public String getLibAction() {
        return LibAction;
    }

    public String getScoreMin() {
        return ScoreMin;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setAct_NumAction(String act_NumAction) {
        Act_NumAction = act_NumAction;
    }

    public void setLibAction(String libAction) {
        LibAction = libAction;
    }

    public void setScoreMin(String scoreMin) {
        ScoreMin = scoreMin;
    }
}
