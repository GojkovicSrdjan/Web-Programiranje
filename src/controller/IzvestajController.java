package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Porudzbina;
import model.dao.PorudzbinaDAO;

/**
 * Servlet implementation class IzvestajController
 */
@WebServlet("/IzvestajController")
public class IzvestajController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IzvestajController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PorudzbinaDAO pDao=new PorudzbinaDAO();
		String mesec=request.getParameter("mesec");
		List<Porudzbina>porudzbine=pDao.getAll();
		List<Porudzbina>porudzbinePoMesecu=new ArrayList<Porudzbina>();
		
		Calendar cal=Calendar.getInstance();
		
		if(mesec!=null){
			for (Porudzbina porudzbina : porudzbine) {
				cal.setTime(porudzbina.getDatum());
				if(cal.get(Calendar.MONTH)==Integer.parseInt(mesec)){
					porudzbinePoMesecu.add(porudzbina);
				}
			}
			request.setAttribute("porudzbine", porudzbinePoMesecu );
			request.getRequestDispatcher("/izvestaji.jsp").forward(request, response);
		}else{
			request.setAttribute("porudzbine", porudzbine );
			request.getRequestDispatcher("/izvestaji.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
