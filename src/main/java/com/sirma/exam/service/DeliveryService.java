package com.sirma.exam.service;

import com.sirma.exam.dto.DeliveryRequest;
import com.sirma.exam.model.Delivery;
import com.sirma.exam.model.DeliveryStatus;
import com.sirma.exam.model.Gift;
import com.sirma.exam.model.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final List<Delivery> deliveries = new ArrayList<>();
    private final GiftService giftService;
    private final AtomicLong idCounter = new AtomicLong(1);

    public Delivery createDelivery(DeliveryRequest request) {
        for (Long giftId : request.getGiftIds()) {
            Gift gift = giftService.getGiftById(giftId);
            if (gift.getStatus() == Status.PENDING || gift.getStatus() == Status.DELIVERED) {
                throw new IllegalStateException("Gift with ID " + giftId + " must be READY or LOADED!");
            }
        }

        Delivery delivery = Delivery.builder()
                .id(idCounter.getAndIncrement())
                .address(request.getAddress())
                .recipientName(request.getRecipientName())
                .giftIds(new ArrayList<>(request.getGiftIds()))
                .deliveryStatus(DeliveryStatus.PLANNED)
                .estimatedArrival(request.getEstimatedArrival())
                .build();

        for (Long giftId : request.getGiftIds()) {
            giftService.getGiftById(giftId).setStatus(Status.LOADED);
        }

        deliveries.add(delivery);
        return delivery;
    }

    public Delivery updateDeliveryStatus(Long id, DeliveryStatus newStatus) {
        Delivery delivery = deliveries.stream()
                .filter( d-> d.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Delivery not found!"));

        if (delivery.getDeliveryStatus() == DeliveryStatus.DELIVERED
                && newStatus != DeliveryStatus.DELIVERED) {
            throw new IllegalStateException("Cannot change status of an already DELIVERED delivery!");
        }

        delivery.setDeliveryStatus(newStatus);

        if (newStatus == DeliveryStatus.DELIVERED) {
            for (Long giftId : delivery.getGiftIds()) {
                giftService.getGiftById(giftId).setStatus(Status.DELIVERED);
            }
        }

        return delivery;
    }

    public List<Delivery> getAllDeliveries () {
        return deliveries;
    }
}
