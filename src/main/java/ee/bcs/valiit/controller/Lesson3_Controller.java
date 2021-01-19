package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson3;
import org.springframework.web.bind.annotation.*;


@RequestMapping("Lesson3")
@RestController
public class Lesson3_Controller {

    // http://localhost:8080/Lesson3/sum?x=6 // annab vastuseks 6? midagi on ikka valesti
    @GetMapping("sum")
    public int sum(@RequestParam("x") int[] xVariable) {
        return Lesson3.sum(xVariable);
    }

    // http://localhost:8080/Lesson3/sumS/6 // annab vastuseks 6? midagi on valesti
    @GetMapping("sumS/{x}")
    public int sumSiim(@PathVariable("x") int[] arrayVariable) {
        return Lesson3.sumSiim(arrayVariable);
    }

    // http://localhost:8080/Lesson3/fact/6
    @GetMapping("fact/{x}")
    public int factorial(@PathVariable("x") int xVariable) {
        return Lesson3.factorial(xVariable);
    }

    // http://localhost:8080/Lesson3/fact1?x=6
    @GetMapping("fact1")
    public int factorial1(@RequestParam("x") int xVariable) {
        return Lesson3.factorial1(xVariable);
    }

    // http://localhost:8080/Lesson3/sort?a=66,43,5,1,-1
    @GetMapping("sort")
    public int[] sort(@RequestParam("a") int[] aVariable) {
        return Lesson3.sort(aVariable);
    }

    // http://localhost:8080/Lesson3/sortNew?b=66,43,5,1,-1  // veebis toimib, aga koodis viga: vale tulemus
    @GetMapping("sortNew")
    public int[] sortNew(@RequestParam("b") int[] bVariable) {
        return Lesson3.sortNew(bVariable);
    }

    // http://localhost:8080/Lesson3/sort2/66,43,5,1,-1
    @GetMapping("sort2/{array}")
    public int[] sort2(@PathVariable("array") int[] arrayVariable) {
        return Lesson3.sort2(arrayVariable);
    }

    // http://localhost:8080/Lesson3/reverse1/lesson3
    @GetMapping("reverse1/{a}")
    public String reverseString(@PathVariable("a") String aVariable) {
        return Lesson3.reverseString(aVariable);
    }

    // http://localhost:8080/Lesson3/reverse2?a=harjutus
    @GetMapping("reverse2")
    public String reverseString2(@RequestParam("a") String aVariable) {
        return Lesson3.reverseString2(aVariable);
    }

    // http://localhost:8080/Lesson3/prime/6
    @GetMapping("prime/{x}")
    public boolean isPrime(@PathVariable("x") int xVariable) {
        return Lesson3.isPrime(xVariable);
    }

}
