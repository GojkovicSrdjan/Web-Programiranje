package model.beans;

import java.io.Serializable;
import java.util.List;

import model.dao.KategorijaDAO;


public class Kategorija implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3794565087403556942L;


	private KategorijaDAO kategorijaDao=null;
	
	
	private Integer kategorijaId;
	private String nazivKategorije;
	private List<Knjiga> knjige;

	public Kategorija(Integer kategorijaId, String nazivKategorije) {
		super();
		this.kategorijaId = kategorijaId;
		this.nazivKategorije = nazivKategorije;
		this.knjige = null;
		this.kategorijaDao=null;
	}

	
	public Kategorija(String nazivKategorije) {
		super();
		this.kategorijaId = null;
		this.nazivKategorije = nazivKategorije;
		this.knjige = null;
		this.kategorijaDao=null;
	}
	
	public KategorijaDAO getKategorijaDao() {
		if(kategorijaDao==null)
			kategorijaDao=new KategorijaDAO();
		return kategorijaDao;
	}

	public void setKategorijaDao(KategorijaDAO kategorijaDao) {
		this.kategorijaDao = kategorijaDao;
	}

	public Integer getKategorijaId() {
		return kategorijaId;
	}

	public void setKategorijaId(Integer kategorijaId) {
		this.kategorijaId = kategorijaId;
	}

	public String getNazivKategorije() {
		return nazivKategorije;
	}

	public void setNazivKategorije(String nazivKategorije) {
		this.nazivKategorije = nazivKategorije;
	}

	public List<Knjiga> getKnjige() {
		return knjige;
	}

	public void setKnjige(List<Knjiga> knjige) {
		this.knjige = knjige;
	}
}
