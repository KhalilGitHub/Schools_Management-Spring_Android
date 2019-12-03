package org.hltic.sms_backend_rest.api.domaine.dto;

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
