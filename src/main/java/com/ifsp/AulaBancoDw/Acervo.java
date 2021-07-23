package com.ifsp.AulaBancoDw;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Acervo {
		
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id_Disco;
	
	private String nomedoDisco;
	
	private String artista;
	
	private String genero;
	

	public long getId_disco() {
		return id_Disco;
	}

	public void setId_Disco(long id_Disco) {
		this.id_Disco = id_Disco;
	}
	
	public String getNomedoDisco() {
		return nomedoDisco;
	}

	public void setNomedoDisco(String NomedoDisco) {
		this.nomedoDisco = NomedoDisco;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String Artista) {
		this.artista = Artista;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String Genero) {
		this.genero = Genero;
	}

	/*	
	@Override
	public String toString() {
		return "Acervo [id_Disco=" + id_Disco + ", nomedoDisco=" + nomedoDisco + ", artista=" + artista + ", genero="
				+ genero + "]";
	}
	*/
	
}
