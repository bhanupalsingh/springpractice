package io.javabrains.springbootstarter.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import io.javabrains.springbootstarter.bean.Team;
@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
    Team findByPlayers(long playerId);
}