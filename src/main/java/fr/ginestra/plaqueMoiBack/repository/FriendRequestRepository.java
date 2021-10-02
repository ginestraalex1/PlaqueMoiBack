package fr.ginestra.plaqueMoiBack.repository;

import org.springframework.stereotype.Repository;
import fr.ginestra.plaqueMoiBack.model.FriendRequest;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface FriendRequestRepository extends CrudRepository<FriendRequest, Long>{

}
