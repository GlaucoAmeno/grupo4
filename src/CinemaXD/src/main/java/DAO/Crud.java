/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author Rodrigo Kuya
 */
public interface Crud<T> {
    public void inserir(T entity);
    
    public void alterar(Object p);
    
    public void remover(int id);
    
    public List<T> lista();
    
    public T findById(int id);
}
