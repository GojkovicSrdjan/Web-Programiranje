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
 * Servlet implementation class UpdateControllerKorisnik
 */
@WebServlet("/UpdateControllerKorisnik")
public class UpdateControllerKorisnik extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateControllerKorisnik() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id=null;	
		String ime=null;
		String prezime=null;
		String korIme=null;
		String lozinka=null;
		Integer tipKor=null;
		
		if(request.getParameter("id")!=null)
			id=new Integer(request.getParameter("id"));
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
		if(id!=null){
			k.setKorisnikId(id);
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
			
			if(korDao.update(k)){
				System.out.println("Korisnik uspesno izmenjen!");
				response.sendRedirect("ReadControllerKorisnik");
			}
			else{
				System.out.println("Greska prilikom izmene korisnika!");
				response.sendRedirect("korisnikUpdate.jsp");
			}
			
		}else{
			response.sendRedirect("ReadControllerKorisnik");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
