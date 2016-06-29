package classes;

import java.util.Calendar;

public class Filmes {

    private int id;
    private String nome;
    private String elenco;
    private String diretor;
    private String classificacao;
    private String sinopse;
    private String duracao;
    private String dataLancamento;
    private String generos;
    private PerfilFilme perfil;
    private String imagem;

    public Filmes(int id, String nome, String elenco, String diretor, String classificacao, String sinopse, String duracao, String dataLancamento, String generos) {
        this.nome = nome;
        this.elenco = elenco;
        this.diretor = diretor;
        this.classificacao = classificacao;
        this.sinopse = sinopse;
        this.duracao = duracao;
        this.dataLancamento = dataLancamento;
        this.generos = generos;
        this.perfil = perfil;
    }

    public Filmes() {
        this.id = 0;
        this.nome = null;
        this.elenco = null;
        this.diretor = null;
        this.classificacao = null;
        this.sinopse = null;
        this.duracao = null;
        this.dataLancamento = null;
        this.generos = null;
        this.perfil = new PerfilFilme();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getClassificacao() {
        return this.classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getGeneros() {
        return generos;
    }

    public void setGeneros(String generos) {
        this.generos = generos;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the dataLancamento
     */
    public String getDataLancamento() {
        return dataLancamento;
    }

    /**
     * @param dataLancamento the dataLancamento to set
     */
    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    /**
     * @return the perfil
     */
    public PerfilFilme getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(PerfilFilme perfil) {
        this.perfil = perfil;
    }

    /**
     * @return the imagem
     */
    public String getImagem() {
        return imagem;
    }

    /**
     * @param imagem the imagem to set
     */
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

}
