package org.hltic.sms_backend_rest.api.repository;

import java.util.Optional;

import org.hltic.sms_backend_rest.api.domaine.models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RegistrationRepository extends JpaRepository<Registration, Long>{
	
	public Registration findByregisterRef(String registerRef);
	
	public Optional<Registration> findByidReg(Long id);

}
