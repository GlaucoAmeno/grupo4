/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecomendacaoFilmes;

import classes.Cinema;
import classes.Cliente;
import classes.Filmes;
import classes.Ingresso;
import classes.PerfilFilme;
import classes.PerfilCliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class ConectaBanco {

    protected static Connection conectaBanco() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/abc", "postgres", "postgres");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public static List<Filmes> listAll() throws ClassNotFoundException, SQLException {
        Connection c = ConectaBanco.conectaBanco();
        PreparedStatement p = c.prepareStatement("select * from Filme");
        ResultSet r = p.executeQuery();
        List<Filmes> lista_de_filmes = new ArrayList<>();
        while (r.next()) {
            Filmes fm = new Filmes();
            fm.setId(r.getInt("id_Filme"));
            fm.setNome(r.getString("Nome"));
            fm.setElenco(r.getString("Elenco"));
            fm.setClassificacao(r.getString("Classificacao"));
            fm.setDiretor(r.getString("Diretor"));
            fm.setDataLancamento(r.getString("DataLancamento"));
            fm.setGeneros(r.getString("Genero"));
            fm.setSinopse(r.getString("Sinopse"));
            fm.setDuracao(String.valueOf(r.getString("Duracao")));
            fm.setImagem(r.getString("imagem"));
            fm.setPerfil(ConectaBanco.getPerfil(fm.getId()));
            lista_de_filmes.add(fm);
        }
        return lista_de_filmes;
    }

    public static PerfilFilme getPerfil(int id_filmes) throws SQLException, ClassNotFoundException {
        Connection c = ConectaBanco.conectaBanco();
        PreparedStatement p = c.prepareStatement("select * from Perfil where id_filme = ?;");
        p.setInt(1, id_filmes);
        ResultSet r = p.executeQuery();
        PerfilFilme perfil = new PerfilFilme();
        while (r.next()) {
            perfil.setAcao(r.getInt("Acao"));
            perfil.setAnimacao(r.getInt("Animacao"));
            perfil.setComedia(r.getInt("Comedia"));
            perfil.setDocumentario(r.getInt("Documentario"));
            perfil.setDrama(r.getInt("Drama"));
            perfil.setRomance(r.getInt("Romance"));
            perfil.setTerror(r.getInt("Terror"));
        }
        return perfil;
    }

    public static Cliente getUser(String nome) throws SQLException, ClassNotFoundException {
        Connection c = ConectaBanco.conectaBanco();
        PreparedStatement p = c.prepareStatement("select * from Cliente where NOme like ? ;");
        p.setString(1, nome);
        ResultSet r = p.executeQuery();
        Cliente cli = new Cliente();
        while (r.next()) {
            cli.setId_cliente(r.getInt("id_cliente"));
            cli.setNome(r.getString("Nome"));
            cli.setSenha(r.getString("Senha"));
            cli.setEmail(r.getString("Email"));
            cli.setPerfil(ConectaBanco.getPerfilCli(cli.getId_cliente()));
        }
        return cli;
    }

    public static PerfilCliente getPerfilCli(int id_Cliente) throws SQLException, ClassNotFoundException {
        Connection c = ConectaBanco.conectaBanco();
        PreparedStatement p = c.prepareStatement("select * from Perfil_cliente where id_cliente = ?;");
        p.setInt(1, id_Cliente);
        ResultSet r = p.executeQuery();
        PerfilCliente perfil = new PerfilCliente();
        while (r.next()) {
            perfil.setAcao(r.getInt("Acao"));
            perfil.setAnimação(r.getInt("Animacao"));
            perfil.setComedia(r.getInt("Comedia"));
            perfil.setDocumentario(r.getInt("Documentario"));
            perfil.setDrama(r.getInt("Drama"));
            perfil.setRomance(r.getInt("Romance"));
            perfil.setTerror(r.getInt("Terror"));
        }
        return perfil;
    }

    public static void createFilmes(Filmes fm) throws ClassNotFoundException, SQLException {
        try {

            Connection c = ConectaBanco.conectaBanco();
            PreparedStatement p = c.prepareStatement("insert into filme (nome, diretor, elenco, classificacao, sinopse, duracao, datalancamento, genero ,imagem) values (?,?,?,?,?,?,?,?,?)");
            p.setString(1, fm.getNome());
            p.setString(2, fm.getDiretor());
            p.setString(3, fm.getElenco());
            p.setInt(4, 0);
            p.setString(5, fm.getSinopse());
            p.setInt(6, 0);
            p.setString(7, fm.getDataLancamento());
            p.setString(8, fm.getGeneros());
            p.setString(9, fm.getImagem());
            p.execute();
        } catch (Exception e) {
            System.out.println("erroR: " + e);
        }
    }

    public static void deleteFilme(int idFilme) {

        try {
            Connection c = ConectaBanco.conectaBanco();
            PreparedStatement pf = c.prepareStatement("delete from perfil where id_filme = ?");
            pf.setInt(1, idFilme);
            pf.execute();
            PreparedStatement p = c.prepareStatement("delete from filme where id_filme = ?");
            p.setInt(1, idFilme);
            p.execute();
        } catch (Exception e) {
            System.out.println("erroR: " + e);
        }
    }

    public static void updateFilme(Filmes fm) throws ClassNotFoundException, SQLException {

        try {
            Connection c = ConectaBanco.conectaBanco();
            PreparedStatement p = c.prepareStatement("update filme set diretor = ?,"
                    + "                              elenco = ?, classificacao = ?, sinopse = ?, duracao = ?,"
                    + "                              datalancamento = ?, genero = ?, imagem = ? where id_filme = ?");

            p.setString(1, fm.getDiretor());
            p.setString(2, fm.getElenco());
            p.setInt(3, Integer.parseInt(fm.getClassificacao()));
            p.setString(4, fm.getSinopse());
            p.setInt(5, Integer.parseInt(fm.getDuracao()));
            p.setString(6, fm.getDataLancamento());
            p.setString(7, fm.getGeneros());
            p.setString(8, fm.getImagem());
            p.setInt(9, fm.getId());
            p.executeUpdate();
            System.out.println("passou");
        } catch (Exception e) {
            System.out.println("erroR: " + e);
        }
    }

    public static Filmes selectFilme(String nomeFilme) throws ClassNotFoundException, SQLException {

        Connection c = ConectaBanco.conectaBanco();
        PreparedStatement p = c.prepareStatement("SELECT * FROM filme where nome like ?");
        p.setString(1, nomeFilme);
        ResultSet rs = p.executeQuery();
        Filmes fm = new Filmes();

        while (rs.next()) {
            fm.setId(Integer.parseInt(rs.getString("id_filme")));
            fm.setNome(rs.getString("nome"));
            fm.setDiretor(rs.getString("diretor"));
            fm.setElenco(rs.getString("elenco"));
            fm.setClassificacao(rs.getString("Classificacao"));
            fm.setSinopse(rs.getString("sinopse"));
            fm.setDuracao(rs.getString("duracao"));
            fm.setDataLancamento(rs.getString("datalancamento"));
            fm.setGeneros(rs.getString("genero"));
            fm.setImagem(rs.getString("imagem"));
            fm.setPerfil(ConectaBanco.getPerfil(fm.getId()));
        }

        return fm;
    }

    public static ArrayList<Filmes> selectAllFilmes() throws ClassNotFoundException, SQLException {

        Connection c = ConectaBanco.conectaBanco();
        PreparedStatement p = c.prepareStatement("SELECT * FROM filme");
        ResultSet rs = p.executeQuery();
        ArrayList<Filmes> filmes = new ArrayList<Filmes>();
        while (rs.next()) {
            Filmes fm = new Filmes();
            fm.setId(Integer.parseInt(rs.getString("id_filme")));
            fm.setNome(rs.getString("nome"));
            fm.setDiretor(rs.getString("diretor"));
            fm.setElenco(rs.getString("elenco"));
            fm.setClassificacao(rs.getString("Classificacao"));
            fm.setSinopse(rs.getString("sinopse"));
            fm.setDuracao(rs.getString("duracao"));
            fm.setDataLancamento(rs.getString("datalancamento"));
            fm.setGeneros(rs.getString("genero"));
            fm.setImagem(rs.getString("imagem"));
            filmes.add(fm);
        }
        return filmes;
    }

    public static void createUsuario(Cliente cli) throws ClassNotFoundException, SQLException {
        try {
            Connection c = ConectaBanco.conectaBanco();
            PreparedStatement p = c.prepareStatement("insert into Cliente (nome, senha, email) values (?,?,?)");
            p.setString(1, cli.getNome());
            p.setString(2, cli.getSenha());
            p.setString(3, cli.getEmail());
            p.execute();
        } catch (Exception e) {
            System.out.println("erroR: " + e);
        }
    }

    public static void createIngresso(Ingresso in) throws ClassNotFoundException, SQLException {
        try {
            Connection c = ConectaBanco.conectaBanco();
            PreparedStatement p = c.prepareStatement("insert into ingresso (id_filme, data_filme, valor, sala, poltrona, horario) values (?,?,?,?,?,?)");
            p.setInt(1, in.getIdFilme());
            p.setString(2, in.getDataFilme());
            p.setDouble(3, in.getValor());
            p.setInt(4, in.getSala());
            p.setString(5, in.getPoltrona());
            p.setString(6, in.getHorario());
            p.executeUpdate();
        } catch (Exception e) {
            System.out.println("erroR: " + e);
        }
    }

    public static boolean verifyLogin(Cliente cli) throws SQLException, ClassNotFoundException {
        Connection c = ConectaBanco.conectaBanco();
        PreparedStatement p = c.prepareStatement("select * from Cliente where nome like ? and senha like ?;");
        p.setString(1, cli.getNome());
        p.setString(2, cli.getSenha());
        ResultSet r = p.executeQuery();
        boolean find = false;
        if (r.next()) {
            find = true;
            System.out.println("logado");
        } else {
            System.out.println("nao logado");
        }

        return find;
    }

    public static void createCinema(Cinema cin) throws ClassNotFoundException, SQLException {
        try {
            Connection c = ConectaBanco.conectaBanco();
            PreparedStatement p = c.prepareStatement("insert into cinema (nome, endereco, cidade, telefone, estado) values (?,?,?,?,?)");
            p.setString(1, cin.getNome());
            p.setString(2, cin.getEndereco());
            p.setString(3, cin.getCidade());
            p.setString(4, cin.getTelefone());
            p.setString(5, cin.getEstado());
            p.execute();
        } catch (Exception e) {
            System.out.println("erroR: " + e);
        }
    }

    public static Cinema selectCinema(String nomeCinema) throws ClassNotFoundException, SQLException {

        Connection c = ConectaBanco.conectaBanco();
        PreparedStatement p = c.prepareStatement("SELECT * FROM cinema where nome like ?");
        p.setString(1, nomeCinema);
        ResultSet rs = p.executeQuery();
        Cinema cin = new Cinema();

        while (rs.next()) {
            cin.setId(Integer.parseInt(rs.getString("id_cinema")));
            cin.setNome(rs.getString("nome"));
            cin.setEndereco(rs.getString("endereco"));
            cin.setCidade(rs.getString("cidade"));
            cin.setTelefone(rs.getString("telefone"));
            cin.setEstado(rs.getString("estado"));
        }
        return cin;
    }

    public static void updateCinema(Cinema cin) throws ClassNotFoundException, SQLException {

        try {
            Connection c = ConectaBanco.conectaBanco();
            PreparedStatement p = c.prepareStatement("update cinema set endereco = ?,"
                    + "                              cidade = ?, telefone = ?, estado = ? where id_cinema = ?");

            p.setString(1, cin.getEndereco());
            p.setString(2, cin.getCidade());
            p.setString(3, cin.getTelefone());
            p.setString(4, cin.getEstado());
            System.out.println("id cinema " + cin.getId());
            p.setInt(5, cin.getId());
            p.executeUpdate();
            System.out.println("passou");
        } catch (Exception e) {
            System.out.println("erroR: " + e);
        }
    }

    public static ArrayList<Cinema> selectAllCinemas() throws ClassNotFoundException, SQLException {

        Connection c = ConectaBanco.conectaBanco();
        PreparedStatement p = c.prepareStatement("SELECT * FROM cinema");
        ResultSet rs = p.executeQuery();
        ArrayList<Cinema> cinema = new ArrayList<Cinema>();
        while (rs.next()) {
            Cinema cin = new Cinema();
            cin.setId(Integer.parseInt(rs.getString("id_cinema")));
            cin.setNome(rs.getString("nome"));
            cin.setEndereco(rs.getString("endereco"));
            cin.setCidade(rs.getString("cidade"));
            cin.setTelefone(rs.getString("telefone"));
            cin.setEstado(rs.getString("estado"));
            cinema.add(cin);
        }

        return cinema;
    }

    public static void deleteCinema(int idCinema) {

        try {
            Connection c = ConectaBanco.conectaBanco();
            PreparedStatement p = c.prepareStatement("delete from cinema where id_cinema = ?");
            p.setInt(1, idCinema);
            p.execute();
        } catch (Exception e) {
            System.out.println("erroR: " + e);
        }
    }
    
     public static ArrayList<Ingresso> selectAllIngresso() throws ClassNotFoundException, SQLException {

        Connection c = ConectaBanco.conectaBanco();
        PreparedStatement p = c.prepareStatement("SELECT * FROM ingresso");
        ResultSet rs = p.executeQuery();
        ArrayList<Ingresso> listaIngresso = new ArrayList<Ingresso>();
        while (rs.next()) {
            Ingresso in = new Ingresso();
            in.setIdFilme(Integer.parseInt(rs.getString("id_filme")));            
            in.setDataFilme(rs.getString("data_filme"));
            in.setSala(rs.getInt("sala"));
            in.setPoltrona(rs.getString("poltrona"));
            in.setHorario(rs.getString("horario"));
            in.setValor(rs.getDouble("preco"));
            listaIngresso.add(in);
        }
        return listaIngresso;
    }
    
    public static void deleteIngresso(int id) throws ClassNotFoundException, SQLException {
        try {
            Connection c = ConectaBanco.conectaBanco();
            PreparedStatement p = c.prepareStatement("delete from ingresso where id_engresso = ?");
            p.setInt(1, id);            
            p.execute();
        } catch (Exception e) {
            System.out.println("erroR: " + e);
        }
    }

    public static int getFilmesMaisAssistidos(Filmes fm) {
        int res = 0;
        try {
            Connection c = ConectaBanco.conectaBanco();
            PreparedStatement p = c.prepareStatement("select count(f.nome) as total from filme as f, ingresso i where ? = i.id_filme; ");
            p.setInt(1, fm.getId());
            ResultSet r = p.executeQuery();
            
            while(r.next()){
                res = r.getInt("total");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConectaBanco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConectaBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
                   return res;
    }
}
