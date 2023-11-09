package musinsayoo.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import musinsayoo.ClothApplication;
import musinsayoo.domain.ClothDecreased;
import musinsayoo.domain.ClothIncreased;

@Entity
@Table(name = "Inventory_table")
@Data
//<<< DDD / Aggregate Root
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;

    private String productImg;

    private Integer stock;

    @PostUpdate
    public void onPostUpdate() {
        ClothDecreased clothDecreased = new ClothDecreased(this);
        clothDecreased.publishAfterCommit();

        ClothIncreased clothIncreased = new ClothIncreased(this);
        clothIncreased.publishAfterCommit();
    }

    public static InventoryRepository repository() {
        InventoryRepository inventoryRepository = ClothApplication.applicationContext.getBean(
            InventoryRepository.class
        );
        return inventoryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void decreaseCloth(DeliveryStarted deliveryStarted) {
        //implement business logic here:

        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        ClothDecreased clothDecreased = new ClothDecreased(inventory);
        clothDecreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);

            ClothDecreased clothDecreased = new ClothDecreased(inventory);
            clothDecreased.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void increaseCloth(DeliveryReturned deliveryReturned) {
        //implement business logic here:

        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        ClothIncreased clothIncreased = new ClothIncreased(inventory);
        clothIncreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryReturned.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);

            ClothIncreased clothIncreased = new ClothIncreased(inventory);
            clothIncreased.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
