package Service;

import RecomendacaoFilmes.ConectaBanco;
import static RecomendacaoFilmes.ConectaBanco.selectFilme;
import classes.Cinema;
import classes.Filmes;
import classes.Ingresso;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class DataGridView implements Serializable {

    private List<Filmes> filmes;
    private List<Cinema> cinema;

    private Filmes selectedFilmes;
    private Cinema selectedCinema;
    
    private Ingresso selectIngresso;

    @ManagedProperty("#{filmesService}")
    private FilmeService service;
        

    @PostConstruct
    public void init() {
        //filmes = service.createFilmes(48);

        try {
            // ConectaBanco.createFilmes(filmes.get(0));
            //ConectaBanco.deleteFilme(2);
            //ConectaBanco.updateFilme("Filme novo3");
            //ConectaBanco.selectFilme("Nome do filme");
            filmes = ConectaBanco.selectAllFilmes();
            cinema = ConectaBanco.selectAllCinemas();
            /*Filmes nFilme = selectFilme("Marcleo");
            nFilme.setDiretor("novo diretor");
            
            ConectaBanco.updateFilme(nFilme);*/

            System.out.println(filmes);
        } catch (Exception e) {
        }

    }
    

    public List<Filmes> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filmes> filmes) {
        this.filmes = filmes;
    }

    public Filmes getSelectedFilmes() {
        return selectedFilmes;
    }

    public void setSelectedFilmes(Filmes selectedFilmes) {
        this.selectedFilmes = selectedFilmes;
    }

    public FilmeService getService() {
        return service;
    }

    public void setService(FilmeService service) {
        this.service = service;
    }

    public List<Cinema> getCinema() {
        return cinema;
    }

    public void setCinema(List<Cinema> cinema) {
        this.cinema = cinema;
    }

    public Cinema getSelectedCinema() {
        return selectedCinema;
    }

    public void setSelectedCinema(Cinema selectedCinema) {
        this.selectedCinema = selectedCinema;
    }
    
    

}
