package com.devsuperior.exercicio_spring3.repositories;

import com.devsuperior.exercicio_spring3.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
