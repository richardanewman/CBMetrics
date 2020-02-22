package dev.richardnewman.cbmetrics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.richardnewman.cbmetrics.entities.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

}
