package control.gestione.messaggi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.dao.MessaggioDAO;
import model.dao.PilotaDAO;
import model.dao.UtenteDAO;
import model.entity.Messaggio;
import model.entity.Pilota;
import model.entity.Tecnico;
import model.entity.Utente;

/**
 * Servlet implementation class DynamicSelectControl
 */
@WebServlet("/DynamicSelectControl")
public class DynamicSelectControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DynamicSelectControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		Utente mittente = (Utente) session.getAttribute("utente");
		
		String ruolo = request.getParameter("ruolo");
		String jsonResponse = "";
		if(ruolo.equals("tecnico")) {
			Collection<Tecnico> tecniciDestinatari = new ArrayList<Tecnico>();
			try {
				tecniciDestinatari = UtenteDAO.doRetrieveAllTecnico();
				Iterator<Tecnico> iterator = tecniciDestinatari.iterator();
				while(iterator.hasNext()) {
					String id = iterator.next().getId();
					if(id.equals(mittente.getId()))
							iterator.remove();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!(tecniciDestinatari.isEmpty()))
				jsonResponse = new Gson().toJson(tecniciDestinatari);
		}else if(ruolo.equals("pilota")) {
			Collection<Pilota> pilotiDestinatari = new ArrayList<Pilota>();
			try {
				pilotiDestinatari = PilotaDAO.doRetrieveAll();
				Iterator<Pilota> iterator = pilotiDestinatari.iterator();
				while(iterator.hasNext()) {
					String id = iterator.next().getId();
					if(id.equals(mittente.getId()))
							iterator.remove();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!(pilotiDestinatari.isEmpty()))
				jsonResponse = new Gson().toJson(pilotiDestinatari);
		}
		
		response.setCharacterEncoding("utf8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(jsonResponse);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
