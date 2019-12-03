package org.hltic.sms_backend_rest.api.service;

import java.util.List;
import java.util.Optional;

import org.hltic.sms_backend_rest.api.domaine.models.Registration;
import org.springframework.stereotype.Service;

@Service
public interface RegistrationsServices {
	
	public Registration findByregisterRef(String registerRef);
	
	public Optional<Registration> findByidReg(Long id);
	
	List<Registration> getRegistrations();
	
	public Registration saveRegistrations(Registration registration);
	
	public Registration updateRegistrations(Registration registration);

	public void deleteRegistrations(Long idReg);

}
