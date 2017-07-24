package model.beans;

public class Stavka {
	
	private Integer knjigaId;
	private Integer kolicina;
	
	
	public Stavka(Integer knjigaId, Integer kolicina) {
		super();
		this.knjigaId = knjigaId;
		this.kolicina = kolicina;
	}

	public Stavka() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getKnjigaId() {
		return knjigaId;
	}
	public void setKnjigaId(Integer knjigaId) {
		this.knjigaId = knjigaId;
	}
	public Integer getKolicina() {
		return kolicina;
	}
	public void setKolicina(Integer kolicina) {
		this.kolicina = kolicina;
	}
	

}
