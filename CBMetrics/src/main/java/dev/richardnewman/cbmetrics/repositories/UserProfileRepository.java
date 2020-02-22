package dev.richardnewman.cbmetrics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.richardnewman.cbmetrics.entities.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

}
