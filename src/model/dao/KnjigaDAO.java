package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import utils.QueryResultSupport;
import model.beans.Knjiga;

public class KnjigaDAO extends BaseDAO implements CRUDDaoInterface<Knjiga, Integer>{
	
	public KnjigaDAO(){
		super();
		this.tableName="knjiga";
	}
	@Override
	public boolean add(Knjiga knjiga) {
		// TODO Auto-generated method stub
		boolean result=false;
		String sqlQuery="Insert into " +this.tableName;
		sqlQuery+="(knjiga_naziv, knjiga_izdavac, knjiga_autor, knjiga_godina_izdanja, knjiga_opis, knjiga_kategorija,"
				+ " knjiga_raspoloziva_kolicina, knjiga_cena, knjiga_slika_url, knjiga_stanje)";
		sqlQuery+="Values(?,?,?,?,?,?,?,?,?,?)";
		if(this.lastQueryResult==null)
			lastQueryResult=new QueryResultSupport();
		if(knjiga!=null && this.ds!=null){
			Connection conn=null;
			try{
				conn=ds.getConnection();
				PreparedStatement p=conn.prepareStatement(sqlQuery,Statement.RETURN_GENERATED_KEYS );
				p.setString(1, knjiga.getNazivKnjige());
				p.setString(2, knjiga.getIzdavac());
				p.setString(3, knjiga.getAutor());
				p.setString(4, knjiga.getGodinaIzdanja());
				p.setString(5, knjiga.getOpis());
				p.setInt(6, knjiga.getKategorijaId());
				p.setInt(7, knjiga.getRaspolozivaKolicina());
				p.setDouble(8, knjiga.getCena());
				if(knjiga.getSlikaURL()==null)
					p.setNull(9, Types.NULL);
				else
					p.setString(9, knjiga.getSlikaURL());
				p.setBoolean(10, knjiga.getStanjeKnjige());
				int affectedRows=p.executeUpdate();
				if(affectedRows>0){
					result=true;
					this.lastQueryResult.setSuccess(result);
					ResultSet rs=p.getGeneratedKeys();
					if(rs.next()){
						int generatedId=rs.getInt(1);
						this.lastQueryResult.setGeneratedId(generatedId);
						
					}
				}
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
	public Knjiga get(Integer identifier) {
		Knjiga result=null;
		Connection conn=null;
		
		String sqlQuery="Select * From "+this.tableName;
		sqlQuery+=" WHERE id=?";
		try{
			conn=ds.getConnection();
			PreparedStatement p=conn.prepareStatement(sqlQuery);
			p.setInt(1, identifier);
			ResultSet rs=p.executeQuery();
			if(rs.next())
				result=new Knjiga(rs.getInt("id"),rs.getString("knjiga_naziv"),rs.getString("knjiga_izdavac"),rs.getString("knjiga_autor"),
						rs.getString("knjiga_godina_izdanja"),rs.getString("knjiga_opis"),rs.getInt("knjiga_kategorija"),
						rs.getInt("knjiga_raspoloziva_kolicina"),rs.getDouble("knjiga_cena"),rs.getString("knjiga_slika_url"),rs.getBoolean("knjiga_stanje"));
		
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
	public boolean update(Knjiga knjiga) {
		boolean result=false;
		String sqlQuery="Update " +this.tableName;
		sqlQuery+=" Set knjiga_naziv=?, knjiga_izdavac=?, knjiga_autor=?,"
				+ " knjiga_godina_izdanja=?, knjiga_opis=?, knjiga_kategorija=?,"
				+ " knjiga_raspoloziva_kolicina=?, knjiga_cena=?, knjiga_slika_url=?, knjiga_stanje=? ";
		sqlQuery+=" Where id=?";
		if(this.lastQueryResult==null)
			lastQueryResult=new QueryResultSupport();
		if(knjiga!=null && this.ds!=null){
			Connection conn=null;
			try{
				conn=ds.getConnection();
				PreparedStatement p=conn.prepareStatement(sqlQuery,Statement.RETURN_GENERATED_KEYS );
				p.setString(1, knjiga.getNazivKnjige());
				p.setString(2, knjiga.getIzdavac());
				p.setString(3, knjiga.getAutor());
				p.setString(4, knjiga.getGodinaIzdanja());
				p.setString(5, knjiga.getOpis());
				p.setInt(6, knjiga.getKategorijaId());
				p.setInt(7, knjiga.getRaspolozivaKolicina());
				p.setDouble(8, knjiga.getCena());
				if(knjiga.getSlikaURL()==null)
					p.setNull(9, Types.NULL);
				else
					p.setString(9, knjiga.getSlikaURL());
				p.setBoolean(10, knjiga.getStanjeKnjige());
				p.setInt(11, knjiga.getKnjigaId());
				int affectedRows=p.executeUpdate();
				if(affectedRows>0){
					result=true;
					this.lastQueryResult.setSuccess(result);
					ResultSet rs=p.getGeneratedKeys();
					if(rs.next()){
						int generatedId=rs.getInt(1);
						this.lastQueryResult.setGeneratedId(generatedId);
						
					}
				}
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
	public boolean delete(Knjiga knjiga) {
		return false;
		
	}
	
	@Override
	public List<Knjiga> getList(String[] conditions) {
		List<Knjiga>result=null;
		Connection conn=null;
		String sqlQuery = "SELECT * FROM "+this.tableName;
		if(conditions!=null && conditions.length>0){
			sqlQuery+="Where";
			int coutner=0;
			for(String cond:conditions){
				if(coutner>0) sqlQuery+="And";
				sqlQuery+=cond;
				coutner++;
			}
			try{
				conn=ds.getConnection();
				Statement st=conn.createStatement();
				ResultSet rs=st.executeQuery(sqlQuery);
				while(rs.next()){
					if(result==null)
						result=new ArrayList<Knjiga>();
					Knjiga knjiga=new Knjiga(rs.getInt("id"),rs.getString("knjiga_naziv"),rs.getString("knjiga_izdavac"),rs.getString("knjiga_autor"),
						rs.getString("knjiga_godina_izdanja"),rs.getString("knjiga_opis"),rs.getInt("knjiga_kategorija"),
						rs.getInt("knjiga_raspoloziva_kolicina"),rs.getDouble("knjiga_cena"),rs.getString("knjiga_slika_url"),rs.getBoolean("knjiga_stanje"));
					result.add(knjiga);
				}
				st.close();
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
		}
		return result;
	}
	
@Override
	public List<Knjiga> getAll() {
	List<Knjiga> result=null;
	Connection conn=null;
	
	String sqlQuery="Select * From "+this.tableName+" order by id desc";
	
	try{
		conn=ds.getConnection();
		PreparedStatement p=conn.prepareStatement(sqlQuery);
		ResultSet rs=p.executeQuery();
		while(rs.next()) {
			if(result==null)
				result=new ArrayList<Knjiga>();
		 Knjiga k = new Knjiga(rs.getInt("id"),rs.getString("knjiga_naziv"),rs.getString("knjiga_izdavac"),rs.getString("knjiga_autor"),
					rs.getString("knjiga_godina_izdanja"),rs.getString("knjiga_opis"),rs.getInt("knjiga_kategorija"),
					rs.getInt("knjiga_raspoloziva_kolicina"),rs.getDouble("knjiga_cena"),rs.getString("knjiga_slika_url"),rs.getBoolean("knjiga_stanje"));
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
	return (List<Knjiga>) result;
	}

}
