package com.VeeraJayathK.AMS_SpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VeeraJayathK.AMS_SpringBoot.entities.Hangar;

@Repository("hangarRepository")
public interface HangarRepository extends JpaRepository<Hangar, Long>  {

}

