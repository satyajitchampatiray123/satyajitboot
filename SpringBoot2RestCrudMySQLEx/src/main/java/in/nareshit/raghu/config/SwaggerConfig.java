package in.nareshit.raghu.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("in.nareshit.raghu.rest"))
				.paths(PathSelectors.regex("/rest.*"))
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"NIT-APP", //title
				"HELLO TEST",  //description
				"9.2GA",  //version
				"https://nareshit.in/", //serviceURL
				new Contact("RAGHU", "https://nareshit.in/", "javabyraghu@gmail.com"), //developer contact
				"NIT LICENSE",  //license
				"https://nareshit.in/",  //license URL
				Collections.emptyList());
	}
}
