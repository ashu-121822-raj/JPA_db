package com.example.jpadb.service;

import com.example.jpadb.model.Quote;
import com.example.jpadb.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuoteService {
    @Autowired
    QuoteRepository quoteRepository;
    public Quote createQuote(Quote quoteString){
        return quoteRepository.save(quoteString);
    }
    public List<Quote> getQuotes() {
        return quoteRepository.findAll();
    }
    public void deleteQuote(Long ID) {
        quoteRepository.deleteById(ID);
    }

    public Quote updateQuote(Long ID, Quote newQuoteString) {
        Quote quote = quoteRepository.findById(ID).get();
        quote.setQuote(newQuoteString.getQuote());
        return quoteRepository.save(newQuoteString);
    }
}