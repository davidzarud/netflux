package com.david.netflux.bootstrap;

import com.david.netflux.dao.model.Movie;
import com.david.netflux.dao.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class InitMovies implements CommandLineRunner {

    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {

        movieRepository.deleteAll()
                .thenMany(Flux.just("Homefront"
                        ,"Bound by Honor (a.k.a. Blood In, Blood Out)"
                        ,"Clifford"
                        ,"Alphabet"
                        ,"Trailer Park Boys: Countdown to Liquor Day"
                        ,"Morgan Pålsson - världsreporter"
                        ,"Blade: Trinity"
                        ,"The Gamers"
                        ,"Vivre sa vie: Film en douze tableaux (My Life to Live)"
                        ,"Alex Cross"
                        ,"Nameless Gangster (Bumchoiwaui junjaeng)"
                        ,"Secrets & Lies"
                        ,"Cherry Crush"
                        ,"Believer, The"
                        ,"House Is Black, The"
                        ,"Passengers"
                        ,"Undead"
                        ,"Good For Nothing"
                        ,"Exit Wounds"
                        ,"Nina's Heavenly Delights"))
                .map(title -> Movie.builder().title(title).build())
                .flatMap(movieRepository:: save)
                .subscribe(null, null, () -> {
                    movieRepository.findAll().subscribe(System.out:: println);
                });


    }
}
