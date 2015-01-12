package com.carsim.core.repo;


import com.carsim.core.model.entities.Currency;

/**
 * Created by webyildirim.
 */
public interface CurrencyRepo {


    public Currency findCurrency(Long id);
    
    public Currency deleteCurrency(Long id) throws Exception;

    public Currency updateCurrency(Long id, Currency entity) throws Exception;

    public Currency createCurrency(Currency entity) throws Exception;

    public Currency findByName(String name);
}
