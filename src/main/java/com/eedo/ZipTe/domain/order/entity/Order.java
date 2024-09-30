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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderItem_id")
    private OrderItem orderItem;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus OrderStatus;


    // 연관성 로직
    public void setMember(Member member) {
        this.member = member;
        member.addOrder(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.addOrder(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
        orderItem.addOrder(this);
    }

    //비즈니스 로직

    public static Order createOrder(Member member, Delivery delivery, OrderItem orderItem) {

        Order order = new Order();
        order.setMember(member);
        order.setDelivery(delivery);
        order.addOrderItem(orderItem);

        order.OrderStatus = com.eedo.ZipTe.domain.order.entity.OrderStatus.ORDER;
        order.orderDate= LocalDateTime.now();
        return order;
    }


    public int cancel() {
        int count = 0;
        if (delivery.getDeliveryStatus() == DeliveryStatus.COMP) {
            throw new IllegalStateException("이미 배송완료된 상품은 취소가 불가능합니다.");
        }

        this.OrderStatus = com.eedo.ZipTe.domain.order.entity.OrderStatus.CANCEL;

        int cancel = this.orderItem.cancel();
        count += cancel;

        return count;
    }
}
