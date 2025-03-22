package br.com.freitag.taskcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@SpringBootApplication
public class TaskcontrolApplication {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors
						.basePackage("br.com.freitag.taskcontrol.controller"))
				.paths(PathSelectors.regex("/.*"))
				.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"TASK REST API",
				"API que efetua as transações do Sistema Task Control..",
				"1.0.0 ALPHA",
				"Termos do serviço",
				new Contact("Freitag", "www.freitag.net.br", "fmfreitag01@gmail.com"),
				"Licença da API", "API license URL", Collections.emptyList());
	}

	public static void main(String[] args) {
		SpringApplication.run(TaskcontrolApplication.class, args);
	}

}
