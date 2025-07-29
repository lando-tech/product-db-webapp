package io.landotech.productservice.bootstrap;

import io.landotech.productservice.domains.*;
import io.landotech.productservice.filters.*;
import io.landotech.productservice.services.interfaces.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootStrap implements CommandLineRunner {

    private final ProductService productService;
    private final VendorService vendorService;

    public BootStrap(ProductService productService, VendorService vendorService) {
        this.productService = productService;
        this.vendorService = vendorService;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Product> products = productService.findAll();
        List<Vendor> vendors = vendorService.findAll();

        if (products.isEmpty()) {
            bootStrapProducts();
        }
        if (vendors.isEmpty()) {
            bootStrapVendors();
        }
    }

    private void addProduct(
            String productName,
            String partNumber,
            String manufacturerNumber,
            double price,
            ProductCategory productCategory,
            Manufacturer manufacturer
    ) {
        GenericProduct newProduct = new GenericProduct();
        newProduct.setName(productName);
        newProduct.setPartNumber(partNumber);
        newProduct.setManufacturerNumber(manufacturerNumber);
        newProduct.setPrice(price);
        newProduct.setProductCategory(productCategory);
        newProduct.setManufacturer(manufacturer);
        addProductDescription(newProduct);
        this.productService.save(newProduct);
    }

    private void addProductDescription(GenericProduct product) {
        ProductDescription productDescription = new ProductDescription();
        product.setProductDescription(productDescription);
        productDescription.setProduct(product);
    }

    private void addVendor(String vendorName, String vendorEmail, String vendorPhoneNumber, String vendorCageCode) {
        Vendor vendor = new Vendor();
        vendor.setName(vendorName);
        vendor.setPocEmail(vendorEmail);
        vendor.setPocPhoneNumber(vendorPhoneNumber);
        vendor.setCageCode(vendorCageCode);
        vendorService.save(vendor);
    }

    private void bootStrapProducts() {
        addProduct(
                "LG 50\" UHD Display",
                "10-50",
                "100-555-665",
                300.0,
                ProductCategory.VIDEO,
                Manufacturer.LG
        );
        addProduct(
                "LG 55\" UHD Display",
                "10-55",
                "100-555-666",
                350.0,
                ProductCategory.VIDEO,
                Manufacturer.LG
        );
        addProduct(
                "LG 60\" UHD Display",
                "10-60",
                "100-555-667",
                450.0,
                ProductCategory.VIDEO,
                Manufacturer.LG
        );
        addProduct(
                "Cisco Webex EQ Codec NR++",
                "CS-CODEC-EQ-NR++",
                "CS-CODEC-EQ-NR++",
                1200.56,
                ProductCategory.VIDEO,
                Manufacturer.CISCO
        );
        addProduct(
                "Linksys 24 Port POE Switch x4 SFP ports",
                "LGS328MPC",
                "LGS328MPC",
                497.54,
                ProductCategory.NETWORKING,
                Manufacturer.LINKSYS
        );
    }

    private void bootStrapVendors() {
        addVendor(
                "Bob's TV's",
                "john@bobstv.com",
                "123-222-3333",
                "AL3403"
        );
        addVendor(
                "Ironhorse Industries",
                "larry@ironhorse.com",
                "345-555-6666",
                "RT00244"
        );
        addVendor(
                "LG Retail Sales",
                "tom@lgsales.com",
                "123-789-0067",
                "RY40012"
        );
    }
}
