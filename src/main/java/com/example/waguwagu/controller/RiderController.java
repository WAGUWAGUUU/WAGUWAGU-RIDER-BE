package com.example.waguwagu.controller;

import com.example.waguwagu.domain.entity.Rider;
import com.example.waguwagu.domain.request.ChangeActivationStateRequest;
import com.example.waguwagu.domain.request.RiderUpdateRequest;
import com.example.waguwagu.service.RiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/riders")
public class RiderController {
    private final RiderService riderService;
    // kafka로 rider 객체 받음

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public void saveRider(@RequestBody Rider rider) {
//        riderService.saveRider(rider);
//    }

    @GetMapping("/{id}")
    public Rider getById(@PathVariable Long id) {
        return riderService.getById(id);
    }

    @PutMapping("/{id}/activation")
    public void changeActivationState(@PathVariable Long id, @RequestBody ChangeActivationStateRequest req) {
        riderService.changeActivationState(id, req);
    }
}
