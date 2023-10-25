package com.example.stationski.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@ToString
@Table( name = "moniteur")
public class Moniteur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idMoniteur")
    private Integer idMoniteur; // Clé primaire
    private Long numMoniteur;
    private String nomM;
    private String prenomM;
    private LocalDate dateRecru;
    private float prime;

    public Moniteur( Integer idMoniteur,
    Long numMoniteur,
    String nomM,
    String prenomM,
    LocalDate dateRecru,
    float prime){
        this.idMoniteur = idMoniteur;
        this.numMoniteur = numMoniteur;
        this.nomM = nomM;
        this.prenomM = prenomM;
        this.dateRecru = dateRecru;
        this.prime = prime;
    }

    public Moniteur( Long numMoniteur,
                     String nomM,
                     String prenomM,
                     LocalDate dateRecru,
                     float prime){
        this.numMoniteur = numMoniteur;
        this.nomM = nomM;
        this.prenomM = prenomM;
        this.dateRecru = dateRecru;
        this.prime = prime;
    }
}
