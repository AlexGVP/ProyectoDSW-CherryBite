package cib.edu.pe.ProyectoDSW_CherryBite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ProyectoDswCherryBiteApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProyectoDswCherryBiteApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer configGlobalCors(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("api/cherry/**")
						.allowedMethods("GET","POST","PUT")
						.allowedOrigins("*");
			}
		};
	}
}
