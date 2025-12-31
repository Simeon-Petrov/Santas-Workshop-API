package com.sirma.exam.service;

import com.sirma.exam.dto.GiftRequest;
import com.sirma.exam.model.Category;
import com.sirma.exam.model.Gift;
import com.sirma.exam.model.Status;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GiftService {

    private final List<Gift> gifts = new ArrayList<>();

    private final AtomicLong idCounter = new AtomicLong(1);

    public Gift createGift(GiftRequest request) {
        Gift newGift = Gift.builder()
                .id(idCounter.getAndIncrement())
                .name(request.getName())
                .category(request.getCategory())
                .targetAge(request.getTargetAge())
                .isWrapped(false)
                .status(Status.PENDING)
                .build();

        gifts.add(newGift);
        return newGift;
    }

    public List<Gift> getAllGifts() {
        return gifts;
    }

    public Gift getGiftById(Long id) {
        return gifts.stream()
                .filter(gift -> gift.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Gift not found!"));
    }

    public void deleteGift(Long id) {
        gifts.removeIf(gift -> gift.getId().equals(id));
    }

    public Gift wrapGift(Long id) {
        Gift gift = getGiftById(id);
        gift.setWrapped(true);
        gift.setStatus(Status.READY);
        return gift;
    }

    public List<Gift> getGiftsByStatus(Boolean wrapped) {
        if (wrapped == null) {
            return gifts;
        }
        return gifts.stream()
                .filter(gift -> gift.isWrapped() == wrapped)
                .collect(java.util.stream.Collectors.toList());
    }

    public List<Gift> searchGiftsByName (String query) {
        return gifts.stream()
                .filter(gift -> gift.getName().toLowerCase().contains(query.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
    }

    public List<Gift> getGiftsFiltered(Status status, Category category, Boolean wrapped) {
        return gifts.stream()
                .filter(g -> status == null || g.getStatus() == status)
                .filter(g-> category == null || g.getCategory() == category)
                .filter(g-> wrapped == null || g.isWrapped() == wrapped)
                .collect(java.util.stream.Collectors.toList());
    }
}

