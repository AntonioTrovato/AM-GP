package control.gestione.setup;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.dao.SetupDAO;

/**
 * Servlet implementation class ViewSetupControl
 */
@WebServlet("/ViewSetupControl")
public class ViewSetupControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static SetupDAO setupDAO = new SetupDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewSetupControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idSetup = request.getParameter("idSetup");
	try {	
		int id = Integer.parseInt(idSetup);
		if(id<0) {
			request.setAttribute("missingDatas", "Hai inserito dei dati in maniera scorretta!");
			request.getRequestDispatcher("error.jsp").forward(request,response);
			return;
		}
		
		request.removeAttribute("idSetup");
		request.setAttribute("idSetup",idSetup);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/areautenti/tecnico/ViewSetup.jsp");
		dispatcher.forward(request, response);
	}
	catch(NumberFormatException e) {
		request.setAttribute("missingDatas", "Hai inserito dei dati in maniera scorretta!");
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
