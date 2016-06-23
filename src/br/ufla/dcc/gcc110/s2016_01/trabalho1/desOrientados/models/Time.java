package br.ufla.dcc.gcc110.s2016_01.trabalho1.desOrientados.models;

import java.util.ArrayList;

/**
 * Classe que represnta um time de futebol que armazena nome, sigla, numero
 * indeterminado de jogadores do tipo Jogador, quantidade de gols feitos,
 * uniforme para o time do tipo Uniforme. A clase possui metodos para selecionar
 * titulares, calcular media das habilidades dos Jogadores. Cada time possui um
 * Id unico que é gerado automaticamente.
 *
 * @authors Andre Chateaubriand, Leticia Diniz e Marco Costa
 */
public class Time {

    //Varivael da classe que irá gerenciar Id's do time;
    private static int controladorId = Repositorio.getUltimoIDTime();

    //Represntação unica do time Unico do time 
    private final int ID;
    private final String nome;
    private final String abreviacao;
    private ArrayList<Jogador> jogadores;
    private int qtdGolsMarcados;
    private int qtdVitorias;
    private int qtdDerrotas;
    private int qtdEmpates;

    /**
     * Construtor inicializa o time somente com nome e abreviação, a lista de
     * jogadores inicializa vazia, e todos os contadores de status inicializam
     * em zero. Esse contrutor é o recomendado para iniciar um time novo.
     *
     * @param nome nome completo do time
     * @param abreviacao abreviação do time em três letras caso a String passa
     * seja maior é considerado somente as três primeiras letras;
     *
     */
    public Time(String nome, String abreviacao) {

        this.ID = controladorId;
        controladorId++;

        this.nome = nome;
        this.abreviacao = abreviacao.substring(0, 2);
        this.jogadores = new ArrayList<>();
        this.qtdGolsMarcados = 0;
        this.qtdDerrotas = 0;
        this.qtdVitorias = 0;
        this.qtdEmpates = 0;
    }

    /**
     * Construtor inicializa o time com nome e abreviação, lsita de jogadores,
     * qtdGolsMarcados, qtdDerrotas ,qtdVitorias, qtdEmpates são recebidos como
     * parametro. Esse contrutor é o recomendado para iniciar um time com dados
     * já existentes.
     *
     * @param ID representação unica do time caso seja -1 quer dizer que é um
     * novo jogador então um novo ID é gerado caso contrario o id passado e
     * salvo
     * @param nome nome completo do time(
     * @param abreviacao abreviação do time em três letras caso a String passa
     * seja maior é considerado somente as três primeiras letras.
     * @param jogadores lista de jogadores do time.
     * @param qtdGolsMarcados quantidade de gols marcado pelo time em todas
     * partidas.
     * @param qtdDerrotas quantidade dederrotas do time em todas partidas.
     * @param qtdVitorias quantidade vitorias do time em todas partidas.
     * @param qtdEmpates quantidade empates do time em todas partidas.
     */
    public Time(int ID, String nome, String abreviacao, ArrayList jogadores, int qtdGolsMarcados, int qtdDerrotas, int qtdVitorias, int qtdEmpates) {
        this.ID = ID;
        this.nome = nome;
        this.abreviacao = abreviacao.substring(0, 2);
        this.jogadores = jogadores;
        this.qtdGolsMarcados = qtdGolsMarcados;
        this.qtdDerrotas = qtdDerrotas;
        this.qtdVitorias = qtdVitorias;
        this.qtdEmpates = qtdEmpates;
    }

    /**
     * Método que busca um jogador no time por um ID retorna um clone do jogador
     * ou nulo caso não encontrado.
     *
     * @param ID identificação única do Jogador buscado
     * @return clone do Jogador com o ID referente, ou null caso não exista.
     */
    public Jogador buscarJogador(int ID) {
        for (Jogador jogador : this.jogadores) {
            if (jogador.getID == ID) {
                return jogador.clone();
            }
        }
        return null;
    }

    /**
     * Método que adiciona um jogador recebido por parametro ao time.
     *
     * @param jogador jogador a ser adicionado ao Time
     * @return verdadeiro se adicionar false se houver erro.
     */
    public boolean addJogador(Jogador jogador) {
        return this.jogadores.add(jogador);
    }

    /**
     * Método que remove um jogador do time com ID corresponde ao passado por
     * parâmetro 
     *
     * @param ID
     * @return
     */
    public boolean removeJogador(int ID) {
        return this.jogadores.remove(this.jogadores.buscarJogador(ID));
    }

    /**
     *
     * @return
     */
    public double mediaChute() {
        if (jogadores.size() == 0) {
            return 0.0;
        }
        int soma = 0;
        for (Jogador jogador : jogadores) {
            soma = jogador.getChute();
        }
        return Double(soma / jogadores.lenght());
    }

    /**
     *
     * @return
     */
    public double mediaPasse() {
        if (jogadores.lenght() == 0) {
            return 0.0;
        }
        int soma = 0;
        for (Jogador jogador : jogadores) {
            soma = jogador.getPasse();
        }
        return Double(soma / jogadores.lenght());
    }

    /**
     *
     * @return
     */
    public double mediaVelocidade() {
        if (jogadores.lenght() == 0) {
            return 0.0;
        }
        int soma = 0;
        for (Jogador jogador : jogadores) {
            soma = jogador.getVelociade();
        }
        return Double(soma / jogadores.lenght());
    }

    /**
     *
     * @return
     */
    public double mediaBlefe() {
        if (jogadores.lenght() == 0) {
            return 0.0;
        }
        int soma = 0;
        for (Jogador jogador : jogadores) {
            soma = jogador.getBlefe();
        }
        return Double(soma / jogadores.lenght());
    }

    /**
     *
     * @return
     */
    public double mediaDrible() {
        if (jogadores.lenght() == 0) {
            return 0.0;
        }
        int soma = 0;
        for (Jogador jogador : jogadores) {
            soma = jogador.getDrible();
        }
        return Double(soma / jogadores.lenght());
    }
    /**
     * 
     * @param qtdGolsMarcados 
     */
    public void adicionarGols(int qtdGolsMarcados){
        this.qtdGolsMarcados += qtdGolsMarcados;
    }
    /**
     * 
     */
    public void adicionarVitoria(){
        this.qtdVitorias++;
    }
    /**
     * 
     */
    public void adicionarDerrota(){
        this.qtdDerrotas++;
    }
    /**
     * 
     */
    public void adicionarEmpate(){
        this.qtdEmpates++;
    }

    /**
     * @return the qtdGolsMarcados
     */
    public int getQtdGolsMarcados() {
        return qtdGolsMarcados;
    }

    /**
     * @return the qtdVitorias
     */
    public int getQtdVitorias() {
        return qtdVitorias;
    }

    /**
     * @return the qtdDerrotas
     */
    public int getQtdDerrotas() {
        return qtdDerrotas;
    }

    /**
     * @return the qtdEmpates
     */
    public int getQtdEmpates() {
        return qtdEmpates;
    }

    public int getID() {
        return this.ID;
    }
    

}
