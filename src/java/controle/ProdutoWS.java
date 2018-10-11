/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.Tipo;
import modelo.Produto;
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
@WebServlet(name = "ProdutoWS", urlPatterns = {"/ProdutoWS"})
public class ProdutoWS extends HttpServlet {


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
        
        //se está vindo códigon e nome -- excluir, senão listar
        if(request.getParameter("codigo")!=null){
            
            //excluir
            String codigo;
            String nome;
            String preco;
            String tipo;
            String msg;
            codigo = request.getParameter("codigo");
            nome = request.getParameter("nome");
            preco = request.getParameter("preco");
            tipo = request.getParameter("tipo");
            msg = "Você quer excluir  o tipo de código!" + codigo + "nome" + nome + "preço" + preco + "tipo" + tipo;
            
            request.setAttribute("msg", msg);
            
            RequestDispatcher destino;
            destino = request.getRequestDispatcher("Produto-Del.jsp");
            
            //Chamar a saida(ir para a pg destino)
            destino.forward(request, response);
            
        }
        else{
       
        List<Produto> lista = this.listar();
        request.setAttribute("lista", lista);
        
        RequestDispatcher destino;
        destino = request.getRequestDispatcher("Produto.jsp");
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
        String preco = request.getParameter("txtpreco");
        String tipo = request.getParameter("txttipo");
        
        //Enviar informação para uma saida (outra página)
        String msg;
        msg = "Dados do produto: "+ codigo + ", " + nome + ", " + preco + ", " + tipo;
        request.setAttribute("msg", msg);
        
        //dizer para onde ir
        RequestDispatcher destino;
        destino = request.getRequestDispatcher("Produto-Add-Ok.jsp");
        
        //Chamar a saida(ir para a pg destino)
        destino.forward(request, response);
    }
    
    public List<Produto> listar()
    {
        List<Produto> lista;
        lista = new ArrayList<>();
        Tipo t = new Tipo();
        Produto obj = new Produto();
        
        obj.setCodigo(1);
        obj.setNome("Pastel");
        obj.setPreco(3.09);
        
        //Populo o objeto da classe associada
        t.setCodigo(1);
        t.setNome("Salgado");
        obj.setTipo(t);
        
        lista.add(obj);
        
        obj = new Produto();
        obj.setCodigo(2);
        obj.setNome("Pastel Doce");
        obj.setPreco(3.09);
        
        t = new Tipo();
        t.setCodigo(2);
        t.setNome("Doce");
        obj.setTipo(t);
        
        lista.add(obj);
        
        obj = new Produto();
        obj.setCodigo(3);
        obj.setNome("Bolo");
        obj.setPreco(5.00);
        
        obj.setTipo(t);
        
        lista.add(obj);
        
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
