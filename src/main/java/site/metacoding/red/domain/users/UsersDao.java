package site.metacoding.red.domain.users;

import java.util.List;

import site.metacoding.red.web.dto.request.users.JoinDto;
import site.metacoding.red.web.dto.request.users.UpdateDto;

//인터페이스를 만들어 mybatis가 맵핑하여 구현체를 만들어서 사용한다.
//각 메서드 이름은 mybatis가 사용하는 id와 같은 이름을 사용해야 한다.
public interface UsersDao {
	public void insert(JoinDto joinDto);
	public Users findById(Integer id);
	public List<Users> findAll();
	public void update(Users user);
	public void delete(Integer id);
}
