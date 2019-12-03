package org.hltic.sms_backend_rest.api.rest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.hltic.sms_backend_rest.api.domaine.dto.RegistrationDto;
import org.hltic.sms_backend_rest.api.domaine.dto.Response;
import org.hltic.sms_backend_rest.api.domaine.dto.StudentDto;
import org.hltic.sms_backend_rest.api.domaine.models.Registration;
import org.hltic.sms_backend_rest.api.domaine.models.Student;
import org.hltic.sms_backend_rest.api.service.RegistrationsServices;
import org.hltic.sms_backend_rest.api.utilities.utils.Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/registration/api")
@Api(tags = "registrations")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {
	
	@Autowired
	private  RegistrationsServices registrationService;
	
	@Autowired
	ServletContext context;
	
	@GetMapping(value="/registrations", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RegistrationDto>>getregistrationsDto(){
		 
		List<Registration> registrations = registrationService.getRegistrations();
		
		List<RegistrationDto> lRegistrationDto = new ArrayList<>();	

		for (int i=0; i< registrations.size(); i++) {
			RegistrationDto registrationDto = new RegistrationDto();
			StudentDto studentDto = new StudentDto();
			Registration reg = registrations.get(i);
			registrationDto.setIdReg(reg.getIdReg());
			registrationDto.setRegisterRef(reg.getRegisterRef());
			studentDto.setIdStud(reg.getStudent().getIdStud());
			studentDto.setStudentRef(reg.getStudent().getStudentRef());
			studentDto.setFirstName(reg.getStudent().getFirstName());
			studentDto.setLastName(reg.getStudent().getLastName());
			studentDto.setGender(reg.getStudent().getGender());
			studentDto.setAge(reg.getStudent().getAge());
			studentDto.setAdress(reg.getStudent().getAdress());
			studentDto.setClassRoom(reg.getStudent().getClassRoom());
			registrationDto.setStudent(studentDto);
			registrationDto.setUrlImage(reg.getUrlImage());
			registrationDto.setFees(reg.getFees());
			registrationDto.setDate(reg.getDate());
			registrationDto.setYear(reg.getYear());
			
			lRegistrationDto.add(i, registrationDto);
		
		}
		
		return new ResponseEntity<List<RegistrationDto>>(lRegistrationDto, HttpStatus.OK);	
	}
	
	@GetMapping(value="/getOneRegistrationDto/{registerRef}", produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<RegistrationDto>getOneRegistrationDto(@PathVariable(value="registerRef") String registerRef){
		 
			Registration reg = registrationService.findByregisterRef(registerRef);
	
			RegistrationDto registrationDto = new RegistrationDto();
			
			StudentDto studentDto = new StudentDto();

			registrationDto.setIdReg(reg.getIdReg());
			registrationDto.setRegisterRef(reg.getRegisterRef());
			studentDto.setIdStud(reg.getStudent().getIdStud());
			studentDto.setStudentRef(reg.getStudent().getStudentRef());
			studentDto.setFirstName(reg.getStudent().getFirstName());
			studentDto.setLastName(reg.getStudent().getLastName());
			studentDto.setGender(reg.getStudent().getGender());
			studentDto.setAge(reg.getStudent().getAge());
			studentDto.setAdress(reg.getStudent().getAdress());
			studentDto.setClassRoom(reg.getStudent().getClassRoom());
			registrationDto.setStudent(studentDto);
			registrationDto.setUrlImage(reg.getUrlImage());
			registrationDto.setFees(reg.getFees());
			registrationDto.setDate(reg.getDate());
			registrationDto.setYear(reg.getYear());
			
		return new ResponseEntity<RegistrationDto>(registrationDto, HttpStatus.OK);
		
	}

	
	@RequestMapping(value = "/saveRegistration", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Response> saveRegistration(@RequestBody RegistrationDto registrationDto)  
			throws JsonParseException, JsonMappingException, IOException {
		
		
		Student student = new Student();
		Registration registration = new Registration();
		
		registration.setDate(new Date());
		registration.setYear(registrationDto.getYear());
		registration.setFees(registrationDto.getFees());
		registration.setRegisterRef(registrationDto.getRegisterRef());
		
		student.setStudentRef(registrationDto.getRegisterRef());
		student.setFirstName(registrationDto.getStudent().getFirstName());
		student.setLastName(registrationDto.getStudent().getLastName());
		student.setGender(registrationDto.getStudent().getGender());
		student.setAge(registrationDto.getStudent().getAge());
		student.setAdress(registrationDto.getStudent().getAdress());
		student.setClassRoom(registrationDto.getStudent().getClassRoom());
		
		registration.setStudent(student);
		
		MultipartFile imageFile = Base64Util.base64MultipartFile(registrationDto.getImage(), registrationDto.getUrlImage());
		
		boolean isExist = new File(context.getRealPath("/registrations_imgs")).exists();
		if(!isExist) {
			new File(context.getRealPath("/registrations_imgs")).mkdir();
		}
		
		String fileName = imageFile.getOriginalFilename();
		String modifieFileName = FilenameUtils.getBaseName(fileName) + "_" + System.currentTimeMillis() + "." + FilenameUtils.getExtension(fileName);
		File serverFile = new File(context.getRealPath("registrations_imgs" + File.separator + modifieFileName));
		
		try {
			FileUtils.writeByteArrayToFile(serverFile, imageFile.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		registration.setUrlImage("http://192.168.1.101:8080/registrations_imgs/" + modifieFileName);
		
	
		Registration dbRegistration = registrationService.saveRegistrations(registration);
		
		if(dbRegistration != null) {
			return new ResponseEntity<Response>(new Response("Registration Saved Successfuly ..."), HttpStatus.OK);
		}
		
		else {
			return new ResponseEntity<Response>(new Response("Registration failed !!!"), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
		
		@PutMapping(value = "/update/{idReg}")
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		public ResponseEntity<Response> updateRegistration(@PathVariable("idReg") long idReg, @RequestBody RegistrationDto registrationDto) {
			
			Optional<Registration> registrationData = registrationService.findByidReg(idReg);
			
			Student student = new Student();
			
			Registration registration = registrationData.get();
			
			Registration dbRegistration = null;
			
			if (registrationData.isPresent()) {
				registration.setIdReg(registrationDto.getIdReg());
				registration.setRegisterRef(registrationDto.getRegisterRef());
				student.setIdStud(registrationDto.getStudent().getIdStud());
				student.setStudentRef(registrationDto.getStudent().getStudentRef());
				student.setFirstName(registrationDto.getStudent().getFirstName());
				student.setLastName(registrationDto.getStudent().getLastName());
				student.setGender(registrationDto.getStudent().getGender());
				student.setAge(registrationDto.getStudent().getAge());
				student.setAdress(registrationDto.getStudent().getAdress());
				student.setClassRoom(registrationDto.getStudent().getClassRoom());
				registration.setStudent(student);
				registration.setFees(registrationDto.getFees());
				registration.setDate(new Date());
				registration.setYear(registrationDto.getYear());
				registration.setUrlImage(registrationDto.getUrlImage());
				
				
				System.out.println("Update Registration with ID = " + idReg + "\n" + registration.getRegisterRef()
				+ "\n" + registration.getFees()
				+ "\n" + registration.getStudent().getFirstName()
				+ "\n" + registration.getStudent().getLastName());
				
				MultipartFile imageFile = Base64Util.base64MultipartFile(registrationDto.getImage(), registrationDto.getUrlImage());
				
				boolean isExist = new File(context.getRealPath("/registrations_imgs")).exists();
				if(!isExist) {
					new File(context.getRealPath("/registrations_imgs")).mkdir();
				}
				
				String fileName = imageFile.getOriginalFilename();
				String modifieFileName = FilenameUtils.getBaseName(fileName) + "_" + System.currentTimeMillis() + "." + FilenameUtils.getExtension(fileName);
				File serverFile = new File(context.getRealPath("registrations_imgs" + File.separator + modifieFileName));
				
				try {
					FileUtils.writeByteArrayToFile(serverFile, imageFile.getBytes());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				registration.setUrlImage("http://192.168.1.101:8080/registrations_imgs/" + modifieFileName);
				
				dbRegistration = registrationService.updateRegistrations(registration);
			}
			
			if(dbRegistration != null) {
				return new ResponseEntity<Response>(new Response("Registration Updated Successfuly ..."), HttpStatus.OK);
			}
			
			else {
				return new ResponseEntity<Response>(new Response("Registration Update failed !!!"), HttpStatus.BAD_REQUEST);
			}
		}
		
		
		@DeleteMapping(value="delete/{idReg}")
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		public ResponseEntity<Response> delete(@PathVariable Long idReg) {
			registrationService.deleteRegistrations(idReg);
			
			return new ResponseEntity<Response>(new Response("Registration Deleted Successfuly ..."), HttpStatus.OK);
		}
		
}
