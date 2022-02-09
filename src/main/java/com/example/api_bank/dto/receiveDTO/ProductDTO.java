package com.example.api_bank.dto.receiveDTO;
import com.example.api_bank.entity.CategoryDB;
import lombok.Data;
import javax.persistence.Column;
import java.io.File;


@Data
public class ProductDTO {

    private Long categoryId;

    @Column(unique = true)
    private String name;

    private String description;

    private double price;

    private String photo;

}
