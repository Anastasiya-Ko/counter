package kopylva.counter.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import kopylva.counter.services.CounterService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/counter")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Tag(name = "Контроллер Счётчик")
public class CounterController {

    CounterService service;

    @GetMapping
    @Operation(summary = "Вычисляет частоту встречи символов по заданной строке и выводит результат в порядке убывания количества повторений",
               description = "Входящая строка может содержать буквы, цифры, спец.символы и пробелы")
    public String read(
            @RequestParam
            @Parameter(description = "Обрабатываемая строка", example = "aaaabbb") String text) {
        return service.read(text);
    }
}
