package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import utils.QueryResultSupport;
import model.beans.Korisnik;



public class KorisnikDAO extends BaseDAO implements CRUDDaoInterface<Korisnik,Integer> {

	public KorisnikDAO(){
		super();
		this.tableName="korisnik";
	}
	
	@Override
	public boolean add(Korisnik korisnik) {
		boolean result = false;
		String sqlQuery = "INSERT INTO "+this.tableName;
			   sqlQuery+=" (ime, prezime,korisnicko_ime, lozinka, tip_korisnika) ";
			   sqlQuery+=" VALUES (?,?,?,?,?)";
		if(this.lastQueryResult==null)
			lastQueryResult = new QueryResultSupport();
		if(korisnik!=null && this.ds!=null){
			Connection conn = null;
			try{
				conn = ds.getConnection();
				PreparedStatement p = conn.prepareStatement(sqlQuery);
				p.setString(1, korisnik.getIme());
				p.setString(2, korisnik.getPrezime());
				p.setString(3, korisnik.getKorisnickoIme());
				p.setString(4, korisnik.getLozinka());
				p.setInt(5, korisnik.getTipKorisnika());
				int affectedRows = p.executeUpdate();
				if(affectedRows>0)
					result=true;
				this.lastQueryResult.setSuccess(result);
				if(!result)
					this.lastQueryResult.setErrorMsg("DB error");
				p.close();
				conn.close();
			}catch(Exception ex){
				this.lastQueryResult.setErrorMsg(ex.getMessage());
			}finally{
				if(conn!=null){
					try{
						conn.close();
					}catch(Exception ex1){
						ex1.printStackTrace();
					}
				}
			}
		}
		return result;
	}
	
