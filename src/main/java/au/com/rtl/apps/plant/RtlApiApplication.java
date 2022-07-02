package au.com.rtl.apps.plant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@SpringBootApplication
public class RtlApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RtlApiApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/v1/operations/jobs/plant/prestart/**").allowedOrigins("*").allowedHeaders("*").allowCredentials(false).allowedMethods("*");
			}
		};
	}
}
