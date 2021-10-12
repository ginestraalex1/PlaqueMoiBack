package fr.ginestra.plaqueMoiBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ginestra.plaqueMoiBack.model.FriendRequest;
import fr.ginestra.plaqueMoiBack.service.FriendRequestService;

@RestController
public class FriendRequestController {
	
	
	@Autowired
	private FriendRequestService friendRequestService;
	
	@GetMapping("/friendRequests")
	private Iterable<FriendRequest> friendRequest(){
		return friendRequestService.getFriendRequests();
	}
}
