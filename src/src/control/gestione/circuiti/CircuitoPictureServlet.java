package control.gestione.circuiti;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CircuitoDAO;

/**
 * Servlet implementation class CircuitoPictureServlet
 */
@WebServlet("/getPicture")
public class CircuitoPictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static CircuitoDAO circuito = new CircuitoDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CircuitoPictureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String)(request.getParameter("id"));
		if ( id != "")
		{
			byte[] bt=null;
			try {
				bt = circuito.load(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			ServletOutputStream out = response.getOutputStream();
			if(bt != null)
			{
				out.write(bt);
				response.setContentType("image/jpeg");			
			}
			out.close();
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
