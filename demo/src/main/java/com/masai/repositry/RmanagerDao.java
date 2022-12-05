package com.masai.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Reportingmanager;

@Repository
public interface RmanagerDao extends JpaRepository<Reportingmanager, Integer>{

}
