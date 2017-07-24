package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Knjiga;
import model.beans.Porudzbina;
import model.beans.Stavka;
import model.dao.KnjigaDAO;
import model.dao.PorudzbinaDAO;

/**
 * Servlet implementation class UpdateControllerPorudzbina
 */
@WebServlet("/UpdateControllerPorudzbina")
public class UpdateControllerPorudzbina extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateControllerPorudzbina() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer pId=null;
		Integer status=null;
		
		if(request.getParameter("pId")!=null)
			pId=new Integer(request.getParameter("pId"));
		if(request.getParameter("status")!=null)
			status=new Integer(request.getParameter("status"));
		
		PorudzbinaDAO pDao=new PorudzbinaDAO();
		Porudzbina p=new Porudzbina();
		KnjigaDAO kDao=new KnjigaDAO();
		
		Porudzbina por= pDao.get(pId);
		

		p.setPorudzbinaId(pId);
		if(status==2){
			
			for (Stavka s : por.getNaruceneKnjige()) {
				Knjiga k=kDao.get(s.getKnjigaId());
				System.out.println("Prvobitna kolicina " + k.getRaspolozivaKolicina());
				if(k.getRaspolozivaKolicina()!=0){
					k.setRaspolozivaKolicina(k.getRaspolozivaKolicina()-s.getKolicina());
					kDao.update(k);
					System.out.println("Kolicina posle isporuke " + k.getRaspolozivaKolicina());
					
				}
				else{
					p.setStatus(4);
					pDao.update(p);
				}
				
				
			}
			if(p.getStatus()==null){
				p.setStatus(status);
				pDao.update(p);
				response.sendRedirect("ReadControllerPorudzbina");
			}else
				response.sendRedirect("ReadControllerPorudzbina");
			
			
		}else{
			p.setStatus(status);
			pDao.update(p);
			response.sendRedirect("ReadControllerPorudzbina");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
