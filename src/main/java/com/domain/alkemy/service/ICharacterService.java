package com.domain.alkemy.service;

import com.domain.alkemy.models.Character;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ICharacterService {
    public List<Character> getAllCharacters();
    public Character getCharacter(Long id);
    public void addCharacter(Character character);
    public void editCharacter(Character character, Long id);
    public void deleteCharacter(Long id);
    public List<Character> findByNameCharacter(String name);
    public List<Character> findByAgeCharacter(Integer edad);
}
