package br.ufla.dcc.gcc110.s2016_01.trabalho1.desOrientados.models;

/**
 * 
 * @author letic
 */
public class Jogador {
    
    // Caracteristicas de um jogador
    private String nome;
    private int idade;
    private double preco;
    private String paisDeOrigem;
    private String posicao;
    
    // Habilidades de um jogador
    private int chute;
    private int passe;
    private int defender;
    private int velocidade;
    private int blefe;
    private int drible;
    
    public Jogador() {
        
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public String getPaisDeOrigem() {
        return this.paisDeOrigem;
    }
    
    public String getPosicao() {
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
