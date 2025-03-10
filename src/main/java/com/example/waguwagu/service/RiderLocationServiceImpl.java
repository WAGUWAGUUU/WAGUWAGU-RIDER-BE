package com.example.waguwagu.service;

import com.example.waguwagu.domain.entity.Rider;
import com.example.waguwagu.domain.entity.RiderLocation;
import com.example.waguwagu.domain.dto.request.RiderLocationRequest;
import com.example.waguwagu.domain.dto.response.RiderLocationResponse;
import com.example.waguwagu.domain.type.Transportation;
import com.example.waguwagu.global.exception.RiderLocationNotFoundException;
import com.example.waguwagu.global.repository.RiderLocationRedisRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderLocationServiceImpl implements RiderLocationService {
    private final RiderLocationRedisRepository riderLocationRedisRepository;
    private final RiderService riderService;

    @Override
    public void saveRiderLocation(RiderLocationRequest req) {
        log.info(req.toString());
        riderLocationRedisRepository.save(req.toEntity());
        log.info("success");
    }

    @Override
    public RiderLocationResponse getByOrderId(UUID orderId) {
        RiderLocation location = riderLocationRedisRepository.findById(orderId)
                .orElseThrow(RiderLocationNotFoundException::new);
        log.info(location.toString());
        Rider rider = riderService.getById(location.getRiderId());
        log.info(rider.toString());
        Transportation transportation = rider.getTransportation();
        RiderLocationResponse res = RiderLocationResponse.from(location, transportation);
        return res;
    }

    @Override
    public void deleteByOrderId(UUID orderId) {
        RiderLocation location = riderLocationRedisRepository.findById(orderId)
                .orElseThrow(RiderLocationNotFoundException::new);
        riderLocationRedisRepository.deleteById(orderId);
    }
}
