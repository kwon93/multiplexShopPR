package backend.shop.com.multiplexshop.domain.products.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/products")
public class ProductViewController {

    @GetMapping
    public String getAllProductsView(){

        return "product/allProductView";
    }

    @GetMapping("/food")
    public String getFoodProductsView(){

        return "product/foodProduct";
    }

    @GetMapping("/stuff")
    public String getStuffProductsView(){

        return "product/stuffProduct";
    }

    @GetMapping("/createProducts")
    public String getCreateProductsView(){

        return "product/createProduct";
    }

    @GetMapping("/{productsId}")
    public String getProductsDetailView(Model model){

        return "product/productDetailView";
    }


    @GetMapping("uploadImage")
    public String getUploadImageModal(){

        return "product/uploadModal";
    }
}
