package com.example.hongs;

import com.example.hongs.domain.Hello;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HongsApplication {

    public static void main(String[] args) {
        Hello hellosss = new Hello();
        hellosss.setData("hello");
        String data = hellosss.getData();
        SpringApplication.run(HongsApplication.class, args);
		System.out.println("data = " + data);
    }

}
