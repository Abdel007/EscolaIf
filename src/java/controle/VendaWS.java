/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.Venda;
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
@WebServlet(name = "VendaWS", urlPatterns = {"/VendaWS"})
public class VendaWS extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VendaWS</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VendaWS at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
            String data;
            String produto;
            String quantidade;
            String valorpago;
            String msg;
            codigo = request.getParameter("codigo");
            data = request.getParameter("data");
            produto = request.getParameter("produto");
            quantidade = request.getParameter("quantidade");
            valorpago = request.getParameter("valorpago");
            msg = "Você quer excluir  o tipo de código!" + codigo + "data" + data + "produto" + produto + "quantidade" + quantidade + "valorpago" + valorpago;
            
            request.setAttribute("msg", msg);
            
            RequestDispatcher destino;
            destino = request.getRequestDispatcher("Venda-Del.jsp");
            
            //Chamar a saida(ir para a pg destino)
            destino.forward(request, response);
            
        }
        else{
        
        List<Venda> lista = this.listar();
        request.setAttribute("lista", lista);
        
        RequestDispatcher destino;
        destino = request.getRequestDispatcher("Venda.jsp");
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
        String codigo = request.getParameter("txtcodigo");
        String data = request.getParameter("txtdata");
        String produto = request.getParameter("txtproduto");
        String quantidade = request.getParameter("txtquantidade");
        String valorpago = request.getParameter("txtvalorpago");
        
        //Enviar informação para uma saida (outra página)
        String msg;
        msg = "Dados do produto: "+ codigo + ", " + data + ", " + produto + ", " + quantidade + ", " + valorpago;
        request.setAttribute("msg", msg);
        
        //dizer para onde ir
        RequestDispatcher destino;
        destino = request.getRequestDispatcher("Venda-Add-Ok.jsp");
        
        //Chamar a saida(ir para a pg destino)
        destino.forward(request, response);
    }
    
    public List<Venda> listar()
    {
        List<Venda> lista;
        lista = new ArrayList<>();
        Produto p = new Produto();
        Venda obj = new Venda();
        
        obj.setCodigo(1);
        obj.setData("10/10/2018");
        obj.setQuantidade(1);
        obj.setValorpago(3.00);
        
        //Populo o objeto da classe associada
        p.setCodigo(1);
        p.setNome("Pastel");
        obj.setProduto(p);
        
        lista.add(obj);
        
        obj = new Venda();
        obj.setCodigo(2);
        obj.setData("10/10/2018");
        obj.setQuantidade(1);
        obj.setValorpago(4.00);
        
        p = new Produto();
        p.setCodigo(2);
        p.setNome("Pastel Doce");
        obj.setProduto(p);
        
        lista.add(obj);
        
        obj = new Venda();
        obj.setCodigo(3);
        obj.setData("10/10/2018");
        obj.setQuantidade(1);
        obj.setValorpago(12.00);
        
        p = new Produto();
        p.setCodigo(3);
        p.setNome("Bolo");
        obj.setProduto(p);
        
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