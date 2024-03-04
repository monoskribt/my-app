package com.example.task2;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/API/")
@RestController
public class Gender_Identeficator_Controller {
    private final GenderIdenteficatorService service;

    public Gender_Identeficator_Controller(GenderIdenteficatorService service) {
        this.service = service;
    }

    @GetMapping("/First/{Name}")
    public String methodFirst(@PathVariable("Name") String name) {
        return service.identificatorGenderFirstTokens(name);
    }


    @GetMapping("/All/{Name}")
    public String methodAll(@PathVariable("Name") String name) {
        return service.identificatorGenderAllTokens(name);
    }

    @DeleteMapping("/{Name}")
    public boolean removeName(@PathVariable("Name") String name) {
        return service.removeNameFromFile(name);
    }

}
