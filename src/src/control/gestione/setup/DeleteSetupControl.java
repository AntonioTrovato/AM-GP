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


import model.dao.SetupDAO;
import model.entity.Setup;
import model.entity.Tecnico;


/**
 * Servlet implementation class DeleteSetupControl
 */
@WebServlet("/DeleteSetupControl")
public class DeleteSetupControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static SetupDAO setupDAO = new SetupDAO();
    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSetupControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idSetup = request.getParameter("idSetup");
		HttpSession session= request.getSession();
		Tecnico tecnico= (Tecnico) session.getAttribute("utente");
		
		try {
			int id = Integer.parseInt(idSetup);
			Setup s = SetupDAO.doRetrieveByKey(id);
			if(s.getId()==0) {
				request.setAttribute("missingDatas", "Non è presente alcun Setup con tale ID!");
				request.getRequestDispatcher("error.jsp").forward(request,response);
				return;
			}
			SetupDAO.doDelete(id);
			tecnico.setSetupList(SetupDAO.doRetrieveByTecnico(tecnico));
			session.setAttribute("utente", tecnico);
			response.sendRedirect("/AM-GP/areautenti/tecnico/ListaSetup.jsp");
			
		} catch (SQLException | NumberFormatException e) {
			request.setAttribute("missingDatas", "Non è presente alcun Setup con tale ID!");
			request.getRequestDispatcher("error.jsp").forward(request,response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
