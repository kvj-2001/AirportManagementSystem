package com.VeeraJayathK.AMS_SpringBoot.services;

import java.util.List;
import java.util.Optional;

import com.VeeraJayathK.AMS_SpringBoot.entities.Pilot;

public interface PilotService {

	public List<Pilot> getPilots();
	public Pilot savePilot(Pilot Pilot);
	public Optional<Pilot> getPilot(long pid);
	public void deletePilot(long pid);
	public List<Pilot> noPlanePilots();
	public List<Object[]> allPilotPlane();
	public List<Pilot> getPilots(long planeId);

}
