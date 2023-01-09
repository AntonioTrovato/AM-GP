package control.gestione.setup;

import java.io.IOException;
import java.sql.SQLException;

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
 * Servlet implementation class SaveSetupControl
 */
@WebServlet("/SaveSetupControl")
public class SaveSetupControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveSetupControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpServletResponse hresponse = (HttpServletResponse) response;
		HttpSession session = hrequest.getSession(false);
		Tecnico tecnico=(Tecnico) session.getAttribute("utente");
		Setup s = (Setup) session.getAttribute("setupDaSalvare");
		
		s.setAutore(((Tecnico) session.getAttribute("utente"))); //posso farlo perch� c'� un filtro e se sfrutto questa Servlet sono autenticato
		try {
			double caricoAnt = Double.parseDouble(request.getParameter("caricoAnt"));
			double caricoPost = Double.parseDouble(request.getParameter("caricoPost"));
			double campanAnt = Double.parseDouble(request.getParameter("campanAnt"));
			double campanPost = Double.parseDouble(request.getParameter("campanPost"));
			double converAnt = Double.parseDouble(request.getParameter("converAnt"));
			double converPost = Double.parseDouble(request.getParameter("converPost"));
			double pressFren = Double.parseDouble(request.getParameter("pressFren"));
			double barrPost = Double.parseDouble(request.getParameter("barrPost"));
			double barrAnt = Double.parseDouble(request.getParameter("barrAnt"));
			
			s.setCaricoAerodinamicoAnteriore(caricoAnt);
			s.setCaricoAerodinamicoPosteriore(caricoPost);
			s.setCampanaturaAnteriore(campanAnt);
			s.setCampanaturaPosteriore(campanPost);
			s.setConvergenzaAnteriore(converAnt);
			s.setConvergenzaPosteriore(converPost);
			s.setPressioneFreni(pressFren);
			s.setBarraAntirollioPosteriore(barrPost);
			s.setBarraAntirollioAnteriore(barrAnt);
			SetupDAO.doSave(s);
			session.removeAttribute("setupDaSalvare");
			tecnico.setSetupList(SetupDAO.doRetrieveByTecnico(tecnico));
			session.setAttribute("utente", tecnico);
			response.sendRedirect("/AM-GP/areautenti/tecnico/ListaSetup.jsp");
			
		}catch(IllegalArgumentException | SQLException e) {
			request.setAttribute("missingDatas", "Hai inserito dei dati in maniera scorretta!");
			request.getRequestDispatcher("error.jsp").forward(request,response);
		}
	}

}
