package control.gestione.circuiti;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.*;

/**
 * Servlet implementation class ViewCircuitoControl
 */
@WebServlet("/ViewCircuitoControl")
public class ViewCircuitoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static CircuitoDAO circuitoDAO = new CircuitoDAO();
	static RettilineoDAO rettilineoDAO = new RettilineoDAO();
	static CurvaDAO curvaDAO = new CurvaDAO();
    
       
  
    public ViewCircuitoControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			request.removeAttribute("circuiti");
			request.setAttribute("circuiti", CircuitoDAO.doRetrieveAll());
			
			
			
			String idCircuito = request.getParameter("idCircuito");
			int id = Integer.parseInt(idCircuito);
			
			if(id<0) {
				request.setAttribute("missingDatas", "Hai inserito dei dati in maniera scorretta!");
				request.getRequestDispatcher("error.jsp").forward(request,response);
				return;
			}
				
			request.removeAttribute("idCircuito");
			request.setAttribute("idCircuito",idCircuito);
			String page = request.getParameter("page");
			request.removeAttribute("page");
			request.setAttribute("page",page);
			request.removeAttribute("rettilinei");
			request.setAttribute("rettilinei", RettilineoDAO.doRetrieveAllByCircuito(Integer.parseInt(idCircuito)));
			request.removeAttribute("curve");
			request.setAttribute("curve", CurvaDAO.doRetrieveAllByCircuito(Integer.parseInt(idCircuito)));
			
			
		   } catch (SQLException | NumberFormatException e) {
				request.setAttribute("missingDatas", "Hai inserito dei dati in maniera scorretta!");
				request.getRequestDispatcher("error.jsp").forward(request,response);
		}
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/areautenti/tecnico/ViewCircuito.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
