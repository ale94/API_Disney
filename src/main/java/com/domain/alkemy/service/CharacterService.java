package com.domain.alkemy.service;

import com.domain.alkemy.models.Character;
import com.domain.alkemy.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService implements ICharacterService {

    @Autowired
    CharacterRepository characterRepository;

    @Override
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    @Override
    public Character getCharacter(Long id) {
        return characterRepository.findById(id).orElse(null);
    }

    @Override
    public void addCharacter(Character character) {
        characterRepository.save(character);
    }

    @Override
    public void editCharacter(Character character, Long id) {
        Character newCharacter = getCharacter(id);
        newCharacter.setImagen(character.getImagen());
        newCharacter.setNombre(character.getNombre());
        newCharacter.setEdad(character.getEdad());
        newCharacter.setPeso(character.getPeso());
        newCharacter.setHistoria(character.getHistoria());
        characterRepository.save(newCharacter);
    }

    @Override
    public void deleteCharacter(Long id) {
        characterRepository.deleteById(id);
    }

    @Override
    public List<Character> findByNameCharacter(String name) {
        return characterRepository.findByName(name);
    }

    @Override
    public List<Character> findByAgeCharacter(Integer edad) {
        return characterRepository.findByAge(edad);
    }


}
