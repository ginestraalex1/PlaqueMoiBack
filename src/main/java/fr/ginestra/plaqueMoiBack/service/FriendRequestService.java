package fr.ginestra.plaqueMoiBack.service;

import java.util.Optional;

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
    
    public Optional<FriendRequest> getFriendRequest(final Long id) {
        return friendRequestRepository.findById(id);
    }

    public Iterable<FriendRequest> getFriendRequests() {
        return friendRequestRepository.findAll();
    }

    public void deleteFriendRequest(final Long id) {
    	friendRequestRepository.deleteById(id);
    }

    public FriendRequest saveFriendRequest(FriendRequest friendRequest) {
    	FriendRequest savedFriendRequest = friendRequestRepository.save(friendRequest);
        return savedFriendRequest;
    }
	
}
