package com.example.api_bank.service;

import com.example.api_bank.dto.response.HighProductsResponse;
import com.example.api_bank.entity.DetailDB;
import com.example.api_bank.repository.DetailsRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class DetailService {
    public final DetailsRepository detailsRepository;

    public DetailService(DetailsRepository detailsRepository) {
        this.detailsRepository = detailsRepository;
    }



    public List<HighProductsResponse> highProducts(){
      return detailsRepository.highProduct();
    }

}
