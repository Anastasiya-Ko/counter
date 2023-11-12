package kopylva.counter.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CounterService {
    public String read(String text) {

        if (text == null) {
            return "Строка не должна быть пустой";
        }

        Map<String, Integer> result = new HashMap<>();

        text.chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.groupingBy(Character::charValue))
                .forEach((key, value) -> result.put(String.valueOf(key), value.size()));

        return result.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .map(e -> String.format("\"%s\": %s", e.getKey(), e.getValue()))
                .collect(Collectors.joining(", "));
    }
}
