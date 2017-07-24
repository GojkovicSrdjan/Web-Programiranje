package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.beans.Korisnik;
import model.dao.KorisnikDAO;

/**
 * Servlet implementation class LoginContorller
 */
@WebServlet("/LoginContorller")
public class LoginContorller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginContorller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String korIme=request.getParameter("username");
		String pass=request.getParameter("password");
		
		if((korIme==null || korIme.equals("")) && (pass==null || pass.equals(""))){
			response.sendRedirect("ReadController");
		}
		
		KorisnikDAO korDao=new KorisnikDAO();
		
		Korisnik k=korDao.get(korIme, pass);
		if(k!=null){
			HttpSession session = request.getSession(true);
			if(k.getTipKorisnika()==1){
				session.setAttribute("poslovodja", k);
			}else if(k.getTipKorisnika()==2){
				session.setAttribute("admin", k);
			}response.sendRedirect("ReadController");

		}else{
			response.sendRedirect("ReadController");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		
	}

}
