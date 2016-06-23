/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.gcc110.s2016_01.trabalho1.desOrientados.persistence;

import br.ufla.dcc.gcc110.s2016_01.trabalho1.desOrientados.models.Partida;
import br.ufla.dcc.gcc110.s2016_01.trabalho1.desOrientados.models.Time;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Andre Chateaubriand
 */
class Save implements Serializable{

    private ArrayList<Time> timeList = new ArrayList<>();
    private ArrayList<Partida> partidaList = new ArrayList<>();

    /**
     * @return the timeList
     */
    public ArrayList<Time> getTimeList() {
        return timeList;
    }

    /**
     * @param timeList the timeList to set
     */
    public void setTimeList(ArrayList<Time> timeList) {
        this.timeList = timeList;
    }

    /**
     * @return the partidaList
     */
    public ArrayList<Partida> getPartidaList() {
        return partidaList;
    }

    /**
     * @param partidaList the partidaList to set
     */
    public void setPartidaList(ArrayList<Partida> partidaList) {
        this.partidaList = partidaList;
    }
}
