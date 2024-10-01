package com.eedo.ZipTe.domain.entity.order;

import com.eedo.ZipTe.domain.entity.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private long id;

    @Embedded
    private Address address;

    @OneToOne(mappedBy = "delivery",fetch = FetchType.LAZY)
    private Order order;

    @Enumerated(EnumType.ORDINAL)
    private DeliveryStatus deliveryStatus;

//    비즈니스 모델
    public void addOrder(Order order){
        this.order = order;
    }
}
