package com.sirma.exam.service;

import com.sirma.exam.dto.ElfRequest;
import com.sirma.exam.model.DeliveryStatus;
import com.sirma.exam.model.Elf;
import com.sirma.exam.model.Gift;
import com.sirma.exam.model.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class ElfService {

    private final List<Elf> elves = new ArrayList<>();
    private final GiftService giftService;
    private final AtomicLong idCounter = new AtomicLong(1);

    public Elf createElf(ElfRequest request) {
        Elf elf = Elf.builder()
                .id(idCounter.getAndIncrement())
                .name(request.getName())
                .skillLevel(request.getSkillLevel())
                .assignedGiftIds(new ArrayList<>())
                .build();
        elves.add(elf);
        return elf;
    }

    public List<Elf> getAllElves() {
        return elves;
    }

    public Elf getElfById (Long id) {
        return elves.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Elf not found!"));
    }

    public Elf assignGiftToElf (Long elfId, Long giftId) {
        Elf elf = getElfById(elfId);

        Gift gift = giftService.getGiftById(giftId);

        if (gift.getStatus() == Status.DELIVERED) {
            throw new IllegalStateException("Invalid status: Gift is already DELIVERED");
        }

        if (!elf.getAssignedGiftIds().contains(giftId)) {
            elf.getAssignedGiftIds().add(giftId);
        }

        return elf;
    }
}
