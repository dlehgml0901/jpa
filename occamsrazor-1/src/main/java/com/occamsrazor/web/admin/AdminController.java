package com.occamsrazor.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.occamsrazor.web.util.Messenger;

@RestController //URL을 처리하는 컨트롤러
@RequestMapping("/member")
public class AdminController {
	//new Member() - MemberServicreImpl에 @Service.
	@Autowired AdminService memberService;
	
	@PostMapping("/join")
	public Messenger add(@RequestBody Admin member) {
		int current =memberService.count();
		memberService.add(member);
		return (memberService.count()==(current+1))? Messenger.SUCCESS : Messenger.FAIL;
	}
	@PostMapping("/login")
	public Messenger login(@RequestBody Admin member) {
		return (memberService.login(member))? Messenger.SUCCESS : Messenger.FAIL;
	}
	@GetMapping("/list")
	public Admin[] list() {
		Admin[] members = new Admin[5];
		return members;
	}
	@GetMapping("/detail")
	public Admin detail(@RequestBody String userid) {
		Admin detail = new Admin();
		return detail;
	}
	@GetMapping("/count")
	public int count() {
		int count = 0;
		return count;
	}
}
