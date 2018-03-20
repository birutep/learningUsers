package lt.bpol.securityApp.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Transactional (readOnly = true)
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	@Transactional (readOnly = true)
	public Optional<User> findUserById(Long id) {		
		return userRepo.findById(id);
	}
	
	//pagalvoti, gal ir cia reiktu Optional grazinti?
	@Transactional (readOnly = true)
	public User findUserByUserName(String userName) {
		return userRepo.findByUserName(userName);
	}
	
	@Transactional
	public void createUser(User user) {
		userRepo.save(user);
	}
	
	@Transactional
	public void removeUserById (Long id) {
		userRepo.deleteById(id);;
	}
	
	
}
