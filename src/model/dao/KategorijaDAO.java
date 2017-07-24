package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utils.QueryResultSupport;
import model.beans.Kategorija;
import model.beans.Knjiga;

public class KategorijaDAO extends BaseDAO implements CRUDDaoInterface<Kategorija,Integer> {
	
	public KategorijaDAO(){
		super();
		this.tableName="kategorija";
	}

	@Override
	public boolean add(Kategorija bean) {
		return false;
	}
	
	@Override
	public Kategorija get(Integer identifier) {
		return null;
	}
	
	@Override
	public boolean update(Kategorija bean) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean delete(Kategorija bean) {
		return false;
	}

	@Override
	public List<Kategorija> getList(String[] conditions) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Kategorija> getAll() {
		List<Kategorija> result=null;
		Connection conn=null;
		
		String sqlQuery="Select * From "+this.tableName;
		
		try {
			conn=ds.getConnection();
			PreparedStatement p=conn.prepareStatement(sqlQuery);
			ResultSet rs=p.executeQuery();
			while(rs.next()){
				if(result==null)
					result=new ArrayList<Kategorija>();
				Kategorija kat=new Kategorija(rs.getInt("id"), rs.getString("nazivKategorije"));
			result.add(kat);
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
		return (List<Kategorija>) result;
	}
	public List<Knjiga> getAllKnjige(Integer kategorijaId) {
		return null;
	}
}
