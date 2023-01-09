package control.gestione.setup;

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
import model.entity.Setup;
import model.entity.Tecnico;

/**
 * Servlet implementation class SetupDispatcherControl
 */
@WebServlet("/SetupDispatcherControl")
public class SetupDispatcherControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetupDispatcherControl() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpSession session = hrequest.getSession(false);
		
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		Setup s = new Setup();
		try {
			s.setCircuito(CircuitoDAO.doRetrieveByKey(id));
			session.setAttribute("setupDaSalvare", s);
			RequestDispatcher dispatcher = request.getRequestDispatcher(response.encodeURL("/areautenti/tecnico/GestioneSetup.jsp"));
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
