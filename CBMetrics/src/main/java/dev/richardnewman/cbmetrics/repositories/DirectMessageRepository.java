package dev.richardnewman.cbmetrics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.richardnewman.cbmetrics.entities.DirectMessage;

public interface DirectMessageRepository extends JpaRepository<DirectMessage, Integer> {

}
