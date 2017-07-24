package controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.beans.Kategorija;
import model.beans.Knjiga;
import model.beans.Korisnik;
import model.beans.Porudzbina;
import model.dao.KategorijaDAO;
import model.dao.KnjigaDAO;
import model.dao.KorisnikDAO;
import model.dao.PorudzbinaDAO;
@WebServlet("/ReadControllerShoppingCart")
public class ReadControllerShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadControllerShoppingCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		KnjigaDAO knjigaDao = new KnjigaDAO();
		
		
		request.setAttribute("knjige", knjigaDao.getAll());
		request.getRequestDispatcher("/korpa.jsp").forward(request, response);

		/*HttpSession session=request.getSession();
		KnjigaDAO knjigaDao = new KnjigaDAO();
		List<Stavka> stavka=(List<Stavka>) session.getAttribute("korpa");
		List<Knjiga> knjige=new ArrayList<Knjiga>();
		for (Stavka s : stavka) {
			Knjiga k=knjigaDao.get(s.getKnjigaId());
			knjige.add(k);
		}
		request.setAttribute("knjige", knjige);
		getServletContext().getRequestDispatcher("/korpa.jsp").forward(request, response);*/

	}

}
