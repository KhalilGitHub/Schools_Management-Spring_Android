package org.hltic.sms_backend_rest.api.service;

import java.util.List;
import java.util.Optional;

import org.hltic.sms_backend_rest.api.domaine.models.Registration;
import org.hltic.sms_backend_rest.api.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationsServicesImpl implements RegistrationsServices{

	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Override
	public Registration findByregisterRef(String registerRef) {
		
		return registrationRepository.findByregisterRef(registerRef);
	}

	@Override
	public Optional<Registration> findByidReg(Long id) {
		
		return registrationRepository.findByidReg(id);
	}

	@Override
	public List<Registration> getRegistrations() {
		
		return registrationRepository.findAll();
	}

	@Override
	public Registration saveRegistrations(Registration registration) {
		
		return registrationRepository.save(registration);
	}


	@Override
	public Registration updateRegistrations(Registration registration) {

		return registrationRepository.save(registration);
		
	}

	@Override
	public void deleteRegistrations(Long idReg) {

		registrationRepository.deleteById(idReg);
		
	}

	
}
