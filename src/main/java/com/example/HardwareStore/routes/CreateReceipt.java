package com.example.HardwareStore.routes;

import com.example.HardwareStore.dto.ProductDTO;
import com.example.HardwareStore.dto.ProviderDTO;
import com.example.HardwareStore.dto.ReceiptDTO;
import com.example.HardwareStore.mapper.ReceiptMapper;
import com.example.HardwareStore.repository.ReceiptRepository;
import com.example.HardwareStore.usecases.CreateProviderUseCase;
import com.example.HardwareStore.usecases.CreateReceiptUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Service
@AllArgsConstructor
public class CreateReceipt {

    @Bean

    @RouterOperation(operation = @Operation(description = "Create receipt ", operationId = "createReceipt", tags = "Receipt",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ReceiptDTO.class)))))


    public RouterFunction<ServerResponse> createReceiptRouter(CreateReceiptUseCase createReceiptUseCase) {
        return route(POST("/create/receipt").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ReceiptDTO.class)
                        .flatMap(createReceiptUseCase::createReceipt)
                        .flatMap(providerDTO -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(providerDTO)));
    }
}
