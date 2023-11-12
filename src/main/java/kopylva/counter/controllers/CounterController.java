package kopylva.counter.controllers;


import kopylva.counter.services.CounterService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/counter")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CounterController {

    CounterService service;

    @GetMapping
    public String read(
            @RequestParam String text) {
        return service.read(text);
    }
}
