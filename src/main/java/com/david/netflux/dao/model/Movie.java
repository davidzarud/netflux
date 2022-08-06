package com.david.netflux.dao.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private String id;

    @NonNull
    private String title;
}
