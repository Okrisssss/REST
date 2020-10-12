package main.service.impl;


import main.dto.quote.Quote;
import main.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QuoteServiceImplementation implements QuoteService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Quote getRandomQuote() {
        return restTemplate.getForObject(
                "https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
    }
}
