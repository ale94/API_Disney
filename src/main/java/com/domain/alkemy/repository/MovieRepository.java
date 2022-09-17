package com.domain.alkemy.repository;

import com.domain.alkemy.models.Character;
import com.domain.alkemy.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(value = "SELECT m FROM Movie m WHERE m.titulo LIKE :title")
    List<Movie> findByTitle(@Param("title") String title);

    @Query(value = "SELECT m FROM Movie m ORDER BY m.fechaDeCreacion ASC")
    List<Movie> orderDateAsc();

    @Query(value = "SELECT m FROM Movie m ORDER BY m.fechaDeCreacion DESC")
    List<Movie> orderDateDesc();
}
