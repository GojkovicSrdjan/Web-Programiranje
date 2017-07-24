package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Korisnik;
import model.dao.KorisnikDAO;

/**
 * Servlet implementation class AddControllerKorisnik
 */
@WebServlet("/AddControllerKorisnik")
public class AddControllerKorisnik extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddControllerKorisnik() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String ime=null;
		String prezime=null;
		String korIme=null;
		String lozinka=null;
		Integer tipKor=null;
		
		
		if(request.getParameter("ime")!=null)
			ime=request.getParameter("ime");
		if(request.getParameter("prezime")!=null)
			prezime=request.getParameter("prezime");
		if(request.getParameter("korIme")!=null)
			korIme=request.getParameter("korIme");
		if(request.getParameter("lozinka")!=null)
			lozinka=request.getParameter("lozinka");
		
		if(request.getParameter("tip")!=null)
			tipKor=new Integer(request.getParameter("tip"));
		
		
		KorisnikDAO korDao=new KorisnikDAO();
		Korisnik k=new Korisnik();
		if(ime!=null)
			k.setIme(ime);
		if(prezime!=null)
			k.setPrezime(prezime);
		if(korIme!=null)
			k.setKorisnickoIme(korIme);
		if(lozinka!=null)
			k.setLozinka(lozinka);
		if(tipKor!=null)
			k.setTipKorisnika(tipKor);
		
		if(korDao.add(k)){
			System.out.println("Korisnik uspesno dodat!");
		response.sendRedirect("ReadControllerKorisnik");
		}
		else{
			System.out.println("Greska prilikom dodavanja korisnika!");
			response.sendRedirect("korisnikCreate.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
