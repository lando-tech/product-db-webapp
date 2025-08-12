# yaj-product-db (Yet Another Java Product Database)

A Spring Boot web application designed for managing products and vendors in a secure database environment. This application provides a comprehensive solution for product catalog management with features for adding, viewing, and managing products and their associated vendors.

## 🚀 Features

### Product Management
- **Add Products**: Create new products with detailed information including:
  - Product name, part number, and manufacturer part number
  - Price and category classification
  - Manufacturer selection from predefined options
  - Detailed product descriptions (facts, installation notes, general description)
- **View Products**: Browse all products with filtering capabilities
- **Update Products**: Edit existing product information
- **Delete Products**: Remove products from the catalog
- **Filter Products**: Filter by category and manufacturer
- **Search Products**: Find products by keyword

### Vendor Management
- **Add Vendors**: Register new vendors with contact information
- **View Vendors**: Display all registered vendors
- **Vendor-Product Association**: Link vendors with products they supply

### Product Filters
- Filters are handled via enum class objects
- New filters can easily be added


## 🛠️ Technology Stack

- **Framework**: Spring Boot 3.5.3
- **Language**: Java 21
- **Database**: H2 Database (file-based persistence)
- **Web Framework**: Spring MVC
- **Template Engine**: Thymeleaf
- **ORM**: Spring Data JPA with Hibernate
- **Validation**: Jakarta Bean Validation
- **Build Tool**: Gradle (Kotlin DSL)
- **Frontend**: Bootstrap 5.1.3

## 📋 Prerequisites

- Java 21 or higher
- Gradle 7.0 or higher (wrapper included)

## 🚀 Getting Started

### Clone the Repository
```bash
git clone https://github.com/lando-tech/product-db-webapp.git
cd product-db-webapp
```

### Build and Run
```bash
# Using Gradle wrapper (recommended)
./gradlew bootRun

# Or build first, then run
./gradlew build
java -jar build/libs/db_secure-0.0.1-SNAPSHOT.jar
```

### Access the Application **(Dev env only)**
- **Main Application**: http://localhost:8080
- **H2 Database Console**: http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:file:~/spring-boot-h2-db102-v3`
  - Username: `sa`
  - Password: (empty)

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/easyrok/db_secure/
│   │   ├── Main.java                          # Application entry point
│   │   ├── controllers/                       # MVC Controllers
│   │   │   ├── AddProductFormController.java
│   │   │   ├── AddVendorFormController.java
│   │   │   ├── DashboardController.java
│   │   │   ├── ProductViewController.java
│   │   │   ├── VendorViewController.java
│   │   │   └── SiteSurveyController.java
│   │   ├── models/                           # Entity classes
│   │   │   ├── Product.java                  # Abstract base class
│   │   │   ├── GenericProduct.java           # Concrete product implementation
│   │   │   ├── ProductDescription.java       # Product details
│   │   │   ├── Vendor.java                   # Vendor entity
│   │   │   ├── User.java                     # User entity
│   │   │   ├── Auditor.java                  # Audit tracking
│   │   │   └── ProductAuditor.java           # Product-specific auditing
│   │   ├── repositories/                     # Data access layer
│   │   │   ├── ProductRepo.java
│   │   │   ├── VendorRepo.java
│   │   │   └── ProductDescriptionRepo.java
│   │   ├── services/                         # Business logic layer
│   │   │   ├── ProductService.java
│   │   │   ├── ProductServiceImpl.java
│   │   │   ├── VendorService.java
│   │   │   ├── VendorServiceImpl.java
│   │   │   └── ProductFilterServiceImpl.java
│   │   ├── filters/                          # Enums and filters
│   │   │   ├── ProductCategory.java
│   │   │   ├── Manufacturer.java
│   │   │   └── ProductFilter.java
│   │   └── validators/                       # Custom validators
│   └── resources/
│       ├── application.properties            # Application configuration
│       ├── static/                          # Static resources
│       └── templates/                       # Thymeleaf templates
│           ├── dashboard.html
│           ├── productForm.html
│           ├── productView.html
│           ├── vendorForm.html
│           ├── vendorView.html
│           └── fragments/
└── test/                                    # Test classes
```

## 🔧 Configuration

### Database Configuration
The application uses H2 database with file-based persistence. Configuration in `application.properties`:

```properties
# H2 Database
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:file:~/spring-boot-h2-db102-v3
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driverClassName=org.h2.Driver

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## 🌐 API Endpoints

### Product Endpoints
- `GET /dashboard` - Application dashboard
- `GET /productForm` - Add new product form
- `POST /productForm` - Submit new product
- `GET /productView` - View all products (with filtering)
- `GET /showProductUpdateForm/{id}` - Edit product form
- `POST /deleteProduct/{id}` - Delete product

### Vendor Endpoints
- `GET /vendorForm` - Add new vendor form
- `POST /vendorForm` - Submit new vendor
- `GET /vendorView` - View all vendors

### Other Endpoints
- `GET /siteSurveyForm` - Site survey form
- `GET /h2-console` - Database console

## 📊 Database Schema

### Key Entities

#### Product
- `id` (Primary Key)
- `name` (Product name)
- `partNumber` (Internal part number)
- `manufacturerNumber` (Manufacturer's part number)
- `price` (Product price)
- `productCategory` (Category enum)
- `manufacturer` (Manufacturer enum)
- `auditor` (Audit information)

#### Vendor
- `id` (Primary Key)
- `name` (Vendor name)
- `pocEmail` (Point of contact email)
- `pocPhoneNumber` (Contact phone)
- `cageCode` (Commercial and Government Entity Code)

#### ProductDescription
- `id` (Primary Key)
- `productFacts` (Product specifications)
- `installationDescription` (Installation notes)
- `generalDescription` (General description)
- `product` (One-to-one relationship with Product)

## 🔒 Security Features

- Input validation using Jakarta Bean Validation
- SQL injection protection through JPA/Hibernate
- XSS protection through Thymeleaf templating
- Audit trail for product changes

## 🧪 Testing

Run the test suite:
```bash
./gradlew test
```

## 🚧 Current Development Status

This project is actively under development. See `TODO.md` for current development priorities and planned features.

### Recently Completed
- ✅ Core product CRUD operations
- ✅ Vendor management system
- ✅ Product filtering and search
- ✅ Audit trail implementation
- ✅ Form validation

### In Progress
- 🔄 UI/UX improvements
- 🔄 Advanced search functionality
- 🔄 Inventory tracking features

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 📞 Support

For support and questions, please contact the development team or create an issue in the repository.

## 🏗️ Build Information

- **Group**: com.demo
- **Artifact**: db_secure
- **Version**: 0.0.1-SNAPSHOT
- **Java Version**: 21
- **Spring Boot Version**: 3.5.3
