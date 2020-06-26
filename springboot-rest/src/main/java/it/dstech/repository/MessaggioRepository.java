package it.dstech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.dstech.model.Messaggio;

public interface MessaggioRepository extends JpaRepository<Messaggio, Long>{

}
