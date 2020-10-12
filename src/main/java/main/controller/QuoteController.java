package main.controller;


import lombok.RequiredArgsConstructor;
import main.dto.quote.Quote;
import main.service.QuoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quote")
public class QuoteController {

    private final QuoteService quoteService;

    @GetMapping("/random")
    public Quote getRandomQuote(){
       return quoteService.getRandomQuote();
    }
}
