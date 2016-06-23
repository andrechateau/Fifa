/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.gcc110.s2016_01.trabalho1.desOrientados.models;

import br.ufla.dcc.gcc110.s2016_01.trabalho1.desOrientados.persistence.Repositorio;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Andre Chateaubriand
 */
public class Partida implements Serializable{

    private static int controladorId = Repositorio.getUltimoIDPartida();
    private final int ID;
    private Time[] times = new Time[2];
    private int qtdGols[] = new int[2];
    private boolean jogou; // indica se ja houve a partida, e o placar

    public Partida(Time timeCasa, Time timeVisitante) {
        this.ID = controladorId;
        controladorId++;
        setAll(timeCasa, timeVisitante);
    }

    public Partida(int ID, Time timeCasa, Time timeVisitante, int golsTimeCasa, int golsTimeVisitante) {
        this.ID = ID;
        setAll(timeCasa, timeVisitante, golsTimeCasa, golsTimeVisitante, true);
    }

    private void setAll(Time timeCasa, Time timeVisitante) {
        setAll(timeCasa, timeVisitante, 0, 0, false);

    }

    private void setAll(Time timeCasa, Time timeVisitante, int golsTimeCasa, int golsTimeVisitante, boolean jogou) {
        times[0] = timeCasa;
        times[1] = timeVisitante;
        qtdGols[0] = golsTimeCasa;
        qtdGols[1] = golsTimeVisitante;
    }

    public void realizarPartida() {
        /*TODO fazer o calculo do jogo*/
    }

    public int getID() {
        return this.ID;
    }
}
