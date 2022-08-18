package com.clusus.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter
@Setter
public class Deal {

    @Id
    @Column(name="deal_id")
    private Long id;
    private String fromCurrencyIsoCode;
    private String toCurrencyIsoCode;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp dealTime;
    private double amount;

}
