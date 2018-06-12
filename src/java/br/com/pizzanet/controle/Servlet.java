package br.com.pizzanet.controle;

import br.com.pizzanet.modelo.Pizza;
import br.com.pizzanet.modelo.PizzaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String flag = request.getParameter("flag");
            String resp = "";
            String proxPag = "exibir.jsp";
            Pizza pi = new Pizza();
            PizzaDao piDao = new PizzaDao();
            int r;
            if (flag.equals("cadastrar")) {
                pi.setNomePizza(request.getParameter("nomePizza"));
                pi.setPrecoPizza(Float.parseFloat(request.getParameter("precoPizza")));
                pi.setIngredientesPizza(request.getParameter("ingredientesPizza"));
                pi.setTamanhoPizza(request.getParameter("tamanhoPizza"));

                r = piDao.salvarPizza(pi);
                if (r == 0) {
                    resp = "Cadastrado com sucesso.";
                } else {
                    resp = "Falha ao cadastrar.";
                }
            }
            if (flag.equals("formAtualizar")) {
                pi.setId(Integer.parseInt(request.getParameter("idPizza")));
                pi = piDao.buscarPizza(pi);
                if (pi != null) {
                    request.setAttribute("pizza", pi);
                    proxPag = "atualizar.jsp";
                } else {
                    resp = "Registro não encontrado!";
                }
            }
            if (flag.equals("listar")) {
                List<Pizza> pizzas = piDao.listarPizzas();
                resp += "<table class=\"table table-bordered table-dark table-hover\">"
                        + "<tr>"
                        + "<th>ID</th>" + "<th>Nome</th>" + "<th>Ingredientes</th>" + "<th>Tamanho</th>" + "<th>Preço</th>"
                        + "<tr>";
                for (int i = 0; i < pizzas.size(); i++) {
                    resp += "<tr>"
                            + "<th>" + pizzas.get(i).getId() + "</th>"
                            + "<th>" + pizzas.get(i).getNomePizza() + "</th>"
                            + "<th>" + pizzas.get(i).getIngredientesPizza() + "</th>"
                            + "<th>" + pizzas.get(i).getTamanhoPizza() + "</th>"
                            + "<th>R$" + pizzas.get(i).getPrecoPizza() + "</th>"
                            + "<tr>";
                }
                resp += "</table>";
            }
            if (flag.equals("excluir")) {
                pi.setId(Integer.parseInt(request.getParameter("idPizza")));
                r = piDao.excluirPizza(pi);
                if (r == 0) {
                    resp = "Excluído com sucesso!";
                } else {
                    resp = "Registro não encontrado!";
                }
            }
            if (flag.equals("atualizar")) {
                pi.setId(Integer.parseInt(request.getParameter("idPizza")));
                pi.setNomePizza(request.getParameter("nomePizza"));
                pi.setIngredientesPizza(request.getParameter("ingredientesPizza"));
                pi.setTamanhoPizza(request.getParameter("tamanhoPizza"));
                pi.setPrecoPizza(Float.parseFloat(request.getParameter("precoPizza")));

                piDao.salvarPizza(pi);
                resp = "Atualizado com sucesso!";
            }

            request.setAttribute("resposta", resp);
            RequestDispatcher disp = request.getRequestDispatcher(proxPag);
            disp.forward(request, response);

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
        processRequest(request, response);
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
        processRequest(request, response);
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
