package com.david.netflux.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class MovieEvent {

    private String id;
    private Date date;
}
