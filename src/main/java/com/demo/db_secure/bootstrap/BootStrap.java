package com.demo.db_secure.bootstrap;

import com.demo.db_secure.domains.User;
import com.demo.db_secure.domains.products.Product;
import com.demo.db_secure.domains.products.GenericProduct;
import com.demo.db_secure.domains.products.Vendor;
import com.demo.db_secure.filters.Manufacturer;
import com.demo.db_secure.filters.ProductCategory;
import com.demo.db_secure.services.interfaces.ProductService;
import com.demo.db_secure.services.interfaces.UserService;
import com.demo.db_secure.services.interfaces.VendorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootStrap implements CommandLineRunner {

    private final ProductService productService;
    private final VendorService vendorService;
    private final UserService userService;

    public BootStrap(ProductService productService, VendorService vendorService, UserService userService) {
        this.productService = productService;
        this.vendorService = vendorService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Product> products = productService.findAll();
        List<Vendor> vendors = vendorService.findAll();
        List<User> users = userService.findAll();

        if (products.isEmpty()) {
            bootStrapProducts();
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
        this.productService.save(newProduct);
    }

    private void addVendor(Long id, String vendorName, String vendorEmail, String vendorPhoneNumber, String vendorCageCode) {
        Vendor vendor = new Vendor();
        vendor.setId(id);
        vendor.setName(vendorName);
        vendor.setPocEmail(vendorEmail);
        vendor.setPocPhoneNumber(vendorPhoneNumber);
        vendor.setCageCode(vendorCageCode);
        vendorService.save(vendor);
    }

    private void addUser(Long id, String firstName, String lastName, String userName, String password) {
        User newUser = new User();
        newUser.setId(id);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setUserName(userName);
        newUser.setPassword(password);
        this.userService.save(newUser);
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
}
