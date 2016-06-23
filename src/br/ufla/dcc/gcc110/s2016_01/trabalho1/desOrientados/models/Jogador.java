package br.ufla.dcc.gcc110.s2016_01.trabalho1.desOrientados.models;

/**
 * Classe que representa um jogador que tem como características um ID(para
 * identificar cada jogador), nome, idade, preço, país de origem e posição no
 * time. Apresenta também um valor para suas habilidades(chute, passe, defender,
 * velocidade, blefe e drible). Possui métodos getters para tods os seus
 * atributos e não possui setter, pois uma vez criado, o jogador não tem suas
 * características nem suas habilidades alteradas.
 *
 * @authors Andre Chateubriand, Leticia Diniz e Marco Costa
 */
public class Jogador {

    // Variavel da classe qu irá gerenciar ID's dos jogadores
    private static int controladorID = Repositorio.getUltimoIDJogador();

    // Caracteristicas de um jogador
    private final int ID;
    private String nome;
    private int idade;
    private double preco;
    private String paisDeOrigem;
    private Posicao posicao;

    // Habilidades de um jogador
    private int chute;
    private int passe;
    private int defender;
    private int velocidade;
    private int blefe;
    private int drible;

    /**
     * Construtor que recebe todos os atributos de um jogador como parâmetro e
     * faz a chamada do método setAll(), recebe inclusive o ID
     *
     * @param ID ID é o número de indentificação de cada jogador
     * @param nome nome do jogador
     * @param idade idade do jogador
     * @param preco preço que o jogador terá dentro do jogo
     * @param paisDeOrigem país de origem do jogador
     * @param posicao posição que o jogador atua no time dentro de campo
     * @param chute valor que indica a capacidade do jogador de chute
     * @param passe valor que indica a capacidade do jogador de passe
     * @param defender valor que indica a capacidade do jogador de defesa
     * @param velocidade valor que indica a capacidade do jogador de velocidade
     * @param blefe valor que indica a capacidade do jogador de blefe
     * @param drible valor que indica a capacidade do jogador de drible
     */
    public Jogador(int ID, String nome, int idade, double preco, String paisDeOrigem, Posicao posicao, int chute, int passe, int defender, int velocidade, int blefe, int drible) {
        this.ID = ID;
        setAll(nome, idade, preco, paisDeOrigem, posicao, chute, passe, defender, velocidade, blefe, drible);
    }

    /**
     * Construtor que recebe todos os atributos de um jogador como parâmetro e
     * faz a chamada do método setAll(), recebe exceto o ID, este é tratado
     * dentro do próprio construtor
     *
     * @param ID ID é o número de indentificação de cada jogador
     * @param nome nome do jogador
     * @param idade idade do jogador
     * @param preco preço que o jogador terá dentro do jogo
     * @param paisDeOrigem país de origem do jogador
     * @param posicao posição que o jogador atua no time dentro de campo
     * @param chute valor que indica a capacidade do jogador de chute
     * @param passe valor que indica a capacidade do jogador de passe
     * @param defender valor que indica a capacidade do jogador de defesa
     * @param velocidade valor que indica a capacidade do jogador de velocidade
     * @param blefe valor que indica a capacidade do jogador de blefe
     * @param drible valor que indica a capacidade do jogador de drible
     */
    public Jogador(String nome, int idade, double preco, String paisDeOrigem, Posicao posicao, int chute, int passe, int defender, int velocidade, int blefe, int drible) {
        this.ID = controladorID;
        controladorID++;
        setAll(nome, idade, preco, paisDeOrigem, posicao, chute, passe, defender, velocidade, blefe, drible);
    }

    /**
     * Método que clona um objeto jogador.
     *
     * @return retorna um objeto Jogador com os mesmo valores do objeto que
     * chamou o método
     */
    @Override
    public Jogador clone() {
        return new Jogador(this.ID, this.nome, this.idade, this.preco, this.paisDeOrigem, this.posicao, this.chute, this.passe, this.defender, this.velocidade, this.blefe, this.drible);
    }

    /**
     * Método que verifica o valor atribuido a uma detrminada habilidade de um
     * jogador. Os valores permitidos estão entre 0 e 100, ou seja, se uma
     * habilidade foi passada com um valor superir a 100 ou inferior a 0, ela
     * simplesmente retorna o valor um dos seus extremos.
     *
     * @param habilidade pode ser passado qualquer habilidade de um jogador
     * (chute, passe, velocidade, etc)
     * @return retorna 0 caso tenha sido passado um valor inferior a 0, retorna
     * 100 se o valor é superior a 100 ou retorna o valor passado, e que está
     * dentro intervalo permitido
     */
    private int verificarHabilidade(int habilidade) {
        if (habilidade < 0) {
            return 0;
        } else if (habilidade > 100) {
            return 100;
        } else {
            return habilidade;
        }
    }

    /**
     * Método que auxilia o construtor na hora de inicializar um objeto, é o
     * método responsável por atribuir os valores de cada atributo da classe,
     * exceto o ID. Deste modo, recebe como parâmetro todos os parâmetros
     * recebidos pelo construtor, exceto ID, e chama o método
     * verificarHabilidade() para que os valores atribuídos em cada atributo
     * esteja correto.
     */
    private void setAll(String nome, int idade, double preco, String paisDeOrigem, Posicao posicao, int chute, int passe, int defender, int velocidade, int blefe, int drible) {
        this.nome = nome;
        this.idade = idade;
        this.preco = preco;
        this.paisDeOrigem = paisDeOrigem;
        this.posicao = posicao;
        this.chute = verificarHabilidade(chute);
        this.passe = verificarHabilidade(passe);
        this.defender = verificarHabilidade(defender);
        this.velocidade = verificarHabilidade(velocidade);
        this.blefe = verificarHabilidade(blefe);
        this.drible = verificarHabilidade(drible);
    }

    /**
     * Enumerador das posições dos jogadores dentro de campo.
     */
    public enum Posicao {
        GOLEIRO,
        ZAGUEIRO_DIREITO,
        ZAGUEIRO_ESQUERDO,
        ATACANTE_DIREITO,
        ATACANTE_ESQUERDO,
        MEIO_AVANCADO,
        MEIO_DEFENSIVA;
    }

    public int getID() {
        return this.ID;
    }

    public String getNome() {
        return this.nome;
    }

    public String getPaisDeOrigem() {
        return this.paisDeOrigem;
    }

    public Posicao getPosicao() {
        return this.posicao;
    }

    public int getIdade() {
        return this.idade;
    }

    public double getPreco() {
        return this.preco;
    }

    public int getChute() {
        return this.chute;
    }

    public int getPasse() {
        return this.passe;
    }

    public int getDefender() {
        return this.defender;
    }

    public int getVelocidade() {
        return this.velocidade;
    }

    public int getBlefe() {
        return this.blefe;
    }

    public int getDrible() {
        return this.drible;
    }

}
