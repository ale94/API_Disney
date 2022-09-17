package com.domain.alkemy.controllers;

import com.domain.alkemy.models.Character;
import com.domain.alkemy.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CharacterController {

    @Autowired
    CharacterService personajeService;

    @GetMapping("/characters")
    public List<Character> getAllCharacters() {
        return personajeService.getAllCharacters();
    }

    @GetMapping("/characters/{id}")
    public Character getCharacter(@PathVariable Long id) {
        return personajeService.getCharacter(id);
    }

    @GetMapping(value = "/characters", params = "name")
    public List<Character> getByNameCharacter(@RequestParam String name) {
        return personajeService.findByNameCharacter(name);
    }

    @GetMapping(value = "/characters", params = "age")
    public List<Character> getByAgeCharacter(@RequestParam Integer age) {
        return personajeService.findByAgeCharacter(age);
    }

    @PostMapping("/characters")
    public Character addCharacter(@RequestBody Character character) {
        personajeService.addCharacter(character);
        return character;
    }

    @PutMapping("/characters/{id}")
    public Character editCharacter(@RequestBody Character character, @PathVariable Long id) {
        personajeService.editCharacter(character, id);
        return character;
    }

    @DeleteMapping("/characters/{id}")
    public String deleteCharacter(@PathVariable Long id) {
        personajeService.deleteCharacter(id);
        return "Personaje borrado con exito";
    }
}
