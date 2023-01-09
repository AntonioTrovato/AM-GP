package control.gestione.utenti;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.*;
import model.entity.*;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static UtenteDAO utenteDAO= new UtenteDAO();  
	 
    public LoginControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente utente=new Utente();
		HttpSession session= request.getSession();
		
		String idUser= request.getParameter("userID");
		String passUser=request.getParameter("password");
		
	
		try {
		
			if(utenteDAO.doValidate(idUser, passUser)==true) {
				utente=UtenteDAO.doRetrieveByKey(idUser);
				utente.setMailbox(new Mailbox(MessaggioDAO.doRetrieveAllByReceiver(utente), MessaggioDAO.doRetrieveAllBySender(utente)));
			
				if(utente.getRuolo().equals("pilota")) {
					Pilota p = new Pilota();
					p.setId(utente.getId());
					p.setNome(utente.getNome());
					p.setCognome(utente.getCognome());
					p.setMailbox(utente.getMailbox());
					p.setPassword(utente.getPassword());
					p.setRuolo(utente.getRuolo());
					p= PilotaDAO.doRetrieveByPilota(p);
					utente=p;
					
				}	
				else if(utente.getRuolo().equals("tecnico")) {
					Tecnico t = new Tecnico();
					t.setNome(utente.getNome());
					t.setCognome(utente.getCognome());
					t.setId(utente.getId());
					t.setMailbox(utente.getMailbox());
					t.setRuolo(utente.getRuolo());
					t.setPassword(utente.getPassword());
					t.setSetupList(new ArrayList<Setup>((SetupDAO.doRetrieveByTecnico(t))));
					utente=t;
				}
				
				session.removeAttribute("utente");
				session.setAttribute("utente",utente);
				response.sendRedirect("/AM-GP/areautenti/MessaggiRicevuti.jsp");
					
			}
			else {
				request.setAttribute("missingDatas", "Dati di accesso scorretti o mancanti!");
				request.getRequestDispatcher("./error.jsp").forward(request,response);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
