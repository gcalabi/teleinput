package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import static java.lang.Thread.sleep;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        System.out.println("Entre al index");


        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/test")
    public String test() {
        return "Prueba!";
    }

    

}
