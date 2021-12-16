package com.osse.hotelreservation.assignment.controller;

import com.osse.hotelreservation.assignment.services.ReservationService;
import com.osse.hotelreservation.assignment.temp.CurrentReservation;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

public class HotelReservationController {

    private ReservationService reservationService;

    // booking page
    @GetMapping("/new-reservation")
    public String newReservation(Model model) {
        // reservation attribute
        model.addAttribute("newRes", new CurrentReservation());

        return "reservation-page";
    }

    // save new reservation
    @PostMapping("/proceed-reservation")
    public String proceedReservation(@Valid @ModelAttribute("newRes") CurrentReservation currentReservation,
                                     BindingResult theBindingResult, Model model) {

        // send reservation to services to save it in database
        reservationService.saveOrUpdateReservation(currentReservation);

        return "redirect:/your-reservations";
    }

    // reservations of user
    @GetMapping("/your-reservations")
    public String reservationsList(Model model) {

        // list of reservations for logged user
        model.addAttribute("resList", reservationService.getReservationsForLoggedUser());

        return "your-reservations";
    }

}
