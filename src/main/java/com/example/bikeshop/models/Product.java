package com.example.bikeshop.models;

import com.example.bikeshop.models.enums.ProductCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "title")
    private String title;

    @Column(name = "quantity_in_stock")
    private Integer quantityInStock;

    @Column(name = "article_number")
    private String articleNumber;

    @Column(name = "price")
    private Integer price;

    @Column(name = "discount")
    private Integer discount;

    @Column(name = "is_active")
    private boolean isActive;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Image> images = new ArrayList<>();

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ProductInformation productInformation;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ShoppingCartItem> shoppingCartItem;

    @ElementCollection(targetClass = ProductCategory.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"))
    @Enumerated(EnumType.STRING)
    private Set<ProductCategory> productCategories = new HashSet<>();

    @PrePersist
    private void init() {
        creationDate = LocalDateTime.now();
        isActive = true;

        long currentTimeMillis = System.currentTimeMillis();
        String currentTimeString = Long.toString(currentTimeMillis);
        articleNumber = currentTimeString.substring(currentTimeString.length() - 6);
    }

    public String getFormattedDate() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("en"));
        return creationDate.format(formatter);
    }

    public String getFormatCategory() {

        int countUnderlineSymbols = (int) this.getProductCategories().toString().chars().filter(ch -> ch == '_').count();
        String workString = this.getProductCategories().toString().replace("[", "").replace("]", "");

        if(countUnderlineSymbols == 0) {
            return workString.charAt(0) + workString.substring(1).toLowerCase();
        }

        StringBuilder stringBuilder = new StringBuilder();
        int tempIndex = 0;
        int index;
        for (int i = 0; i < countUnderlineSymbols; i++) {
            index = workString.indexOf("_", tempIndex);
            if(i + 1 == countUnderlineSymbols) {
                stringBuilder.append(workString.charAt(tempIndex))
                        .append(workString.substring(tempIndex + 1, index).toLowerCase())
                        .append(" ");
                tempIndex = index + 1;
                stringBuilder.append(workString.charAt(tempIndex))
                        .append(workString.substring(tempIndex + 1).toLowerCase());
            }
            else
                stringBuilder.append(workString.charAt(tempIndex))
                        .append(workString.substring(tempIndex + 1, index).toLowerCase())
                        .append("-");
            tempIndex = index + 1;
        }
        return stringBuilder.toString();
    }

    public boolean ifDiscountLower () {

        if(this.discount != null)
            return this.discount < this.price;

        return true;
    }

    public boolean ifQuantity () {

        if(this.quantityInStock != null)
            return this.quantityInStock > 0;

        return false;
    }

    public void addImageToProduct(Image image) {

        image.setProduct(this);
        images.add(image);
    }

    public String getFormattedPrice(int price) {

        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        return numberFormat.format(price) + " $";
    }
}
