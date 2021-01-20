package ee.bcs.valiit.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class TestController {
    @GetMapping("test")
    public String getHelloWorld() {
        return "Hello World";
        // Re-run DemoApplication
        // http://localhost:8080/test >> kuvab Hello World
    }

// kui panna nt tes? - siis toimib ükskõik mis, oluline, et alguses on tes
// vt slaidi kuidas veel saab defineerida

    // http://localhost:8080/test/Helena?name=Israel
    @GetMapping("test/{name}")
    public String getHelloWorld(@PathVariable("name") String userName, @RequestParam("name") String lastName) {
        return "Hello, " + userName + " " + lastName + "!";
    }

}