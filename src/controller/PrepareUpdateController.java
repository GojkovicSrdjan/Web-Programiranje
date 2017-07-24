package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.KategorijaDAO;
import model.dao.KnjigaDAO;
import model.dao.KorisnikDAO;
import model.dao.PorudzbinaDAO;

/**
 * Servlet implementation class PrepareUpdateController
 */
@WebServlet("/PrepareUpdateController")
public class PrepareUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrepareUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String knjigaId=request.getParameter("knjigaId");
		String korId=request.getParameter("korId");
		String pId=request.getParameter("porudzbinaId");

		PorudzbinaDAO pDao=new PorudzbinaDAO();
		KorisnikDAO korDao=new KorisnikDAO();
		KnjigaDAO knjigaDao=new KnjigaDAO();
		KategorijaDAO katDao=new KategorijaDAO();
		if(knjigaId!=null){
			request.setAttribute("knjiga", knjigaDao.get(Integer.parseInt(knjigaId)));
			request.setAttribute("kategorije",katDao.getAll() );
			request.getRequestDispatcher("/knjigaUpdate.jsp").forward(request, response);
		}else if(korId!=null){
			request.setAttribute("korisnik", korDao.get(Integer.parseInt(korId)));
			request.getRequestDispatcher("/korisnikUpdate.jsp").forward(request, response);	
		}else if(pId!=null){
			request.setAttribute("porudzbina", pDao.get(Integer.parseInt(pId)));
			request.getRequestDispatcher("/porudzbinaUpdate.jsp").forward(request, response);
			
		}
		
		else{
			request.getRequestDispatcher("/ReadController").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