	@Override
	public Korisnik get(Integer identifier) {
		Korisnik result = null;
		Connection conn = null;
		
		String sqlQuery = "SELECT *  FROM "+this.tableName;
			sqlQuery+=" WHERE id=?";
		
		try{
			conn = ds.getConnection();
			PreparedStatement p = conn.prepareStatement(sqlQuery);
			p.setInt(1, identifier);
			ResultSet rs = p.executeQuery();
			if(rs.next())
				result=new Korisnik(rs.getInt("id"),rs.getString("ime"),rs.getString("prezime"),rs.getString("korisnicko_ime"),
								rs.getString("lozinka"),rs.getInt("tip_korisnika"));
				
			p.close();
			conn.close();
		}catch(Exception ex){
			if(this.lastQueryResult==null)
				this.lastQueryResult = new QueryResultSupport();
			this.lastQueryResult.setErrorMsg(ex.getMessage());
		}finally{
			if(conn!=null){
				try{
					conn.close();
				}catch(Exception ex1){
					ex1.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public boolean update(Korisnik korisnik) {
		boolean result = false;
		String sqlQuery = "Update "+this.tableName;
			   sqlQuery+=" Set ime=?, prezime=?,korisnicko_ime=?, lozinka=?, tip_korisnika=? ";
			   sqlQuery+=" where id=?";
		if(this.lastQueryResult==null)
			lastQueryResult = new QueryResultSupport();
		if(korisnik!=null && this.ds!=null){
			Connection conn = null;
			try{
				conn = ds.getConnection();
				PreparedStatement p = conn.prepareStatement(sqlQuery);
				p.setString(1, korisnik.getIme());
				p.setString(2, korisnik.getPrezime());
				p.setString(3, korisnik.getKorisnickoIme());
				p.setString(4, korisnik.getLozinka());
				p.setInt(5, korisnik.getTipKorisnika());
				p.setInt(6, korisnik.getKorisnikId());
				int affectedRows = p.executeUpdate();
				if(affectedRows>0)
					result=true;
				this.lastQueryResult.setSuccess(result);
				if(!result)
					this.lastQueryResult.setErrorMsg("DB error");
				p.close();
				conn.close();
			}catch(Exception ex){
				this.lastQueryResult.setErrorMsg(ex.getMessage());
			}finally{
				if(conn!=null){
					try{
						conn.close();
					}catch(Exception ex1){
						ex1.printStackTrace();
					}
				}
			}
		}
		return result;
	}
	
	@Override
	public boolean delete(Korisnik korisnik) {
		boolean result = false;
		String sqlQuery = "DELETE FROM "+this.tableName;
			   sqlQuery+=" WHERE korisnicko_ime=?";
			   
		if(this.lastQueryResult==null)
			lastQueryResult = new QueryResultSupport();
		if(korisnik!=null && this.ds!=null){
			Connection conn = null;
			try{
				conn = ds.getConnection();
				PreparedStatement p = conn.prepareStatement(sqlQuery);
				p.setString(1, korisnik.getKorisnickoIme());
				int affectedRows = p.executeUpdate();
				if(affectedRows>0)
					result=true;
				this.lastQueryResult.setSuccess(result);
				
				if(!result)
					this.lastQueryResult.setErrorMsg("DB User delete error");
				p.close();
				conn.close();
			}catch(Exception ex){
				this.lastQueryResult.setErrorMsg(ex.getMessage());
			}finally{
				if(conn!=null){
					try{
						conn.close();
					}catch(Exception ex1){
						ex1.printStackTrace();
					}
				}
			}
		}
		return result;
	}

	@Override
	public List<Korisnik> getList(String[] conditions) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Korisnik> getAll() {
		List<Korisnik> result = null;
		Connection conn = null;
		
		String sqlQuery = "SELECT *  FROM "+this.tableName;
			
		
		try{
			conn = ds.getConnection();
			PreparedStatement p = conn.prepareStatement(sqlQuery);
			//p.setInt(1, identifier);
			ResultSet rs = p.executeQuery();
			while(rs.next()){
			if(result==null)
				result=new ArrayList<Korisnik>();
			Korisnik k=new Korisnik(rs.getInt("id"),rs.getString("ime"),rs.getString("prezime"),rs.getString("korisnicko_ime"),
								rs.getString("lozinka"),rs.getInt("tip_korisnika"));
			result.add(k);
			}
			p.close();
			conn.close();
		}catch(Exception ex){
			if(this.lastQueryResult==null)
				this.lastQueryResult = new QueryResultSupport();
			this.lastQueryResult.setErrorMsg(ex.getMessage());
		}finally{
			if(conn!=null){
				try{
					conn.close();
				}catch(Exception ex1){
					ex1.printStackTrace();
				}
			}
		}
		return(List<Korisnik>) result;
	}
	
	public Korisnik get(String korIme, String lozinka){
		//vraca usera, ako postoji, koji koristi dati username i password
		
		Korisnik result = null;
		Connection conn = null;
		
		String sqlQuery = "SELECT ime, prezime, korisnicko_ime, lozinka, tip_korisnika ";
			sqlQuery+=" FROM "+this.tableName;
			sqlQuery+=" WHERE korisnicko_ime=? AND lozinka=? ";
		
		try{
			conn = ds.getConnection();
			PreparedStatement p = conn.prepareStatement(sqlQuery);
			p.setString(1, korIme);
			p.setString(2, lozinka);
			ResultSet rs = p.executeQuery();
			if(rs.next())
				result=new Korisnik(rs.getString("korisnicko_ime"),
						rs.getString("lozinka"),rs.getString("ime"),rs.getString("prezime"),rs.getInt("tip_korisnika"));
				
			p.close();
			conn.close();
		}catch(Exception ex){
			this.lastQueryResult = new QueryResultSupport();
			this.lastQueryResult.setErrorMsg(ex.getMessage());
		}finally{
			if(conn!=null){
				try{
					conn.close();
				}catch(Exception ex1){
					ex1.printStackTrace();
				}
			}
		}
		return result;
	}
}
