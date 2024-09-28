package com.prattis.javaspringdemo.repository;

import com.prattis.javaspringdemo.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository  extends JpaRepository<Activity, Long> {

}
