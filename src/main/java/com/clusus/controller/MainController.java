package com.clusus.controller;

import com.clusus.utils.GenericResponse;
import com.clusus.entity.Deal;
import com.clusus.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class MainController {

    DealService dealService;

    @Autowired
    public MainController(DealService dealService) {
        this.dealService = dealService;
    }

    @RequestMapping("/")
    public String checkRun(){
        return "Application running now";
    }

    @RequestMapping(value = "deal", method = RequestMethod.POST)
    public ResponseEntity<?> saveDealDetails(@RequestBody Deal deal) {
        GenericResponse<String> response=new GenericResponse<>();
        List<String> messages=new ArrayList<>();
        try {
            if(dealService.saveDeal(deal,messages)){
                messages.add("Saved Successfully");
               response.setStatus(HttpStatus.OK.value());
            }else {
                response.setStatus(HttpStatus.BAD_REQUEST.value());
            }
        } catch (Exception e) {
            messages.add("Exception occurs. Please look into the server..");
            e.printStackTrace();
            response.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        response.setMessage(messages);

        return ResponseEntity.of(Optional.of(response));

    }
}
