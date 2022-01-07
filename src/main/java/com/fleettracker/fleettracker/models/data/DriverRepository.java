package com.fleettracker.fleettracker.models.data;

import com.fleettracker.fleettracker.models.Driver;
import org.springframework.data.repository.CrudRepository;

public interface DriverRepository extends CrudRepository<Driver, Integer> {
}
