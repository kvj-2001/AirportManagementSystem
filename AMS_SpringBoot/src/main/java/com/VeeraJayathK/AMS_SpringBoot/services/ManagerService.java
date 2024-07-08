package com.VeeraJayathK.AMS_SpringBoot.services;

import java.util.List;
import java.util.Optional;

import com.VeeraJayathK.AMS_SpringBoot.entities.Manager;

public interface ManagerService {

	public List<Manager> NotApprovedManagers();
	public Manager saveManager(Manager manager);
	public Optional<Manager> getManager(String managerId);
	public void deleteManager(String managerId);
	public List<Manager> getManagers();
}
