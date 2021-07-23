package com.ifsp.AulaBancoDw;


import java.util.List;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;


import org.aspectj.apache.bcel.classfile.Module.Require;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/discografia")
@CrossOrigin(origins="http://localhost:3000")
public class AcervoController {

	@Autowired
	private AcervoRepositorio repositorio;
/*	
	@PostMapping(path="/add")
	public @ResponseBody String novoDisco (@RequestParam String nomedoDisco, 
		   @RequestParam String artista, @RequestParam String genero) {
		
		Acervo disco = new Acervo();
		disco.setNomedoDisco(nomedoDisco);
		disco.setArtista(artista);
		disco.setGenero(genero);
		repositorio.save(disco);
		return "Valores salvos com sucesso";
	}
	*/
	@PostMapping(path="/novoDisco")
	public @ResponseBody String novoDisco(@RequestBody Acervo Acervo) {
		repositorio.save(Acervo);
		return "Novo Disco Inserido";
	}
	
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Acervo> retornaTodos(){
		
		return repositorio.findAll();
	}
	/*
	@GetMapping(path="/disco")
	public @ResponseBody Optional<Acervo> retornaDisco(@RequestParam String id_Disco){
		
		return repositorio.findById(Long.parseLong(id_Disco));
	}
	*/
	@GetMapping(path="/disco/{id_Disco}")
	public @ResponseBody Optional<Acervo> retornaDisco2 (@PathVariable(required=true, name="id_Disco") Long id_Disco){
		return repositorio.findById((id_Disco));
	}
	
	@DeleteMapping(path="/delete/{id_Disco}")
	public @ResponseBody String deleteDisco (@PathVariable(required = true, name="id_Disco") Long id_Disco) {
		Optional<Acervo> disco = repositorio.findById(id_Disco);
		if(disco.isPresent()) {
			repositorio.delete(disco.get());
			return "Disco Deletado com Sucesso"; 
		}
		return "Disco Não Encontrado";
	}
	/*
	@PutMapping(path="update/{id_Disco}")
	public @ResponseBody Optional<Acervo> updateDisco(@PathVariable(required=true, name="id_Disco") Long id_Disco,
			@RequestBody Acervo acervo){
			Optional <Acervo> a = repositorio.findById(id_Disco);
			if(a.isPresent()) {
				a.get().setNomedoDisco(acervo.getNomedoDisco());
				a.get().setArtista(acervo.getArtista());
				a.get().setGenero(acervo.getGenero());
				repositorio.save(a.get());
				return a;
		
			}
			
	return null;		
	}
	*/
	//Upgrade por status
	  @PutMapping(path="/update/{id_Disco}")
	  public @ResponseBody ResponseEntity<Acervo> alteraDisco(@PathVariable(required=true, name="id_Disco") Long id_Disco,
	  @RequestBody Acervo acervo){
	  		Optional <Acervo> a = repositorio.findById(id_Disco);
	  		if	(a.isPresent()){
	  			a.get().setNomedoDisco(acervo.getNomedoDisco());
	  			a.get().setArtista(acervo.getArtista());
	  			a.get().setGenero(acervo.getGenero());
	  			return ResponseEntity.ok(repositorio.save(a.get()));
	  		}
	  return ResponseEntity.status(404).build();
	 
	 }
	  
	 //find by campo 
	  
	  @GetMapping(path="locate_disco/{id_Disco}") 
		 public @ResponseBody Optional <Acervo> retornaDisco (@PathVariable(required=true, name="NomedoDisco")Long id_Disco){
			 return repositorio.findById(id_Disco);
		 }
		 
	 
	 @GetMapping(path="locate_nomedoDisco/{NomedoDisco}") 
	 public @ResponseBody List<Acervo> locateByNomedoDisco(@PathVariable(required=true, name="NomedoDisco")String NomedoDisco){
		 return repositorio.findByNomedoDisco(NomedoDisco);
	 }
	 
	  
	 @GetMapping(path="locate_artista/{Artista}")
	 public @ResponseBody List<Acervo> locateByArtista(@PathVariable(required=true, name="Artista")String Artista){
		 return repositorio.findByArtista(Artista);
	 }
	 
	
	 @GetMapping(path="locate_genero/{Genero}")
	 public @ResponseBody List<Acervo> locateByGenero(@PathVariable(required=true, name="Genero")String Genero){
		 return repositorio.findByGenero(Genero);
	 }
}
