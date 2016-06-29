package RecomendacaoFilmes;

import classes.Cliente;
import classes.Filmes;
import classes.PerfilCliente;
import classes.PerfilFilme;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class RecomendaFilmes {
    
     private double calculo(double per1, double per2) {
        return per1 + per2 / 2;
    }

    public static List<Filmes> recomenda(Cliente user) throws ClassNotFoundException, SQLException {
        List<Filmes> novaL = new ArrayList<Filmes>();
        List<Filmes> fms = ConectaBanco.listAll();
        for (int j = 0; j < 10; j++) {
            for (int i=0 ; i<fms.size(); i++) {
                System.out.println("Filme " + fms.get(i).getNome()+ " diferenca - " + calculaDiferenca(user.getPerfil(), fms.get(i).getPerfil()));
                if (calculaDiferenca(user.getPerfil(), fms.get(i).getPerfil()) <= j) {
                    novaL.add(fms.get(i));
                    fms.remove(i);
                    break;
                }
            }

        }

        return novaL;
    }

    private static double calculaDiferenca(PerfilCliente per1, PerfilFilme per2) {
        double result = 0;
        if(per1.getAcao()- per2.getAcao() > 0)
            result+= (per1.getAcao()- per2.getAcao())/10;
        else if(per1.getAcao()- per2.getAcao() < 0)
            result+= (per2.getAcao()- per1.getAcao())/10;
            
        if(per1.getAnimação()- per2.getAnimacao()> 0)
            result+= (per1.getAnimação()- per2.getAnimacao())/10;
        else if(per1.getAnimação()- per2.getAnimacao()< 0)
            result+= (per2.getAnimacao()- per1.getAnimação())/10;
        
        if(per1.getComedia()- per2.getComedia()> 0)
            result+= (per1.getComedia()- per2.getComedia())/10;
        else if(per1.getComedia()- per2.getComedia()< 0)
            result+= (per2.getComedia()- per1.getComedia())/10;
        
        if(per1.getDocumentario()- per2.getDocumentario()> 0)
            result+= (per1.getDocumentario()- per2.getDocumentario())/10;
        else if(per1.getDocumentario()- per2.getDocumentario()< 0)
            result+= (per2.getDocumentario()- per1.getDocumentario())/10;
        
        if(per1.getDrama()- per2.getDrama()> 0)
            result+= (per1.getDrama()- per2.getDrama())/10;
        else if(per1.getDrama()- per2.getDrama()< 0)
            result+= (per2.getDrama()- per1.getDrama())/10;
        
        if(per1.getRomance()- per2.getRomance()> 0)
            result+= (per1.getRomance()- per2.getRomance())/10;
        else if(per1.getRomance()- per2.getRomance()< 0)
            result+= (per2.getRomance()- per1.getRomance())/10;
            
        if(per1.getTerror()- per2.getTerror()> 0)
            result+= (per1.getTerror()- per2.getTerror())/10;
        else if(per1.getTerror()- per2.getTerror()< 0)
            result+= (per2.getTerror()- per1.getTerror())/10;
        

        return result;

    }
   
    
}
