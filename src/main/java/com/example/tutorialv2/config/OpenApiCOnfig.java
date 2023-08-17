package com.example.tutorialv2.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiCOnfig {

        @Bean //OBJENTO MONTADO E CONFIGURADO SPRING
        public OpenAPI customOpenAPI(){
            return new OpenAPI()
                    .info(new Info()
                            .title("Projeto PTL - With a new technologies")
                            .version("v1")
                            .description("Recostrução de projeto Legado")
                            .termsOfService("Termos de Serviços")
                            .license(new License().name("Apache 2.0")
                            .url("https://github.com/Vinizeira/PROJETOPTL")));
        }
}
