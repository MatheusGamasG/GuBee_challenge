package br.com.gubee.interview.core.features.hero;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gubee.interview.core.model.Hero;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/")
public class HeroController {
	
	@Autowired
	private HeroService heroService;
		
	@GetMapping() 
	public String print() {
		return "Hello World!";
	}
	
	@GetMapping("/hero/{id}")
	public ResponseEntity<Hero> findHeroById(@PathVariable UUID id) {
		
		Hero hero = heroService.getHeroById(id);
		
		if(hero == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hero);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(hero);
	}
	
	@GetMapping("/hero")
	public ResponseEntity<Hero> findHeroByName(@RequestParam String name) {
		Hero hero = heroService.getHeroByName(name);
		
		if(hero == null) {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(hero);
	}
	
	@PostMapping("/hero")
	public ResponseEntity<Hero> createHero(@RequestBody Hero hero) {
		return ResponseEntity.status(HttpStatus.CREATED).body(heroService.createHero(hero));
	}
}
