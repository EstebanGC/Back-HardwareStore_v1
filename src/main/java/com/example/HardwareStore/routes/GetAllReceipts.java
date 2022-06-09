package com.example.HardwareStore.routes;

import com.example.HardwareStore.dto.ReceiptDTO;
import com.example.HardwareStore.usecases.GetAllProductsUseCase;
import com.example.HardwareStore.usecases.GetAllReceiptsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllReceipts {

    @Bean
    public RouterFunction<ServerResponse> getAllReceiptsRouter(GetAllReceiptsUseCase getAllReceiptsUseCase){
        return route(GET("/getallreceipts"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getAllReceiptsUseCase.getAllReceipts(), ReceiptDTO.class)));
    }
}
