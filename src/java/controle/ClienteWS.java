/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.TipoCliente;
import modelo.Cliente;
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
@WebServlet(name = "ClienteWS", urlPatterns = {"/ClienteWS"})
public class ClienteWS extends HttpServlet {

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
            out.println("<title>Servlet ClienteWS</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClienteWS at " + request.getContextPath() + "</h1>");
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
            String nome;
            String tipocliente;
            String msg;
            codigo = request.getParameter("codigo");
            nome = request.getParameter("nome");
            tipocliente = request.getParameter("tipocliente");
            msg = "Você quer excluir  o tipo de código!" + codigo + "nome" + nome + "tipocliente" + tipocliente;
            
            request.setAttribute("msg", msg);
            
            RequestDispatcher destino;
            destino = request.getRequestDispatcher("Cliente-Del.jsp");
            
            //Chamar a saida(ir para a pg destino)
            destino.forward(request, response);
            
        }
        else{
        List<Cliente> lista = this.listar();
        request.setAttribute("lista", lista);
        
        RequestDispatcher destino;
        destino = request.getRequestDispatcher("Cliente.jsp");
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
        String nome = request.getParameter("txtnome");
        String tipocliente = request.getParameter("txttipocliente");
        
        //Enviar informação para uma saida (outra página)
        String msg;
        msg = "Dados do produto: "+ codigo + ", " + nome + ", " + tipocliente;
        request.setAttribute("msg", msg);
        
        //dizer para onde ir
        RequestDispatcher destino;
        destino = request.getRequestDispatcher("Cliente-Add-Ok.jsp");
        
        //Chamar a saida(ir para a pg destino)
        destino.forward(request, response);
    }
    
    public List<Cliente> listar()
    {
        List<Cliente> lista;
        lista = new ArrayList<>();
        TipoCliente tc = new TipoCliente();
        Cliente obj = new Cliente();
        
        obj.setCodigo(1);
        obj.setNome("Lucas");
        
        //Populo o objeto da classe associada
        tc.setCodigo(1);
        tc.setNome("Professor");
        obj.setTipocliente(tc);
        
        lista.add(obj);
        
        obj = new Cliente();
        obj.setCodigo(2);
        obj.setNome("Cristiano");
       
        tc = new TipoCliente();
        tc.setCodigo(2);
        tc.setNome("Aluno");
        obj.setTipocliente(tc);
        
        lista.add(obj);
        
        obj = new Cliente();
        obj.setCodigo(3);
        obj.setNome("Outros");
        
        tc = new TipoCliente();
        tc.setCodigo(3);
        tc.setNome("blabla");
        obj.setTipocliente(tc);
        
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
