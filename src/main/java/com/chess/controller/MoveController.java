package com.chess.controller;

import com.chess.model.Board;
import com.chess.model.Game;
import com.chess.model.Login;
import com.chess.model.Move;
import com.chess.model.domain.User;
import com.chess.model.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@SpringBootApplication
@EntityScan("com.chess.model.domain")
@EnableJpaRepositories("com.chess.model.repositories")
public class MoveController {
    private User playerRed = new User("Max", "Mustermann", "test@test.de", "test");
    private User playerBlue = new User("Maxime", "Musterfrau", "test2@test.de", "test");

    private Game game = new Game();

    @Autowired
    UserRepository userRepository;

    @RestController
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/API/Board")
    class GetBoard {
        @RequestMapping(method = RequestMethod.GET, produces = "application/json")
        public @ResponseBody Board starterBoard() {
            return game.getBoard();
        }
    }

    @RestController
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/API/Move")
    class PostMove {
        @RequestMapping(method = RequestMethod.POST, produces = "application/json")
        boolean newMove(@RequestBody Move newMove) {
            return game.addMove(newMove);
        }
    }

    @RestController
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/API/Login")
    class PostLogin {
        @RequestMapping(method = RequestMethod.POST, produces = "application/json")
        User isUser(@RequestBody Login login) {
            User user = userRepository.findByEmail(login.getEmail()).get(0);
            if (user != null) {
                if (user.getPassword().equals(login.getPassword())) {
                    return user;
                }
            }
            return null;
        }
    }

    @RestController
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/API/Regist")
    class PostRegist {
        @RequestMapping(method = RequestMethod.POST, produces = "application/json")
        boolean newUser(@RequestBody User user) {
            userRepository.save(user);
            return true;
        }
    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(MoveController.class, args);
    }

    @Bean
    CommandLineRunner runner(UserRepository repository){
        return args -> {
            repository.save(this.playerBlue);
        };
    }
}