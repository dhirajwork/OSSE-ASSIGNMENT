package com.osse.hotelreservation.assignment.services;

import com.osse.hotelreservation.assignment.entity.Reservation;
import com.osse.hotelreservation.assignment.repository.ReservationRep;
import com.osse.hotelreservation.assignment.temp.CurrentReservation;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class ReservationServiceImpl  implements ReservationService{

    private UserService userService;

    private ReservationRep reservationRepository;


    // get all reservations for logger user
    @Override
    @Transactional
    public Collection<Reservation> getReservationsForLoggedUser() {
        return reservationRepository.findAllByUserId((userService.getLoggedUserId()));
    }

    @Override
    public void saveOrUpdateReservation(CurrentReservation currentReservation) {
        Reservation reservation = new Reservation();

        // get required id user using user services
        reservation.setUserId(userService.getLoggedUserId());

        reservation.setArrivalDate(currentReservation.getArrivalDate());
        reservation.setOpenBuffet(currentReservation.getOpenBuffet());
        reservation.setStayDays(currentReservation.getStayPeriod());
        reservation.setChildren(currentReservation.getChildren());
        reservation.setPersons(currentReservation.getPersons());
        reservation.setPrice(currentReservation.getPrice());
        reservation.setRooms(currentReservation.getRooms());
        reservation.setRoom(currentReservation.getRoom());
        reservation.setId(currentReservation.getId());

        reservationRepository.save(reservation);
    }

    // delete reservation
    @Override
    @Transactional
    public void deleteReservation(int resId) {
        reservationRepository.deleteById(resId);
    }
}
