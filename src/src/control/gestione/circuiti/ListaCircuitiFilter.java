package control.gestione.circuiti;

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


import model.dao.CircuitoDAO;
import model.entity.Circuito;

/**
 * Servlet Filter implementation class ListaCircuitiFilter
 */
@WebFilter(filterName = "/ListaCircuitiFilter", urlPatterns = {"/areautenti/tecnico/ListaCircuiti.jsp"})
public class ListaCircuitiFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ListaCircuitiFilter() {
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
				Collection<Circuito> circuiti = CircuitoDAO.doRetrieveAll();
				session.setAttribute("circuiti", circuiti);
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
