package com.fleettracker.fleettracker.models.data;

import com.fleettracker.fleettracker.models.Jobs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends CrudRepository<Jobs, Integer> {

}
