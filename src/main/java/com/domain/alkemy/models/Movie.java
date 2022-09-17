package com.domain.alkemy.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pelicula")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String imagen;
    private String titulo;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date fechaDeCreacion;
    private int calificacion;

    @ManyToMany(mappedBy = "movies")
    private List<Character> characters;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "genero_id")
    private Gender gender;
}
