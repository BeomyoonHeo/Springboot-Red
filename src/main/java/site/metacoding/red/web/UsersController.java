package site.metacoding.red.web;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.red.domain.users.Users;
import site.metacoding.red.domain.users.UsersDao;
import site.metacoding.red.web.dto.request.users.JoinDto;
import site.metacoding.red.web.dto.request.users.UpdateDto;
import site.metacoding.red.web.dto.response.RespDto;


@RequiredArgsConstructor //final로 선언되어있는 데이터만 생성자로 인자를 받는다. - DI에 활용
@RestController
public class UsersController {

	private final UsersDao usersDao; // 타입을 적어서 IOC container에서 해당 타입이면 주입 시켜준다.
	
	@GetMapping("/users/{id}")
	public RespDto<?> getUsers(@PathVariable Integer id) {
		return new RespDto<>(1,"성공",usersDao.findById(id));
	}
	
	@GetMapping("/users")
	public RespDto<?> getUsersList(){
		return new RespDto<>(1,"성공", usersDao.findAll());
	}
	
	@PostMapping("/users")
	public RespDto<?> insert(JoinDto joindto) {
		usersDao.insert(joindto);
		return new RespDto<>(1, "성공", null); //201번 - insert됨
	}
	
	@DeleteMapping("/users/{id}")
	public RespDto<?> deleteUsers(@PathVariable Integer id) {
		usersDao.delete(id);
		return new RespDto<>(1,"성공", null);
	}
	
	@PutMapping("/users/{id}/password")
	public RespDto<?> updatePassword(@PathVariable Integer id, String password){
		Users user = usersDao.findById(id);
		
		user.패스워드수정(password);
		
		usersDao.update(user);
		
		return new RespDto<>(1,"비밀번호수정완료", null);
	}
	
	@PutMapping("/users/{id}/info")
	public RespDto<?> updateInfo(@PathVariable Integer id, UpdateDto updateDto){
		Users user = usersDao.findById(id);
		if(updateDto.getUsername().equals(null) || updateDto.getUsername().equals(""))
		{
			
		}
		return new RespDto<>(1, "수정완료", null);
	}
	
	@PutMapping("/users/{id}")
	public RespDto<?> updateUsers(@PathVariable Integer id, UpdateDto updateDto){
//	    1번 : id로 select 하자. (영속화)
		Users user = usersDao.findById(id);
		
//		2번 : 변경
		user.전체수정(updateDto);
		
//	    3번 : 영속화된 오브젝트로 update하기
		usersDao.update(user);
		return new RespDto<>(1,"회원수정완료", null);
	}
	
	
// httpEntity를 상속받아서 ResponseEntity이 구현되어있다. - spring boot framework 제공
//	@PostMapping("/users")
//	public RespDto<?> insert(Users users) {
//		Integer result = usersDao.insert(users);
//		return new ResponseEntity<>(HttpStatus.CREATED); //201번 - insert됨
//	}
}
