package com.domain.alkemy.repository;

import com.domain.alkemy.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
    @Query(value = "SELECT c FROM Character c WHERE c.nombre LIKE :name")
    List<Character> findByName(@Param("name") String name);

    @Query(value = "SELECT c FROM Character c WHERE c.edad  LIKE :age")
    List<Character> findByAge(@Param("age") Integer age);

}
