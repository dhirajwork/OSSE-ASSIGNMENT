package com.osse.hotelreservation.assignment.controller;

import com.osse.hotelreservation.assignment.temp.CurrentReservation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class HotelReservationController {

    // booking page
    @GetMapping("/new-reservation")
    public String newReservation(Model model) {
        // reservation attribute
        model.addAttribute("newRes", new CurrentReservation());

        return "reservation-page";
    }
}
