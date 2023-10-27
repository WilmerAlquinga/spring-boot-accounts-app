package dev.wsalquinga.clients_service.repository;

import dev.wsalquinga.clients_service.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author wsalquinga on 26/10/2023
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("select c from Client c " +
            "where (c.deletedAt is null " +
            "or c.deletedAt > current_timestamp) " +
            "and c.id = :id")
    Optional<Client> findValidById(Long id);
}
