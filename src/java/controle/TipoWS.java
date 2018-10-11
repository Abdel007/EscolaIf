
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.TipoDAO;
import modelo.Tipo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas Abdel
 */
@WebServlet(name = "TipoWS", urlPatterns = {"/TipoWS"})
public class TipoWS extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //se está vindo códigon -- excluir, senão listar
        if(request.getParameter("codigo")!=null){
            
            //excluir
            String codigo;
            String msg;
            codigo = request.getParameter("codigo");
            TipoDAO dao = new TipoDAO();
            //busco o objeto
            Tipo obj = dao.buscarPorChavePrimaria(Integer.parseInt(codigo));
            boolean deucerto = dao.excluir(obj);
            if(deucerto==true){
                msg = "Excluido com sucesso";
            }
            else{
                msg = "Não foi possivel excluir, verifique dependências";
            }
            dao.fecharConexao();
            
            
            msg = "Você quer excluir  o tipo de código!" + codigo;
            
            request.setAttribute("msg", msg);
            
            RequestDispatcher destino;
            destino = request.getRequestDispatcher("Tipo-Del.jsp");
            
            //Chamar a saida(ir para a pg destino)
            destino.forward(request, response);
            
        }
        else{
            //retornar uma lista de tipos para a pagina Tipo.jsp(lista)
        //busco a lista
        List<Tipo> lista = this.listar();
        //Coloco a lista no retorno da pagina
        request.setAttribute("lista", lista);
        
        //Mando pára a pagina
        //dizer para onde ir
        RequestDispatcher destino;
        destino = request.getRequestDispatcher("Tipo.jsp");
        
        //Chamar a saida(ir para a pg destino)
        destino.forward(request, response);
        }
        
        
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //pega as informações enviadas pelo form
        String nome = request.getParameter("txtnome");
        String codigo = request.getParameter("txtcodigo");
        
        TipoDAO dao = new TipoDAO();
        //criar o meu pbjeto que vai ser gravado no banco
        Tipo obj = new Tipo();
        obj.setNome(nome);
        obj.setCodigo(Integer.parseInt(codigo));
        //chama o metodo de inserção
        dao.incluir(obj);
        
        dao.fecharConexao();
        
        //Enviar informação para uma saida (outra página)
        String msg;
        msg = "Voce digitou: "+ codigo + "nome:" + nome;
        request.setAttribute("msg", msg);
        
        //dizer para onde ir
        RequestDispatcher destino;
        destino = request.getRequestDispatcher("Tipo-Add-Ok.jsp");
        
        //Chamar a saida(ir para a pg destino)
        destino.forward(request, response);
        }
    
    public List<Tipo> listar()
    {
        List<Tipo> lista;
        //Chamar a classe de acesso a dados
        TipoDAO dao = new TipoDAO();
        //chamo a listagem
        lista = dao.listar();
        //fecho a conexão com o postgreSQL
        dao.fecharConexao();
        return lista;
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
