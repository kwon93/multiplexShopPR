package backend.shop.com.multiplexshop.domain.products.controller;


import backend.shop.com.multiplexshop.domain.products.entity.Products;
import backend.shop.com.multiplexshop.domain.products.service.ProductsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static backend.shop.com.multiplexshop.domain.products.dto.ProductsDTOs.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductsAPIController {

    private final ProductsService productsService;

    @PostMapping(value = "/api/products")
    public ResponseEntity<?> postProducts(@RequestBody @Validated ProductsRequestDTO productsRequestDTO,
                                                            BindingResult bindingResult){

        ProductsResponseDTO responseDTO = productsService.productSaveByRequest(productsRequestDTO);
        if (bindingResult.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("유효성 검증 오류~");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(value = "/api/products/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateProducts(@RequestBody ProductsRequestDTO requestDTO, @PathVariable("id") Long productId){
        productsService.productUpdateByRequestAndId(requestDTO, productId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/products/{id}")
    public ResponseEntity deleteProducts(@PathVariable("id") Long productId){
        productsService.deleteProductById(productId);
        return ResponseEntity.noContent().build();
    }

}
