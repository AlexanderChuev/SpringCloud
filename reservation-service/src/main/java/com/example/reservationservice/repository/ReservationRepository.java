package com.example.reservationservice.repository;

import com.example.reservationservice.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.websocket.server.PathParam;
import java.util.Collection;

@RepositoryRestResource
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @RestResource(path = "byName")
    Collection<Repository> findByReservationName(@PathParam("rn") String rn);
}
