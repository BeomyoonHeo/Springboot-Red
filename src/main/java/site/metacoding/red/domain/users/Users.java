package site.metacoding.red.domain.users;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.red.web.dto.request.users.UpdateDto;

@Getter
public class Users {
	private Integer id;
	private String username;
	private String password;
	private String email;
	private Timestamp createdAt;
	
	public void 이름수정(String username) {
		this.username = username;
	}
	
	public void 패스워드수정(String password) {
		this.password = password;
	}
	
	public void 이메일수정(String email) {
		this.email = email;
	}
	
	public void 전체수정(UpdateDto updateDto){
		this.username = updateDto.getUsername();
		this.password = updateDto.getPassword();
		this.email = updateDto.getEmail();
	}
	
}


