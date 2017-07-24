package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Porudzbina;
import model.dao.PorudzbinaDAO;

/**
 * Servlet implementation class ReadControllerPorudzbina
 */
@WebServlet("/ReadControllerPorudzbina")
public class ReadControllerPorudzbina extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadControllerPorudzbina() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status=request.getParameter("status");

		
		PorudzbinaDAO pDao=new PorudzbinaDAO();
		List<Porudzbina>porudzbineStatus=new ArrayList<Porudzbina>();
		List<Porudzbina> porudzbine=pDao.getAll();
		if(status!=null){
		if(Integer.parseInt(status)==1){
			for (Porudzbina porudzbina : porudzbine) {
				if(porudzbina.getStatus().equals(Integer.parseInt(status))){		
					porudzbineStatus.add(porudzbina);
				}	
			}
			request.setAttribute("porudzbine", porudzbineStatus);
			request.getRequestDispatcher("/porudzbineRead.jsp").forward(request, response);
		}else if(Integer.parseInt(status)==2){
			for (Porudzbina porudzbina : porudzbine) {
				if(porudzbina.getStatus().equals(Integer.parseInt(status)))
					porudzbineStatus.add(porudzbina);
			}
			request.setAttribute("porudzbine", porudzbineStatus);
			request.getRequestDispatcher("/porudzbineRead.jsp").forward(request, response);
		}else if(Integer.parseInt(status)==3){
			for (Porudzbina porudzbina : porudzbine) {
				if(porudzbina.getStatus().equals(Integer.parseInt(status)))
					porudzbineStatus.add(porudzbina);
			}
			request.setAttribute("porudzbine", porudzbineStatus);
			request.getRequestDispatcher("/porudzbineRead.jsp").forward(request, response);
		}else if(Integer.parseInt(status)==4){
			for (Porudzbina porudzbina : porudzbine) {
				if(porudzbina.getStatus().equals(Integer.parseInt(status)))
					porudzbineStatus.add(porudzbina);
			}
			request.setAttribute("porudzbine", porudzbineStatus);
			request.getRequestDispatcher("/porudzbineRead.jsp").forward(request, response);
		}
		}
		else{
			request.setAttribute("porudzbine", pDao.getAll());
			request.getRequestDispatcher("/porudzbineRead.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
