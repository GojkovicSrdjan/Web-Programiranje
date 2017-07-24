package model.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import model.dao.PorudzbinaDAO;

public class Porudzbina implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 887449588353263221L;

	private PorudzbinaDAO porudzbinaDao=null;
	
	private Integer porudzbinaId;
	
	private String kupacIme;
	private String kupacPrezime;
	private String kupacAdresa;
	private Integer status;
	private Date datum;
	private Double iznos;
	
	private List<Stavka> naruceneKnjige;

	public Porudzbina(Integer porudzbinaId, String kupacIme,
			String kupacPrezime, String kupacAdresa, Integer status, Date datum,
			Double iznos
			) {
		super();
		this.porudzbinaDao= null;
		this.porudzbinaId = porudzbinaId;
		this.kupacIme = kupacIme;
		this.kupacPrezime = kupacPrezime;
		this.kupacAdresa = kupacAdresa;
		this.status = status;
		this.datum=datum;
		this.iznos=iznos;
		this.naruceneKnjige = null;
	}

	
	public Porudzbina(String kupacIme,
			String kupacPrezime, String kupacAdresa) {
		super();
		this.porudzbinaDao= null;
		this.porudzbinaId = null;
		this.kupacIme = kupacIme;
		this.kupacPrezime = kupacPrezime;
		this.kupacAdresa = kupacAdresa;
		this.status = 1;
	}
	
	public Porudzbina() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public PorudzbinaDAO getPorudzbinaDao() {
		return porudzbinaDao;
	}


	public void setPorudzbinaDao(PorudzbinaDAO porudzbinaDao) {
		this.porudzbinaDao = porudzbinaDao;
	}


	public Integer getPorudzbinaId() {
		return porudzbinaId;
	}


	public void setPorudzbinaId(Integer porudzbinaId) {
		this.porudzbinaId = porudzbinaId;
	}


	public String getKupacIme() {
		return kupacIme;
	}


	public void setKupacIme(String kupacIme) {
		this.kupacIme = kupacIme;
	}


	public String getKupacPrezime() {
		return kupacPrezime;
	}


	public void setKupacPrezime(String kupacPrezime) {
		this.kupacPrezime = kupacPrezime;
	}


	public String getKupacAdresa() {
		return kupacAdresa;
	}


	public void setKupacAdresa(String kupacAdresa) {
		this.kupacAdresa = kupacAdresa;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public List<Stavka> getNaruceneKnjige() {
		return naruceneKnjige;
	}


	public void setNaruceneKnjige(List<Stavka> naruceneKnjige) {
		this.naruceneKnjige = naruceneKnjige;
	}


	public Double getIznos() {
		return iznos;
	}


	public void setIznos(Double iznos) {
		this.iznos = iznos;
	}


	public Date getDatum() {
		return datum;
	}


	public void setDatum(Date datum) {
		this.datum = datum;
	}
}
