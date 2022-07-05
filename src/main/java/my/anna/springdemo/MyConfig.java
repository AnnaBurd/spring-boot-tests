package my.anna.springdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration	// Configure Spring application 
@ComponentScan(value="my.anna.springdemo") // Automatically scans for and creates Spring Bean
@EnableAspectJAutoProxy // Enables to use @Aspect annotations
public class MyConfig {

// ----------------- Manually configure bean creation
//    @Bean
//    public Library library() {
//    	Library library = new Library();
//    	System.out.println("Library bean created");
//        return library;
//    }

}
