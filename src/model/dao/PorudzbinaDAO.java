package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utils.QueryResultSupport;
import model.beans.Porudzbina;
import model.beans.Stavka;


public class PorudzbinaDAO extends BaseDAO implements CRUDDaoInterface<Porudzbina,Integer>{
	
	public PorudzbinaDAO(){
		super();
		this.tableName="porudzbina";
	}
	
	@Override
	public boolean add(Porudzbina porudzbina) {
		boolean result = false;
		String sqlQuery = "INSERT INTO "+this.tableName;
			   sqlQuery+=" (kupac_ime, kupac_prezime, kupac_adresa, ukupan_iznos, porudzbina_status) ";
			   sqlQuery+=" VALUES (?,?,?,?,?) 	";
		if(this.lastQueryResult==null)
			lastQueryResult = new QueryResultSupport();
		if(porudzbina!=null && this.ds!=null){
			Connection conn = null;
			try{
				conn = ds.getConnection();
				PreparedStatement p = conn.prepareStatement(sqlQuery,Statement.RETURN_GENERATED_KEYS);
				p.setString(1, porudzbina.getKupacIme());
				p.setString(2, porudzbina.getKupacPrezime());
				p.setString(3, porudzbina.getKupacAdresa());
				p.setDouble(4, porudzbina.getIznos());
				p.setInt(5, porudzbina.getStatus());
				int affectedRows = p.executeUpdate();
				if(affectedRows>0){
					ResultSet rs = p.getGeneratedKeys();
				    if(rs.next()){
				    	int generatedId = rs.getInt(1);
				    	porudzbina.setPorudzbinaId(generatedId);
				    	result=true;
				    	this.lastQueryResult.setGeneratedId(generatedId);
				    }
				}
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
		
		result = false;
		sqlQuery=null;
		sqlQuery = "INSERT INTO Narucene_knjige ";
			   sqlQuery+=" (id_porudzbine, id_knjige, kolicina) ";
			   sqlQuery+=" VALUES (?,?,?) 	";
		if(this.lastQueryResult==null)
			lastQueryResult = new QueryResultSupport();
		if(porudzbina!=null && this.ds!=null){
			Connection conn = null;
			try{
				conn = ds.getConnection();
				PreparedStatement p = conn.prepareStatement(sqlQuery,Statement.RETURN_GENERATED_KEYS);
				for (int i = 0; i < porudzbina.getNaruceneKnjige().size(); i++) {
					p.setInt(1, porudzbina.getPorudzbinaId());
					//System.out.println(porudzbina.getPorudzbinaId());
					p.setInt(2, porudzbina.getNaruceneKnjige().get(i).getKnjigaId());
					//System.out.println(porudzbina.getNaruceneKnjige().get(i).getKnjiga().getKnjigaId());
					p.setInt(3, porudzbina.getNaruceneKnjige().get(i).getKolicina());
					//System.out.println(porudzbina.getNaruceneKnjige().get(i).getKolicina());
					
					int affectedRows = p.executeUpdate();
				}
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
	public Porudzbina get(Integer identifier) {
		Porudzbina result = null;
		Connection conn = null;
		
		String sqlQuery = "SELECT *  FROM "+this.tableName;
			sqlQuery+=" WHERE id=?";
		
		try{
			conn = ds.getConnection();
			PreparedStatement p = conn.prepareStatement(sqlQuery);
			p.setInt(1, identifier);
			ResultSet rs = p.executeQuery();
			if(rs.next())
				result=new Porudzbina(rs.getInt("id"), rs.getString("kupac_ime"),rs.getString("kupac_prezime"),
						rs.getString("kupac_adresa"), rs.getInt("porudzbina_status"), rs.getDate("datum"), rs.getDouble("ukupan_iznos"));
				
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
		
		///////////////////////////////////////////////
		
		
		sqlQuery = null;
		sqlQuery = "SELECT *  FROM narucene_knjige ";
		sqlQuery+=" WHERE id_porudzbine=?";
	
	try{
		conn = ds.getConnection();
		PreparedStatement p = conn.prepareStatement(sqlQuery);
		p.setInt(1, identifier);
		ResultSet rs = p.executeQuery();
		List<Stavka> stavke=new ArrayList<Stavka>();
		while(rs.next())
		{
			 Stavka st = new Stavka(rs.getInt("id_knjige"), rs.getInt("kolicina"));
			 stavke.add(st);
		}
		if(stavke!=null){
			result.setNaruceneKnjige(stavke);
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
	////////////////////////////////////////////////////
		
		return result;
	}
	
	@Override
	public boolean update(Porudzbina porudzbina) {
		boolean result = false;
		String sqlQuery = "Update "+this.tableName;
			   sqlQuery+=" Set porudzbina_status=? ";
			   sqlQuery+=" Where id=? ";
		if(this.lastQueryResult==null)
			lastQueryResult = new QueryResultSupport();
		if(porudzbina!=null && this.ds!=null){
			Connection conn = null;
			try{
				conn = ds.getConnection();
				PreparedStatement p = conn.prepareStatement(sqlQuery,Statement.RETURN_GENERATED_KEYS);
				p.setInt(1, porudzbina.getStatus());
				p.setInt(2, porudzbina.getPorudzbinaId());
				int affectedRows = p.executeUpdate();
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
	public boolean delete(Porudzbina bean) {
		return false;
	}
	
	@Override
	public List<Porudzbina> getList(String[] conditions) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Porudzbina> getAll() {
		List<Porudzbina> result=null;
		Connection conn = null;
		
		String sqlQuery = "SELECT *  FROM "+this.tableName;
		
		try{
			conn = ds.getConnection();
			PreparedStatement p = conn.prepareStatement(sqlQuery);
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				if(result==null)
					result=new ArrayList<Porudzbina>();
				Porudzbina por=new Porudzbina(rs.getInt("id"), rs.getString("kupac_ime"),rs.getString("kupac_prezime"),
						rs.getString("kupac_adresa"), rs.getInt("porudzbina_status"), rs.getDate("datum"), rs.getDouble("ukupan_iznos"));
				result.add(por);
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
		
		sqlQuery=null;
		sqlQuery = "SELECT *  FROM narucene_knjige ";
		
		try{
			conn = ds.getConnection();
			PreparedStatement p = conn.prepareStatement(sqlQuery);
			ResultSet rs = p.executeQuery();
			//List<Stavka> stavke=new ArrayList<Stavka>();
			while(rs.next()){
				
				Stavka st = new Stavka(rs.getInt("id_knjige"), rs.getInt("kolicina"));
				
				for (Porudzbina porudzbina : result) {
					if(porudzbina.getPorudzbinaId()==rs.getInt("id_porudzbine")){
						if(porudzbina.getNaruceneKnjige()==null){
							List<Stavka> stavke=new ArrayList<Stavka>();
							stavke.add(st);
							porudzbina.setNaruceneKnjige(stavke);
						}else
							porudzbina.getNaruceneKnjige().add(st);
					}
				}
				
				//stavke.add(st);
				
	/*			for (Porudzbina por : result) {
					if(por.getPorudzbinaId()==rs.getInt("id_porudzbine"))
						por.setNaruceneKnjige(stavke);
					
				}*/
				
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
		
		return (List<Porudzbina>) result;
	}

	
	
}
