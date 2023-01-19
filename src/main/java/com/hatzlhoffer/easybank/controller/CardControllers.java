package com.hatzlhoffer.easybank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hatzlhoffer.easybank.model.Cards;
import com.hatzlhoffer.easybank.repository.CardsRepository;

@RestController
public class CardControllers {

    @Autowired
    private CardsRepository cardsRepository;

    @GetMapping("/mycards")
    public List<Cards> getCardsDetails(@RequestParam int id) {
        List<Cards> cards = cardsRepository.findByCustomerId(id);
        if (cards != null) {
            return cards;
        } else {
            return null;
        }
    }
}
