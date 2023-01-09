package control.gestione.messaggi;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.*;
import model.entity.Messaggio;
import model.entity.Pilota;
import model.entity.Tecnico;
import model.entity.Utente;

/**
 * Servlet implementation class SendMessageControl
 */
@WebServlet("/SendMessageControl")
public class SendMessageControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMessageControl() {
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
		
		ArrayList<String> missingDatas = new ArrayList<String>();
		
		String ruolo = request.getParameter("ruolo");
		if(!(ruolo.equals("tecnico")) && !(ruolo.equals("pilota"))) {
			missingDatas.add("Ruolo");
		}
		
		String oggettoNuovoMessaggio = request.getParameter("oggettoNuovoMessaggio");
		if(oggettoNuovoMessaggio == null || oggettoNuovoMessaggio.isEmpty() || oggettoNuovoMessaggio.length()>30) {
			missingDatas.add("Oggetto");
		}
		
		String corpoNuovoMessaggio = request.getParameter("corpoNuovoMessaggio");
		
		if(!(missingDatas.isEmpty())) {
			//forward all'invio del messaggio con segnalazione errore
			request.setAttribute("missingDatas", "Hai inserito dei dati in maniera scorretta!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request,response);
			return;
		}
		
		String checkNuovoMessaggio = request.getParameter("checkNuovoMessaggio");
		if(checkNuovoMessaggio != null) {
			if(ruolo.equals("tecnico")) {
				try {
					Collection<Tecnico> tecnici = UtenteDAO.doRetrieveAllTecnico();
					for(Tecnico destinatario : tecnici) {
						if(!destinatario.getId().equals(mittente.getId()))
							MessaggioDAO.doSave(new Messaggio(1,oggettoNuovoMessaggio,corpoNuovoMessaggio,mittente,destinatario));
					}
				} catch (SQLException e) {
					request.setAttribute("missingDatas", "Non è presente alcun utente con tale ID!");
					request.getRequestDispatcher("error.jsp").forward(request,response);
				}
			}else if(ruolo.equals("pilota")) {
				try {
					Collection<Pilota> piloti = PilotaDAO.doRetrieveAll();
					for(Pilota destinatario : piloti) {
						if(!destinatario.getId().equals(mittente.getId()))
							MessaggioDAO.doSave(new Messaggio(1,oggettoNuovoMessaggio,corpoNuovoMessaggio,mittente,destinatario));
					}
				} catch (SQLException e) {
					request.setAttribute("missingDatas", "Non è presente alcun utente con tale ID!");
					request.getRequestDispatcher("error.jsp").forward(request,response);
				}
			}
		}else {
			//il parametro destinatariMessaggi corrisponde all'id dell'utente
			String destinatariMessaggio = request.getParameter("destinatari");
			Utente destinatario = null;
			try {
				destinatario = UtenteDAO.doRetrieveByKey(destinatariMessaggio);
				Messaggio messaggio = new Messaggio(1,oggettoNuovoMessaggio,corpoNuovoMessaggio,mittente,destinatario);
				MessaggioDAO.doSave(messaggio);
				mittente.getMailbox().getMessaggiRicevuti().add(messaggio);
			} catch (SQLException e) {
				request.setAttribute("missingDatas", "Non è presente alcun utente con tale ID!");
				request.getRequestDispatcher("error.jsp").forward(request,response);
			}
		}
		
		//redirect a MessaggiInviati.jsp
		response.sendRedirect("/AM-GP/areautenti/MessaggiInviati.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
