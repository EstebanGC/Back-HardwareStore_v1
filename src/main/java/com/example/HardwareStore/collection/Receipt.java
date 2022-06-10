package com.example.HardwareStore.collection;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="receipt")
public class Receipt {

    @Id
    private String id;
    private String providerName;
    private Integer units;
    private String productId;
    private String date;
    private Provider provider;
}