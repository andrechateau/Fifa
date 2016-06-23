package br.ufla.dcc.gcc110.s2016_01.trabalho1.desOrientados.models;

import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @authors Andre Chateubriand, Leticia Diniz e Marco Costa
 */
public class Uniforme implements Serializable{
    
    private Color corCamisa;
    private Color corCalcao;
    private Color corCamisaGoleiro;
    private Color corCalcaoGoleiro;

    public Uniforme(Color corCamisa, Color corCalcao, Color corCamisaGoleiro, Color corCalcaoGoleiro) {
        this.corCamisa = corCamisa;
        this.corCalcao = corCalcao;
        this.corCamisaGoleiro = corCamisaGoleiro;
        this.corCalcaoGoleiro = corCalcaoGoleiro;
    }
    
    /**
     * @return the corCamisa
     */
    public Color getCorCamisa() {
        return corCamisa;
    }

    /**
     * @return the corCalcao
     */
    public Color getCorCalcao() {
        return corCalcao;
    }

    /**
     * @return the corCamisaGoleiro
     */
    public Color getCorCamisaGoleiro() {
        return corCamisaGoleiro;
    }

    /**
     * @return the corCalcaoGoleiro
     */
    public Color getCorCalcaoGoleiro() {
        return corCalcaoGoleiro;
    }
    
    
    
}
