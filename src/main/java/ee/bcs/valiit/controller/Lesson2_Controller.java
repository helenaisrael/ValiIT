package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson2;
import org.springframework.web.bind.annotation.*;

@RequestMapping("Lesson2")
@RestController
public class Lesson2_Controller {

    // http://localhost:8080/Lesson2/ex1web/3,5,6,7,8,9
    @GetMapping("ex1web/{resultArray}")
    public int[] exercise1Web(@PathVariable("resultArray") int[] resultArray) {
        return Lesson2.exercise1Web(resultArray);
    }

    // http://localhost:8080/Lesson2/exercise4?n=6
    @GetMapping("exercise4")
    public int exercise4(@RequestParam("n") int nVariable) {
        return Lesson2.exercise4(nVariable);
    }

    // http://localhost:8080/Lesson2/exercise5/3/10
    @GetMapping("exercise5/{x}/{y}")
    public String exercise5(@PathVariable("x") int xVariable, @PathVariable("y") int yVariable) {
        return Lesson2.exercise5(xVariable, yVariable);
    }

}
