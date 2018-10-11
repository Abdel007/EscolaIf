/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Tipo;


public class TipoDAO{


   protected EntityManager em;

        
   public TipoDAO()  {
        EntityManagerFactory emf;
       try {
           emf = Conexao.getConexao();
           em = emf.createEntityManager();
       } catch (Exception ex) {
           Logger.getLogger(TipoDAO.class.getName()).log(Level.SEVERE, null, ex);
           Logger.getLogger("Não foi possível realizar a conexão com a unidade de persistência. Verifique a conexão");
           
       }
        
    }
   
   public Boolean incluir(Tipo obj) {
        Boolean retorno;
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
            retorno = true;
        } catch (RuntimeException e) {
             Logger.getLogger(Tipo.class.getName()).log(Level.SEVERE, null, e);
           Logger.getLogger("Erro ao incluir, veja o código acima");
           
            em.getTransaction().rollback();
           
            retorno = false;
            throw e;
        } finally {
            //em.close();
            
        }
        return retorno;
   }

   public Boolean alterar(Tipo obj) {
        Boolean retorno;
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
            retorno = true;
        } catch (RuntimeException e) {
             Logger.getLogger(TipoDAO.class.getName()).log(Level.SEVERE, null, e);
          Logger.getLogger("Erro ao alterar, veja o código acima"); 
            em.getTransaction().rollback();
            retorno = false;
            throw e;
        } finally {
            // em.close();
        }
        return retorno;
   }

   public Boolean excluir(Tipo obj) {
       Boolean retorno;
        try {
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
            retorno = true;
        } catch (RuntimeException e) {
             Logger.getLogger(TipoDAO.class.getName()).log(Level.SEVERE, null, e);
             Logger.getLogger("Erro ao excluir, veja o código acima"); 
          
            em.getTransaction().rollback();
            retorno = false;
        } finally {
            //em.close();
        }
        return retorno;
   }

   public List<Tipo> listar() {
      return em.createQuery("Select t from Tipo t").getResultList();
   }
   
   public List<Tipo> listar(String filtro) throws Exception{
        return em.createNamedQuery("Tipo.findFilter").setParameter("filtro","%" + filtro.toUpperCase() + "%").getResultList();
    }

   public Tipo buscarPorChavePrimaria(Integer chaveprimaria) {
       return em.find(Tipo.class, chaveprimaria);
   }
   
   public void fecharConexao() {
        Conexao.closeConexao();
    }
   
   
   
   
   
}
