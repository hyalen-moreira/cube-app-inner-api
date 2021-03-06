package com.cubeappinnerrapi.cubeappinnerapi.core.web;

import com.cubeappinnerrapi.cubeappinnerapi.core.model.HealthTipsModel;
import com.cubeappinnerrapi.cubeappinnerapi.core.service.HealthTipsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("healthTipsController_v1")
@RequestMapping(value = "/api/health-tips")
public class HealthTipsController {
    private HealthTipsService service;

    public HealthTipsController(HealthTipsService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<HealthTipsModel>> getAllHealthTips() {
        var tips = service.getAllHealthTips();

        return new ResponseEntity<>(tips, HttpStatus.OK);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<List<HealthTipsModel>> getHealthTipsByUserId(@PathVariable(value = "userId") long userId) {
        var tips = service.findByUserId(userId);

        return new ResponseEntity<>(tips, HttpStatus.OK);
    }
}
