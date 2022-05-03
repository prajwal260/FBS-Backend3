package com.org.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.model.Schedule;

@Repository
public interface ScheduleDao extends CrudRepository<Schedule, Integer> {

}
