package lt.bpol.securityApp.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value="user")
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	@GetMapping("/users")
	@ApiOperation(value="List all users", notes="Some random text")
	public @ResponseBody List<User> getAllUsers(){
		return userServ.getAllUsers();
	}
	
	@GetMapping("/users/{userId}")
	@ApiOperation(value="Find one user by ID")
	public @ResponseBody Optional<User> findUserById(@PathVariable Long userId) {
		return userServ.findUserById(userId);
	}
	
	@GetMapping("/users/{userName}")
	@ApiOperation(value="Find one user by Name")
	public @ResponseBody User findUserByUserName(@PathVariable String userName) {
		return userServ.findUserByUserName(userName);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Create new user")
	public @ResponseBody void createUser(@RequestBody User user) {
		userServ.createUser(user);
	}
	
	@DeleteMapping("/users/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="Delete user by user ID")
	public @ResponseBody void removeUserById (@PathVariable Long userId) {
		userServ.removeUserById(userId);
	}
	
	
	
}
