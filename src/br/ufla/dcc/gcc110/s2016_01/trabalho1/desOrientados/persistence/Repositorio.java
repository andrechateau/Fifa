package br.ufla.dcc.gcc110.s2016_01.trabalho1.desOrientados.persistence;

import java.util.ArrayList;
import br.ufla.dcc.gcc110.s2016_01.trabalho1.desOrientados.models.*;

/**
 * Classe que controla os dados utilizados no sistema. Responsavel por preparar
 * os dados e fazer uma ponte entre o FileHandler e os objetos do sistema.
 *
 * @authors Andre Chateaubriand, Leticia Diniz e Marco Costa
 */
public class Repositorio {

    private static ArrayList<Time> timeList = new ArrayList<>();
    private static ArrayList<Partida> partidaList = new ArrayList<>();

    /**
     * Salva um Time no pre-save.
     *
     * @param time Time a ser salvo
     */
    public static void saveTime(Time time) {
        getTimeList().add(time);
    }

    /**
     * Salva uma Partida no pre-save.
     *
     * @param partida Partida a ser salva
     */
    public static void savePartida(Partida partida) {
        getPartidaList().add(partida);
    }

    /**
     * Salva os dados do pre-save num save definitivo.
     *
     */
    public static void save() {

    }

    /**
     * Reseta todo o save. Todos os dados são apagados. o sistema retorna sua
     * forma de fabrica
     *
     */
    public static void reset() {
        timeList.clear();
        partidaList.clear();
    }

    /**
     * Carrega um Time do arquivo de save
     *
     * @param ID ID do Time a ser carregado
     * @return Time com o ID requerido
     */
    public static Time loadTime(int ID) {
        for (Time time : getTimeList()) {
            if (time.getID() == ID) {
                return time;
            }
        }
        return null;
    }

    /**
     * Carrega um Jogador do arquivo de save
     *
     * @param ID ID do Jogador a ser carregado
     * @return Jogador com o ID requerido
     */
    public static Jogador loadJogador(int ID) {
        Jogador j;
        for (Time time : getTimeList()) {
            j = time.getJogador(ID);
            if (j != null) {
                return j;
            }
        }
        return null;
    }

    /**
     * Carrega uma Partida do arquivo de save
     *
     * @param ID ID da Partida a ser carregada
     * @return Partida com o ID requerido
     */
    public static Partida loadPartida(int ID) {
        for (Partida partida : getPartidaList()) {
            if (partida.getID() == ID) {
                return partida;
            }
        }
        return null;
    }

    /**
     * Busca o maior ID entre todos Jogadores salvos.
     *
     * @return O maior ID entre todos Jogadores salvos.
     */
    public static int getUltimoIDJogador() {
        int i = 0;
        for (Time time : getTimeList()) {

            if (time.getID() > i) {
                i = time.getID();
            }
        }
        return i;
    }

    /**
     * Busca o maior ID entre todos Times salvos.
     *
     * @return O maior ID entre todos Times salvos.
     */
    public static int getUltimoIDTime() {
        int i = 0;
        for (Time time : getTimeList()) {
            if (time.getID() > i) {
                i = time.getID();
            }
        }
        return i;
    }

    /**
     * Busca o maior ID entre todas Partidas salvas.
     *
     * @return O maior ID entre todas Partidas salvas.
     */
    public static int getUltimoIDPartida() {
        int i = 0;
        for (Partida pertida : getPartidaList()) {
            if (pertida.getID() > i) {
                i = pertida.getID();
            }
        }
        return i;
    }

    /**
     * @return uma lista com todos os Times
     */
    public static ArrayList<Time> getTimeList() {
        return timeList;
    }

    /**
     * @return uma lista com todas as Partidas
     */
    public static ArrayList<Partida> getPartidaList() {
        return partidaList;
    }
}
