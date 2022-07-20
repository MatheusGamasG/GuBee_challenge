package br.com.gubee.interview.core.features.hero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gubee.interview.core.model.CompareDTO;
import br.com.gubee.interview.core.model.Hero;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/")
public class HeroController {
	
	@Autowired
	private HeroService heroService;
		
	@GetMapping("/hero/{id}")
	public ResponseEntity<Hero> findHeroById(@PathVariable String id) {
		
		Hero hero = heroService.getHeroById(id);
		
		if(hero == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
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
	
	@GetMapping("/hero/compare")
	public ResponseEntity<CompareDTO> findHerosAndCompare(@RequestBody CompareDTO compare) {	
		try {
			return ResponseEntity.status(HttpStatus.OK).body(heroService.compareHeros(compare));	
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping("/hero")
	public ResponseEntity<Hero> createHero(@RequestBody Hero hero) {
		return ResponseEntity.status(HttpStatus.CREATED).body(heroService.createHero(hero));
	}
	
	@PutMapping("/hero/{id}")
	public ResponseEntity<Hero> updateHero(@PathVariable String id, @RequestBody Hero hero) {
		
		if(heroService.getHeroById(id) == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(heroService.updateHero(id, hero));		
	}
	
	@DeleteMapping("/hero/{id}")
	public ResponseEntity<String> deleteHero(@PathVariable String id) {
		
		boolean status;
		
		try {
			status = heroService.deleteHeroById(id);	
		} catch (Exception e) {
			status = false;
		}
		
		if(status) {
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}		
	}

}
