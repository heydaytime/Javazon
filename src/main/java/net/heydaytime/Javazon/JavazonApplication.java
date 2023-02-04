package net.heydaytime.Javazon;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
@AllArgsConstructor
public class JavazonApplication {

    private static final Logger LOG = LoggerFactory.getLogger(JavazonApplication.class);

    public static void main(String[] args) throws IOException, URISyntaxException {
        SpringApplication.run(JavazonApplication.class, args);
        LOG.info("Server Initialized Successfully!");

    }
}
