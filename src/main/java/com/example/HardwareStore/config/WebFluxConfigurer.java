package com.example.HardwareStore.config;


import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurerComposite;

public class WebFluxConfigurer {
    @Bean
    public WebFluxConfigurerComposite corsConfigure(){
        return new WebFluxConfigurerComposite() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*")
                        .allowedMethods("*");
            }
        };
    }
}
