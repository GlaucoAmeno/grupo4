package Service;

import classes.Filmes;
import classes.PerfilFilme;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "filmesService")
@ApplicationScoped
public class FilmeService {
    Filmes filme = new Filmes();
    private final static String[] generos;

    private final static String[] classificacao;

    static {
        generos = new String[10];
        generos[0] = "infantil";
        generos[1] = "acao";
        generos[2] = "terror";
        generos[3] = "comedia";

        classificacao = new String[10];
        classificacao[0] = "10";
        classificacao[1] = "12";
        classificacao[2] = "14";
        classificacao[2] = "16";
        classificacao[2] = "18";
    }

    public List<Filmes> createFilmes(int size) {
        List<Filmes> list = new ArrayList<Filmes>();
        for (int i = 0; i < size; i++) {
            PerfilFilme perfil = new PerfilFilme();
            list.add(new Filmes(getRandomId(), getRandomNome(), getRandomElenco(),
                    getRandomDiretor(), getClassificao(), getRandomSinopse(),
                    getRandomDuracao(), generatorData(), getGeneros() /*perfil*/));
            System.out.println("id = " + list.get(i).getId());
        }

        return list;
    }

    private int getRandomId() {
        Random rand = new Random();
        int id = rand.nextInt();
        return id;
    }

    private String getRandomDuracao() {
        String dur = UUID.randomUUID().toString().substring(0, 8);
        return dur;
    }

    private String getRandomNome() {
        String id = UUID.randomUUID().toString().substring(0, 8);
        return "Filme" + id;
    }

    private String getRandomElenco() {
        String id = UUID.randomUUID().toString().substring(0, 8);
        return "Ator" + id + "- Ator" + id;
    }

    private String getRandomDiretor() {
        String id = UUID.randomUUID().toString().substring(0, 8);
        return "Diretor" + id;
    }

    private String getRandomSinopse() {
        String id = UUID.randomUUID().toString().substring(0, 8);
        return "Sinopse" + id;
    }

    public String getGeneros() {
        return generos[1];
    }

    public String getClassificao() {
        return classificacao[1];
    }

    public String generatorData() {
        String c = Calendar.getInstance().getTime().toString();
        return c;
    }

    public Filmes getFilme() {
        return filme;
    }

    public void setFilme(Filmes filme) {
        this.filme = filme;
    }
    
}
