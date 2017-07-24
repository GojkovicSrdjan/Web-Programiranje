package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.beans.Porudzbina;
import model.beans.Stavka;
import model.dao.PorudzbinaDAO;

/**
 * Servlet implementation class PorudzbinaContorller
 */
@WebServlet("/AddContorllerPorudzbina")
public class AddContorllerPorudzbina extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContorllerPorudzbina() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ime=null;
		String prezime=null;
		String adresa=null;
		Double iznos=null;
		
		HttpSession session=request.getSession();
		PorudzbinaDAO pDao=new PorudzbinaDAO();
		
		if(request.getParameter("ime")!=null)
			ime=request.getParameter("ime");
		if(request.getParameter("prezime")!=null)
			prezime=request.getParameter("prezime");
		if(request.getParameter("adresa")!=null)
			adresa=request.getParameter("adresa");
		if(request.getParameter("ukupanIznos")!=null)
			iznos=new Double(request.getParameter("ukupanIznos"));
		List<Stavka> knjige=(List<Stavka>)session.getAttribute("korpa");
		
		Porudzbina p=new Porudzbina();
		if(ime!=null)
			p.setKupacIme(ime);
		if(prezime!=null)
			p.setKupacPrezime(prezime);
		if(adresa!=null)
			p.setKupacAdresa(adresa);
		if(knjige!=null)
			p.setNaruceneKnjige(knjige);
		if(iznos!=null)
			p.setIznos(iznos);
		p.setStatus(1);
		pDao.add(p);
		session.removeAttribute("korpa");
		response.sendRedirect("ReadController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
