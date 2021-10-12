package fr.ginestra.plaqueMoiBack.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ginestra.plaqueMoiBack.model.FriendRequest;
import fr.ginestra.plaqueMoiBack.service.FriendRequestService;

@RestController
@RequestMapping("/friendRequest")
public class FriendRequestController {
	
	
	@Autowired
	private FriendRequestService friendRequestService;
	
	@GetMapping("s")
	public Iterable<FriendRequest> friendRequest(){
		return friendRequestService.getFriendRequests();
	}
	
	@GetMapping("{id}")
	public FriendRequest friendRequest(@PathVariable("id") UUID id) {
		return friendRequestService.getFriendRequest(id);
	}
	
	@PostMapping()
	public FriendRequest newFriendRequest(@RequestBody FriendRequest friendRequest) {
		return this.friendRequestService.saveFriendRequest(friendRequest);
	}
	
	@PutMapping("{id}")
	public FriendRequest updateFriendRequest(@PathVariable("id") UUID id, @RequestBody FriendRequest updatedFR) {
		return this.friendRequestService.updateFriendRequest(id, updatedFR);
	}
	
}
