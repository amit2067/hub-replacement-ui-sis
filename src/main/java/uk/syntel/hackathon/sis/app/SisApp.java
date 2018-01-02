package uk.syntel.hackathon.sis.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"uk.syntel.hackathon.sis.app"})
public class SisApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(SisApp.class, args);
    }
}
