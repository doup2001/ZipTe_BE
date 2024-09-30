package com.eedo.ZipTe.domain.entity.order;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id")
//    private Order order;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice;

    private int count;



//    public void addOrder(Order order){
//        this.order = order;
//    }
//
//    public static OrderItem createOrderItem(Item item, int orderPrice, int count) {
//
//        OrderItem orderItem = OrderItem.builder()
//                .item(item)
//                .orderPrice(orderPrice)
//                .count(count)
//                .build();
//
//        item.removeStock(count);
//
//        return orderItem;
//    }
//
//    public int cancel() {
//        getItem().addStock(count);
//        return count;
//    }

}
