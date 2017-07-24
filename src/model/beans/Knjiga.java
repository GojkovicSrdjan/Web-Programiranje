package model.beans;

import java.io.Serializable;

import model.dao.KnjigaDAO;
import model.dao.KorisnikDAO;

public class Knjiga implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4089439270846536171L;

	private KnjigaDAO knjigaDao=null;
	
	private Integer knjigaId;
	private String nazivKnjige;
	private String izdavac;
	private String autor;//lista autora?
	private String godinaIzdanja;
	private String opis;
	private Integer kategorijaId;
	private Integer raspolozivaKolicina;
	private Double cena;
	private String slikaURL;

	private Boolean stanjeKnjige;


	public Knjiga(Integer knjigaId, String nazivKnjige, String izdavac,
			String autor, String godinaIzdanja, String opis,
			Integer kategorijaId, Integer raspolozivaKolicina, Double cena,
			String slikaURL, Boolean stanjeKnjige) {
		super();
		this.knjigaDao=null;
		this.knjigaId = knjigaId;
		this.nazivKnjige = nazivKnjige;
		this.izdavac = izdavac;
		this.autor = autor;
		this.godinaIzdanja = godinaIzdanja;
		this.opis = opis;
		this.kategorijaId = kategorijaId;
		this.raspolozivaKolicina = raspolozivaKolicina;
		this.cena = cena;
		this.slikaURL = slikaURL;
		this.stanjeKnjige = stanjeKnjige;
	}
	
	public Knjiga(String nazivKnjige, String izdavac,
			String autor, String godinaIzdanja, String opis, Integer kategorijaId,
			 Integer raspolozivaKolicina, Double cena) {
		super();
		this.knjigaDao=null;
		this.knjigaId = null;
		this.nazivKnjige = nazivKnjige;
		this.izdavac = izdavac;
		this.autor = autor;
		this.godinaIzdanja = godinaIzdanja;
		this.opis = opis;
		this.kategorijaId = kategorijaId;
		this.raspolozivaKolicina = raspolozivaKolicina;
		this.cena = cena;
		this.slikaURL = null;
		this.stanjeKnjige = true;
	}
	public Knjiga() {
		super();

	}

	public KnjigaDAO getKnjigaDao() {
		if(knjigaDao==null)
			knjigaDao=new KnjigaDAO();
		return knjigaDao;
	}

	public void setKnjigaDao(KnjigaDAO knjigaDao) {
		this.knjigaDao = knjigaDao;
	}

	public Integer getKnjigaId() {
		return knjigaId;
	}

	public void setKnjigaId(Integer knjigaId) {
		this.knjigaId = knjigaId;
	}

	public String getNazivKnjige() {
		return nazivKnjige;
	}

	public void setNazivKnjige(String nazivKnjige) {
		this.nazivKnjige = nazivKnjige;
	}

	public String getIzdavac() {
		return izdavac;
	}

	public void setIzdavac(String izdavac) {
		this.izdavac = izdavac;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGodinaIzdanja() {
		return godinaIzdanja;
	}

	public void setGodinaIzdanja(String godinaIzdanja) {
		this.godinaIzdanja = godinaIzdanja;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Integer getKategorijaId() {
		return kategorijaId;
	}

	public void setKategorijaId(Integer kategorijaId) {
		this.kategorijaId = kategorijaId;
	}

	public Integer getRaspolozivaKolicina() {
		return raspolozivaKolicina;
	}

	public void setRaspolozivaKolicina(Integer raspolozivaKolicina) {
		this.raspolozivaKolicina = raspolozivaKolicina;
	}

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}

	public String getSlikaURL() {
		return slikaURL;
	}

	public void setSlikaURL(String slikaURL) {
		this.slikaURL = slikaURL;
	}

	public Boolean getStanjeKnjige() {
		return stanjeKnjige;
	}

	public void setStanjeKnjige(Boolean stanjeKnjige) {
		this.stanjeKnjige = stanjeKnjige;
	}
	
}
