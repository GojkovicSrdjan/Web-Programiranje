package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Kategorija;
import model.beans.Knjiga;
import model.dao.KategorijaDAO;
import model.dao.KnjigaDAO;


public class ReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		KnjigaDAO knjigaDao = new KnjigaDAO();
		
		List<Knjiga> knjige=new ArrayList<Knjiga>();
		
		KategorijaDAO katDao=new KategorijaDAO();
		String knjigaId=request.getParameter("knjigaId");
		String katId=request.getParameter("kategorijaId");
		List<Kategorija>k=katDao.getAll();
		
		
		
		
		if(katId!=null){
			for (Knjiga knjiga : knjigaDao.getAll()) {
				if(knjiga.getKategorijaId()==Integer.parseInt(katId))
					knjige.add(knjiga);
			}
			request.setAttribute("kategorije", k);
			request.setAttribute("knjige", knjige);
			request.getRequestDispatcher("/knjigeRead.jsp").forward(request, response);
			
		}else if(knjigaId!=null){
			request.setAttribute("knjiga", knjigaDao.get(Integer.parseInt(knjigaId)));
			request.getRequestDispatcher("/knjiga.jsp").forward(request, response);
			
		}
		
		else{
			for (Knjiga knjiga : knjigaDao.getAll()) {
				if (knjiga.getStanjeKnjige()==true) {
					knjige.add(knjiga);
				}
			}
			request.setAttribute("kategorije", k);
			request.setAttribute("knjige", knjige);
			request.getRequestDispatcher("/knjigeRead.jsp").forward(request, response);
		}
		
		
		
		
/*		Kategorija kat=new Kategorija("Komedija");
		KategorijaDAO katDao=new KategorijaDAO();
		if(katDao.add(kat))
			response.getWriter().println("Uspesno upisana knjiga u bazu");
		else
			response.getWriter().println("GRESKA PRI UPISU U BAZU: "+katDao.getLastQueryResult().getErrorMsg());
		
*/
/*		Korisnik kor=new Korisnik("pera", "simic", "pera", "pass");
		KorisnikDAO korisnikDao=new KorisnikDAO();
		if(korisnikDao.add(kor)){

			response.getWriter().println("Uspesno upisana knjiga u bazu");
		}else{
			response.getWriter().println("GRESKA PRI UPISU U BAZU: "+korisnikDao.getLastQueryResult().getErrorMsg());
		}*/
		
		
/*		Knjiga knjiga=new Knjiga("Ana Karenjina", "Svetlost", "Lav Nikolajevic Tolstoj", "1988", "Opis", 34, 800.00);
		KnjigaDAO knjigaDao=new KnjigaDAO();
		if(knjigaDao.add(knjiga)){

			response.getWriter().println("Uspesno upisana knjiga u bazu");
		}else{
			response.getWriter().println("GRESKA PRI UPISU U BAZU: "+knjigaDao.getLastQueryResult().getErrorMsg());
		}
		*/
	}

}
