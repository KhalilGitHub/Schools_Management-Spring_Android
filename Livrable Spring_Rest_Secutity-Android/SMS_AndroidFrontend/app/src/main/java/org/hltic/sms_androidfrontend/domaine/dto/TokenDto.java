package org.hltic.sms_androidfrontend.domaine.dto;


/**
 * Created by Khalil Hisseine  hamdane.khalil.hisseine@gmail.com on 07/2019.
 */

public class TokenDto {
	
	String tokenDto;

	public TokenDto() {
		super();
	}

	public TokenDto(String tokenDto) {
		super();
		this.tokenDto = tokenDto;
	}

	public String getTokenDto() {
		return tokenDto;
	}

	public void setTokenDto(String tokenDto) {
		this.tokenDto = tokenDto;
	}

	@Override
	public String toString() {
		return "TokenDto [tokenDto=" + tokenDto + "]";
	}

}
