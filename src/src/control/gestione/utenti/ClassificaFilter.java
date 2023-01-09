package control.gestione.utenti;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.PilotaDAO;
import model.dao.UtenteDAO;

/**
 * Servlet Filter implementation class ClassificaFilter
 */
@WebFilter(filterName="/ClassificaFilter", urlPatterns={"/areautenti/pilota/Classifica.jsp"})
public class ClassificaFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ClassificaFilter() {
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
		try {
			session.setAttribute("piloti", PilotaDAO.doRetrieveAll());
			session.setAttribute("utenti",UtenteDAO.doRetrieveAll());
			chain.doFilter(request, response);
		} catch(SQLException e) {
			System.out.println("Error: "+ e.getMessage());
			request.setAttribute("error", e.getMessage());
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
