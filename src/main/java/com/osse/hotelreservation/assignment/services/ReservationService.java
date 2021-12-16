package com.osse.hotelreservation.assignment.services;

import com.osse.hotelreservation.assignment.entity.Reservation;
import com.osse.hotelreservation.assignment.temp.CurrentReservation;

import java.util.Collection;

//Service Pattern for Reservation
public interface ReservationService {

    public Collection<Reservation> getReservationsForLoggedUser();

    public void saveOrUpdateReservation(CurrentReservation currentReservation);

    void deleteReservation(int resId);
}
