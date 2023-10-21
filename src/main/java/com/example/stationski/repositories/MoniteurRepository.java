package com.example.stationski.repositories;

import com.example.stationski.entities.Moniteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MoniteurRepository extends JpaRepository<Moniteur,Integer> {

}
