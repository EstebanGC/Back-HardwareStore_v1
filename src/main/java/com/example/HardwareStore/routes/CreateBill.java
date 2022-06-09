package com.example.HardwareStore.routes;


import com.example.HardwareStore.dto.BillDTO;
import com.example.HardwareStore.usecases.CreateBillUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateBill {

    @Bean

    public RouterFunction<ServerResponse> createBill(CreateBillUseCase createBillUseCase){
        return route(POST("/store-api/create-bill").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(BillDTO.class)
                        .flatMap(createBillUseCase::createBill)
                        .flatMap(billDTO -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(billDTO)));

    }
}
