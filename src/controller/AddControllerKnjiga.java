package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Knjiga;
import model.dao.KnjigaDAO;


/**
 * Servlet implementation class AddControllerKnjiga
 */
@WebServlet("/AddControllerKnjiga")
public class AddControllerKnjiga extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddControllerKnjiga() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nazivKnjige=null;
		String izdavac=null;
		String autor=null;
		String godIzdanja=null;
		String opis=null;
		Integer kategorija=null;
		Integer kolicina=null;
		Double cena=null;
		String slika=null;

		
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
		slika=request.getParameter("slika");
		
		
		if(slika!=null)
			System.out.println(slika);
		String filePath=request.getServletContext().getRealPath("/")+"images/";
		File file=new File(filePath+slika);
		file.createNewFile();
		System.out.println(file);
		
		
		
		FileOutputStream os=new FileOutputStream(file);
		os.write(15555);
		os.flush();
		os.close();
		
		KnjigaDAO knjigaDao=new KnjigaDAO();
		Knjiga k=new Knjiga();
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
		
		if(knjigaDao.add(k))
			System.out.println("Uspesno dodata knjiga!");
		else
			System.out.println("Greska! Knjiga nije dodata!");
		
		response.sendRedirect("ReadController");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
