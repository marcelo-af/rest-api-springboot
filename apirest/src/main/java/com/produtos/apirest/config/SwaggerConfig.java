package com.produtos.apirest.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;





@Configuration
//O @Configuration é para o spring saber que é uma classe de configuração
@EnableSwagger2
//Habilita o Swagger
public class SwaggerConfig {
	
	@Bean
	//O @Bean retorna um metodo do tipo Docket. O Docket é uma classe externa da aplicação
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.produtos.apirest"))
				.paths(regex("/api.*"))
				.build()
				.apiInfo(metaInfo());
		
		//O metaInfo é apenas informações de quem criou a api
	}
	



	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Produtos API REST",
				"API REST de cadastro de produtos.",
				"1.0",
				"Terms of Service",
				new Contact("Marcelo Teste", "https://www.youtube.com/michellibrito",
						"michellidibrito@gmail.com"),
				"Apache License Version 2.0",
				"https://www.apache.org/license.html", new ArrayList <VendorExtension>()
				);
		return apiInfo;
	}
	
	//Para acessar o Swagger (http://localhost:8080/swagger-ui.html)

}
