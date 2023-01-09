package control.gestione.setup;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

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

import model.dao.SetupDAO;
import model.entity.Tecnico;
import model.entity.Utente;

/**
 * Servlet Filter implementation class SetupFilter
 */
@WebFilter(filterName = "/SetupFilter", urlPatterns = {"/areautenti/tecnico/ListaSetup.jsp"})
public class SetupFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SetupFilter() {
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
		if(session==null) {
			hresponse.sendRedirect(("/AM-GP/Login.jsp"));
		}
		else {
			try {
				Utente u = (Utente) session.getAttribute("utente");
				if(u != null) {
					Tecnico t = (Tecnico) u;
					t.setSetupList(SetupDAO.doRetrieveByTecnico(t));
				}
				else {
					hresponse.sendRedirect(("/AM-GP/Login.jsp"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
