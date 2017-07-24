package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Knjiga;
import model.dao.KnjigaDAO;

/**
 * Servlet implementation class UpdateControllerKnjiga
 */
@WebServlet("/UpdateControllerKnjiga")
public class UpdateControllerKnjiga extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateControllerKnjiga() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer knjigaId=null;
		String nazivKnjige=null;
		String izdavac=null;
		String autor=null;
		String godIzdanja=null;
		String opis=null;
		Integer kategorija=null;
		Integer kolicina=null;
		Double cena=null;
		String slika=null;
		
		if (request.getParameter("id")!=null) {
			knjigaId=new Integer(request.getParameter("id"));
		}
		if (request.getParameter("naziv")!=null) {
			nazivKnjige=request.getParameter("naziv");
		}
		if (request.getParameter("izdavac")!=null) {
			izdavac=request.getParameter("izdavac");
		}
		if (request.getParameter("autor")!=null) {
			autor=request.getParameter("autor");
		}
		if (request.getParameter("godIzdanja")!=null) {
			godIzdanja=request.getParameter("godIzdanja");
		}
		if (request.getParameter("opis")!=null) {
			opis=request.getParameter("opis");
		}
		
		if (request.getParameter("kategorija")!=null) {
			kategorija=new Integer(request.getParameter("kategorija"));
		}
		if (request.getParameter("raspolozivaKolicina")!=null) {
			kolicina=new Integer(request.getParameter("raspolozivaKolicina"));
		}
		if (request.getParameter("cena")!=null) {
			cena=new Double(request.getParameter("cena"));
		}
		

		KnjigaDAO knjigaDao=new KnjigaDAO();
		
		if(knjigaId!=null){
			Knjiga k=new Knjiga();
			k.setKnjigaId(knjigaId);
			
			if(nazivKnjige!=null)
				k.setNazivKnjige(nazivKnjige);
			if(izdavac!=null)
				k.setIzdavac(izdavac);
			if(autor!=null)
				k.setAutor(autor);
			if(godIzdanja!=null)
				k.setGodinaIzdanja(godIzdanja);
			if(opis!=null)
				k.setOpis(opis);
			if(kategorija!=null)
				k.setKategorijaId(kategorija);
			if(kolicina!=null)
				k.setRaspolozivaKolicina(kolicina);
			if(cena!=null)
				k.setCena(cena);
			k.setStanjeKnjige(true);
			
			if(knjigaDao.update(k))
				System.out.println("Knjiga uspesno izmenjena!");
			else
				System.out.println("Greska prilikom izmene knjige!");
			
		}

		response.sendRedirect("ReadController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
