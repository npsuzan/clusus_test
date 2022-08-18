package com.clusus.service;

import com.clusus.entity.Deal;
import com.clusus.repository.DealRepository;
import com.clusus.utils.CurrencyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class DealService {
    public DealService(){

    }

    private DealRepository dealRepository;

    @Autowired
    public DealService(DealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    public List<Deal> getDeals(){
        List<Deal> deals=new ArrayList<>();
        dealRepository.findAll().forEach(deals::add);
        return deals;
    }


    public boolean saveDeal(Deal deal,List<String> messages) throws Exception{
        if(isValidDeal(deal,messages)){
            try{
                dealRepository.save(deal);
            }catch (Exception e){
                messages.add("Exception During save.");
                throw e;
            }

            return true;
        }

        return false;
    }

    private boolean isValidDeal(Deal deal,List<String> messages) {

        if(dealRepository.findById(deal.getId()).isPresent()){
            messages.add("Duplicate Deal..");
            return false;
        }
        if(deal.getId()!=null && deal.getDealTime()!=null && deal.getToCurrencyIsoCode()!=null && deal.getFromCurrencyIsoCode()!=null && deal.getAmount()!=0){
            if(CurrencyCode.getValue(deal.getFromCurrencyIsoCode())!=null && CurrencyCode.getValue(deal.getToCurrencyIsoCode())!=null){
                return true;
            }else {
                messages.add("Invalid Currency ISO Code");
            }
        }else {
            messages.add( "Some Field is empty");
        }
        return false;
    }

}
