package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Knjiga;
import model.beans.Korisnik;
import model.dao.KnjigaDAO;
import model.dao.KorisnikDAO;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String knjigaId=request.getParameter("knjigaId");
		KnjigaDAO knjigaDao=new KnjigaDAO();
		String korId=request.getParameter("korId");
		KorisnikDAO korDao=new KorisnikDAO();
		
		if(knjigaId!=null){
			Knjiga knjiga=knjigaDao.get(Integer.parseInt(knjigaId));
			knjiga.setStanjeKnjige(false);
			knjigaDao.update(knjiga);
			response.sendRedirect("ReadController");
		}else if(korId!=null){
			Korisnik k=korDao.get(Integer.parseInt(korId));
			korDao.delete(k);
			response.sendRedirect("ReadControllerKorisnik");
		}else
			response.sendRedirect("ReadController");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
