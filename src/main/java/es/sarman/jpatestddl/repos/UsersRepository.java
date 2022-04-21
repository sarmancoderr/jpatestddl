package es.sarman.jpatestddl.repos;

import es.sarman.jpatestddl.models.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends PagingAndSortingRepository<UserEntity, String> {
}
