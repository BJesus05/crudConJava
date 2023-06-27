package com.crudV2.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crudV2.modelo.Existencia;

@Repository
public interface InterfaceExistencias extends CrudRepository<Existencia,Integer>{

}
