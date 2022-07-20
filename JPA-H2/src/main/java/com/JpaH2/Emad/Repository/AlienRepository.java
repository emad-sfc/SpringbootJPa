package com.JpaH2.Emad.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.JpaH2.Emad.model.Alien;

public interface AlienRepository extends JpaRepository<Alien, Integer> {
	
 List<Alien> findByTech(String tech);
 
 List<Alien> findByaidGreaterThan(int id);

 @Query("from Alien where tech=?1 order by aname")
 List<Alien> findByTechSortedByName(String tech);
}
