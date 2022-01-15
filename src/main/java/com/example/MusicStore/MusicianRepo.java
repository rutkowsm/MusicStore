package com.example.MusicStore;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicianRepo extends JpaRepository<Musician, Long> {

}
