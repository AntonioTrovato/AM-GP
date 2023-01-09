package control.gestione.circuiti;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CircuitoDAO;
import model.entity.Circuito;

/**
 * Servlet implementation class SelezionaCircuitoControl
 */
@WebServlet("/SelezionaCircuitoControl")
public class SelezionaCircuitoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelezionaCircuitoControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpServletResponse hresponse = (HttpServletResponse) response;
		HttpSession session = hrequest.getSession(false);
		try {
			Collection<Circuito> circuiti = CircuitoDAO.doRetrieveAll();
			session.setAttribute("circuiti", circuiti);
			response.sendRedirect("/AM-GP/areautenti/tecnico/SelezionaCircuito.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
