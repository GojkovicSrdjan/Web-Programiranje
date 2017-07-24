package model.beans;

import java.io.Serializable;

import model.dao.KorisnikDAO;

public class Korisnik implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6084481792628007257L;

	private KorisnikDAO korisnikDao=null;
	
	private Integer korisnikId;
	private String ime;
	private String prezime;
	private String korisnickoIme;
	private String lozinka;
	private Integer tipKorisnika;
	
	public Korisnik( String ime,
			String prezime, String korisnickoIme, String lozinka,
			Integer tipKorisnika) {
		super();
		this.korisnikDao = null;
		this.korisnikId = null;
		this.ime = ime;
		this.prezime = prezime;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.tipKorisnika = tipKorisnika;
	}
	
	public Korisnik(Integer korisnikId, String ime,
			String prezime, String korisnickoIme, String lozinka,
			Integer tipKorisnika) {
		super();
		this.korisnikDao = null;
		this.korisnikId = korisnikId;
		this.ime = ime;
		this.prezime = prezime;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.tipKorisnika = tipKorisnika;
	}

	public Korisnik(String ime,
			String prezime, String korisnickoIme, String lozinka) {
		super();
		this.korisnikDao = null;
		this.korisnikId = null;
		this.ime = ime;
		this.prezime = prezime;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.tipKorisnika = 2;
	}
	public Korisnik() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KorisnikDAO getKorisnikDao() {
		return korisnikDao;
	}

	public void setKorisnikDao(KorisnikDAO korisnikDao) {
		this.korisnikDao = korisnikDao;
	}

	public Integer getKorisnikId() {
		return korisnikId;
	}

	public void setKorisnikId(Integer korisnikId) {
		this.korisnikId = korisnikId;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public Integer getTipKorisnika() {
		return tipKorisnika;
	}

	public void setTipKorisnika(Integer tipKorisnika) {
		this.tipKorisnika = tipKorisnika;
	}

}
