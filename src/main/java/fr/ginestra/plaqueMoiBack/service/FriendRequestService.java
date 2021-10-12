package fr.ginestra.plaqueMoiBack.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ginestra.plaqueMoiBack.model.FriendRequest;
import fr.ginestra.plaqueMoiBack.repository.FriendRequestRepository;
import lombok.Data;

@Data
@Service
public class FriendRequestService {


    @Autowired
    private FriendRequestRepository friendRequestRepository;
    
    public FriendRequest getFriendRequest(UUID id) {
        return friendRequestRepository.findById(id).get();
    }

    public Iterable<FriendRequest> getFriendRequests() {
        return friendRequestRepository.findAll();
    }

    public void deleteFriendRequest(UUID id) {
    	friendRequestRepository.deleteById(id);
    }

    public FriendRequest saveFriendRequest(FriendRequest friendRequest) {
    	FriendRequest savedFriendRequest = friendRequestRepository.save(friendRequest);
        return savedFriendRequest;
    }
    
    public FriendRequest updateFriendRequest(UUID id, FriendRequest updatedFriendRequest) {
    	Optional<FriendRequest> fr = this.friendRequestRepository.findById(id);
    	if(fr.isEmpty()) {
    		return this.friendRequestRepository.save(updatedFriendRequest);
    	}
    	return this.friendRequestRepository.save(fr.get().updateFriendRequest(updatedFriendRequest));
    	
    }
	
}
