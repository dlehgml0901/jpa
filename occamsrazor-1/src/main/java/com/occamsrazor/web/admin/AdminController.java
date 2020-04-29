package com.occamsrazor.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.occamsrazor.web.util.Messenger;

@RestController //URL을 처리하는 컨트롤러
@RequestMapping("/admins")
public class AdminController {
	@Autowired AdminService adminService;
	
	@PostMapping("")
	public Messenger post(@RequestBody Admin admin) {
		System.out.println("1 AdminController post" + admin);
		adminService.register(admin);
		System.out.println("5 AdminController post");
		return Messenger.SUCCESS;
	}
	
	@GetMapping("")
	public List<Admin> list(){
		return adminService.findAll();
	}
	
	@GetMapping("/{employNumber}")
	public Admin detail(@PathVariable String employNumber) {
		return adminService.findOne(employNumber);
	}
	
	@PutMapping("/{employNumber}")
	public Messenger put(@RequestBody Admin admin) {
		adminService.modify(admin);
		return Messenger.SUCCESS;
	}
	
	@DeleteMapping("/{employNumber}")
	public Messenger delete(@RequestBody Admin admin) {
		adminService.remove(admin);
		return Messenger.SUCCESS;
	}
}
