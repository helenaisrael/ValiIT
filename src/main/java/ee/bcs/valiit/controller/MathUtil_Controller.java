package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson1MathUtil;
import org.springframework.web.bind.annotation.*;

@RequestMapping("Lesson1MathUtil")
@RestController
public class MathUtil_Controller {

    // http://localhost:8080/Lesson1MathUtil/min1?a=5&b=9
    @GetMapping("min1")
    public int min1(@RequestParam("a") int aVariable, @RequestParam("b") int bVariable) {
        return Lesson1MathUtil.min(aVariable, bVariable);
    }

    // http://localhost:8080/Lesson1MathUtil/max1/5/9
    @GetMapping("max1/{a}/{b}")
    public int max(@PathVariable("a") int aVariable, @PathVariable("b") int bVariable) {
        return Lesson1MathUtil.max(aVariable, bVariable);
    }

    // http://localhost:8080/Lesson1MathUtil/abs/-9
    @GetMapping("abs/{a}")
    public int abs(@PathVariable("a") int aVariable) {
        return Lesson1MathUtil.abs(aVariable);
    }

    // http://localhost:8080/Lesson1MathUtil/isEven?a=9
    @GetMapping("isEven")
    public boolean isEven(@RequestParam("a") int aVariable) {
        return Lesson1MathUtil.isEven(aVariable);
    }

    // http://localhost:8080/Lesson1MathUtil/min2?a=9&b=-1&c=100
//    @GetMapping("min2")
//    public int min(@RequestParam("a") int aVariable, @RequestParam("b") int bVariable, @RequestParam("c") int cVariable) {
//      return Lesson1MathUtil.min(aVariable, bVariable, cVariable);
//    }
    // http://localhost:8080/Lesson1MathUtil/min2/9/-1/100
    @GetMapping("min2/{a}/{b}/{c}")
    public int min(@PathVariable("a") int aVariable, @PathVariable("b") int bVariable, @PathVariable("c") int cVariable) {
        return Lesson1MathUtil.min2(aVariable, bVariable, cVariable);
    }

    // http://localhost:8080/Lesson1MathUtil/max2?a=9&b=-1&c=100
    @GetMapping("max2")
    public int max(@RequestParam("a") int aVariable, @RequestParam("b") int bVariable, @RequestParam("c") int cVariable) {
        return Lesson1MathUtil.max2(aVariable, bVariable, cVariable);
    }
}
