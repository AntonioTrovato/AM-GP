package control.gestione.setup;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.SetupDAO;
import model.entity.Setup;
import model.entity.Tecnico;

/**
 * Servlet implementation class ModificaSetupControl
 */
@WebServlet("/ModificaSetupControl")
public class ModificaSetupControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static SetupDAO setupDAO = new SetupDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaSetupControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idSetup = request.getParameter("idSetup");
		HttpSession session = request.getSession();
		session.removeAttribute("idSetupMod");
		session.setAttribute("idSetupMod", idSetup);
		try {
			Setup setup= SetupDAO.doRetrieveByKey(Integer.parseInt(idSetup));
			if(setup.getId()==0) {
				request.setAttribute("missingDatas", "Hai inserito dei dati in maniera scorretta!");
				request.getRequestDispatcher("error.jsp").forward(request,response);
				return;
			}
			request.removeAttribute("setup");
			request.setAttribute("setup",setup);
			
		} catch (NumberFormatException | SQLException e) {
			request.setAttribute("missingDatas", "Hai inserito dei dati in maniera scorretta!");
			request.getRequestDispatcher("error.jsp").forward(request,response);
		}
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/areautenti/tecnico/ModificaSetup.jsp");
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
