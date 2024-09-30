package com.eedo.ZipTe.domain.order.entity;

import com.eedo.ZipTe.domain.member.entity.member.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Table(name = "orders")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_email")
    private Member member;

//    @Builder.Default
//    @OneToMany(mappedBy = "order")
//    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderItem_id")
    private OrderItem orderItem;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus OrderStatus;


//    // 연관성 로직
//    public void setMember(Member member) {
//        this.member = member;
//        member.addOrder(this);
//    }
//
//    public void setDelivery(Delivery delivery) {
//        this.delivery = delivery;
//        delivery.addOrder(this);
//    }
//
//    public void setOrderDate(LocalDateTime orderDate) {
//        this.orderDate = orderDate;
//    }
//
////    public void addOrderItem(OrderItem orderItem) {
////        orderItems.add(orderItem);
////        orderItem.addOrder(this);
////    }
//
//    public void setOrderStatus(OrderStatus orderStatus) {
//        this.OrderStatus = orderStatus;
//    }
//
//
//    //비즈니스 로직
//
//    public static Order createOrder(Member member, Delivery delivery, OrderItem o) {
//
//
//        Order.builder()
//                .member(member)
//                .delivery(delivery)
//                .orderItem(orderItem);
//
//
//        Order order = new Order();
//        order.setMember(member);
//        order.setDelivery(delivery);
//        for (OrderItem orderItem : orderItems) {
//            order.addOrderItem(orderItem);
//        }
//        order.setOrderStatus(com.eedo.ZipTe.domain.entity.order.OrderStatus.ORDER);
//        order.setOrderDate(LocalDateTime.now());
//        return order;
//    }
//
//    //==비즈니스 로직==//
//    public int cancel() {
//        int count = 0;
//        if (delivery.getDeliveryStatus() == DeliveryStatus.COMPL) {
//            throw new IllegalStateException("이미 배송완료된 상품은 취소가 불가능합니다.");
//        }
//        this.setOrderStatus(com.eedo.ZipTe.domain.entity.order.OrderStatus.CANCEL);
//        for (OrderItem orderItem : orderItems) {
//            int cancel = orderItem.cancel();
//            count += cancel;
//        }
//        return count;
//    }
}
