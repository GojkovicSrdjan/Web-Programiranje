package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.beans.Knjiga;
import model.beans.Stavka;
import model.dao.KnjigaDAO;

/**
 * Servlet implementation class ShoppingCartController
 */
@WebServlet("/ShoppingCartController")
public class ShoppingCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();

		Stavka s=new Stavka();
		KnjigaDAO knjigaDao=new KnjigaDAO();
		String knjigaId=request.getParameter("knjigaId");
		String stavkaIzKorpe=request.getParameter("stavka");
		String sveKnjige=request.getParameter("sveKnjige");
		
		List<String> kol=new ArrayList<String>();
		
		if(sveKnjige!=null){
			List<Stavka> korpa=(List<Stavka>)session.getAttribute("korpa");
		for (int i = 0; i < Integer.parseInt(sveKnjige); i++) {
			String novaKol=request.getParameter("kol"+ i);
			
			korpa.get(i).setKolicina(Integer.parseInt(novaKol));
			System.out.println(korpa.get(i).getKnjigaId());
			
		}
		//session.setAttribute("korpa", korpa);
		response.sendRedirect("ReadControllerShoppingCart");
		}
	
		if(knjigaId!=null){
		if(session.getAttribute("korpa")==null){
			//Knjiga k=knjigaDao.get(Integer.parseInt(knjigaId));
			List<Stavka> korpa=new ArrayList<Stavka>();
			//List<Knjiga> korpa=new ArrayList<Knjiga>();
			//korpa.add(k);
			s.setKnjigaId(Integer.parseInt(knjigaId));
			s.setKolicina(1);
			korpa.add(s);
			session.setAttribute("korpa", korpa);

			response.sendRedirect("ReadController");

		}else{
			/*List<Knjiga> korpa=(List<Knjiga>)session.getAttribute("korpa");
			Iterator<Knjiga> it=korpa.iterator();
			while(it.hasNext()){
				Knjiga knjiga=it.next();
				if(knjiga.getKnjigaId()==k.getKnjigaId()){
					System.out.println("Knjiga je vec dodata u korpu!");
					it.remove();
				}
			}
			System.out.println("");
			korpa.add(k);*/
			Knjiga k=knjigaDao.get(Integer.parseInt(knjigaId));
			List<Stavka> korpa=(List<Stavka>)session.getAttribute("korpa");
			Iterator<Stavka> it=korpa.iterator();
			while(it.hasNext()){
				Stavka stavka=it.next();
				if(stavka.getKnjigaId()==k.getKnjigaId()){
					System.out.println("Knjiga je vec dodata u korpu!");
					it.remove();
				}
			}
			s.setKnjigaId(k.getKnjigaId());
			s.setKolicina(1);
			System.out.println("");
			korpa.add(s);
			/*for (Knjiga knjiga : korpa) {
				System.out.println(knjiga.getNazivKnjige());
			}
			*/
			//session.setAttribute("korpa", korpa);

			response.sendRedirect("ReadController");
		}
		}
		
		if(stavkaIzKorpe!=null){
			List<Stavka> korpa=(List<Stavka>)session.getAttribute("korpa");
			Iterator<Stavka> it=korpa.iterator();
			while(it.hasNext()){
				Stavka stavka=it.next();
				if(stavka.getKnjigaId()==Integer.parseInt(stavkaIzKorpe))
					it.remove();
			
			}
			if(korpa.isEmpty()==true){
				session.removeAttribute("korpa");
				response.sendRedirect("ReadControllerShoppingCart");
			}else{
				//session.setAttribute("korpa", korpa);
				response.sendRedirect("ReadControllerShoppingCart");
			}
		}
			
			//request.setAttribute("knjiga", knjigaDao.get(Integer.parseInt(knjigaId)));
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
