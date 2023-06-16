package com.pattysung.springbootmall.controller;

import com.pattysung.springbootmall.constant.ProductCategory;
import com.pattysung.springbootmall.dto.ProductQueryParams;
import com.pattysung.springbootmall.dto.ProductRequest;
import com.pattysung.springbootmall.model.Product;
import com.pattysung.springbootmall.service.ProductService;
import com.pattysung.springbootmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Validated //要記得加，Max和Min註解才會生效
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    //查詢列表
    @GetMapping("/products")
    public ResponseEntity<Page<Product>> getProducts(
            //查詢條件 Filtering
            @RequestParam(required = false) ProductCategory category,
            @RequestParam(required = false) String search,

            //排序 Sorting
            @RequestParam(defaultValue = "created_date") String orderBy, //根據什麼欄位排序(先設置default值)
            @RequestParam(defaultValue = "desc") String sort, //使用升冪或降冪排序

            //分頁 Pagination
            @RequestParam(defaultValue = "5") @Max(1000) @Min(0) Integer limit, //取得幾筆
            @RequestParam(defaultValue = "0") @Min(0) Integer offset //跳過幾筆
    ){
        //改善參數傳遞方式ProductQueryParams，不用一再修改Service,Dao層
        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);
        productQueryParams.setOrderBy(orderBy);
        productQueryParams.setSort(sort);
        productQueryParams.setLimit(limit);
        productQueryParams.setOffset(offset);

        //取得product list
        List<Product> productList = productService.getProducts(productQueryParams);

        //取得product總數(商品總筆數會因條件不同而改變）
        Integer total = productService.countProduct(productQueryParams);

        //分頁-變成回傳Json Object
        Page<Product> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResults(productList); //查詢出來的商品數據放到這裡回傳給前端

        return ResponseEntity.status(HttpStatus.OK).body(page); //把page回傳給前端
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId){
        Product product = productService.getProductById(productId);

        if(product != null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest){
        //此方法去資料庫創建資料，並返回資料庫生成的productId給我們
        Integer productId = productService.createProduct(productRequest);
        //用上面productId去查詢這個商品的數據回來
        Product product = productService.getProductById(productId);

        //回傳ResponseEntity給前端(狀態碼201Created)，且把創建出來的商品數據，放在body裏面傳回給前端
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
    @PutMapping("/products/{productId}") //@PathVariable 接住從Url路徑傳過來的productId的值，還有@RequestBody接住前端傳過來的json參數（商品修改後的數據productRequest）
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody @Valid ProductRequest productRequest){
        //檢查Product是否存在
        Product product = productService.getProductById(productId);

        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        //修改商品的數據
        productService.updateProduct(productId, productRequest);

        Product updatedProduct = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
    }
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
        productService.deleteProductById(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
