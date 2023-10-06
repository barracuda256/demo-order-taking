package com.ordertaking.demo.order.сonverter;

import com.ordertaking.demo.order.dto.ProductDto;
import com.ordertaking.demo.order.model.Product;
import com.ordertaking.demo.order.model.ProductName;
import com.ordertaking.demo.order.model.ProductPackage;
import com.ordertaking.demo.order.model.packages.InternetPackage;
import com.ordertaking.demo.order.model.packages.MobilePackage;
import com.ordertaking.demo.order.model.packages.TelephonyPackage;
import com.ordertaking.demo.order.model.packages.TvPackage;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static java.text.MessageFormat.format;

@Component
public class ProductModelConverter implements ModelConverter<ProductDto, Product> {


    private static final String PACKAGE_NAME_IS_NOT_VALID = "Package name {0} is not valid for the {1} product!";
    private static final String PRODUCT_NAME_IS_NOT_VALID = "Product name {0} is not valid!";

    @Override
    public Product converter(ProductDto productDto) {
        ProductName productName;
        final String productNameAsString = productDto.productName();
        productName = getProduct(productNameAsString);
        ProductPackage productPackage = getProductPackage(productName, productDto.packageName());
        return new Product(productName, productPackage);
    }

    private static ProductName getProduct(String productNameAsString) {
        ProductName productName;
        try {
            productName = ProductName.valueOf(productNameAsString);
        } catch (Exception ex) {
            throw new ValidationException(format(PRODUCT_NAME_IS_NOT_VALID, productNameAsString));
        }
        return productName;
    }

    private ProductPackage getProductPackage(ProductName productName, String packageName) {
        Optional<? extends ProductPackage> productPackage = switch (productName) {
            case Internet -> InternetPackage.getById(packageName);
            case TV -> TvPackage.getById(packageName);
            case Telephony -> TelephonyPackage.getById(packageName);
            case Mobile -> MobilePackage.getById(packageName);
        };

        return productPackage.orElseThrow(() -> new ValidationException(format(PACKAGE_NAME_IS_NOT_VALID, packageName, productName)));
    }
}
