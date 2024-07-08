package com.VeeraJayathK.AMS_SpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VeeraJayathK.AMS_SpringBoot.entities.Admin;

@Repository("adminRepository")
public interface AdminRepository extends JpaRepository<Admin, String> {

}

