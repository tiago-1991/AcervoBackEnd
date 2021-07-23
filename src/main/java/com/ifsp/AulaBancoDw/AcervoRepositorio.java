package com.ifsp.AulaBancoDw;
import java.util.List;
import java.lang.String;
import org.springframework.data.repository.CrudRepository;




public interface AcervoRepositorio extends CrudRepository <Acervo, Long>{

	List<Acervo> findByArtista (String Artista);
	List <Acervo> findByNomedoDisco (String NomedoDisco);
	List<Acervo> findByGenero(String Genero);
	
	Acervo findById(long id_Disco);
}
