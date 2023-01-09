package control.gestione.utenti;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.Pilota;
import model.entity.Utente;

/**
 * Servlet Filter implementation class PilotaFilter
 */
@WebFilter(filterName = "/PilotaFilter", urlPatterns={"/areautenti/pilota/*"})
public class PilotaFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PilotaFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpServletResponse hresponse = (HttpServletResponse) response;
		HttpSession session = hrequest.getSession(false);
		
		if(session != null) {
			if(session.getAttribute("utente") != null) {
				Utente u = (Utente) session.getAttribute("utente");
				if(u instanceof Pilota) {
					chain.doFilter(request, response);
				}
				else hresponse.sendRedirect("/AM-GP/areautenti/MessaggiRicevuti.jsp");
			}
			else hresponse.sendRedirect("/AM-GP/Login.jsp");
		}
		else hresponse.sendRedirect("/AM-GP/Login.jsp");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
