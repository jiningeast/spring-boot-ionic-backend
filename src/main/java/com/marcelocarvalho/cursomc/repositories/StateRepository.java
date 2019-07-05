package com.marcelocarvalho.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcelocarvalho.cursomc.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer > {

}
