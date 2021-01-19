package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson3Hard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RequestMapping("Lesson3Hard")
@RestController
public class Lesson3Hard_Controller {
    // http://localhost:8080/Lesson3Hard/evenFib/6
    @GetMapping("evenFib/{x}")
    public int eveFibonacci(@PathVariable("x") int xVariable) {
        return Lesson3Hard.evenFibonacci(xVariable);
    }

    // http://localhost:8080/Lesson3Hard/morse/vali-it
    @GetMapping("morse/{text}")
    public String morseCode(@PathVariable("text") String textVariable) {
        return Lesson3Hard.morseCode(textVariable);
    }


    Random random = new Random();
    int randomNumber = random.nextInt(100);
    int count = 1;
    // http://localhost:8080/Lesson3Hard/randomGame/73 // arvamiseks vaja vahetada nr aadressi lõpus
    @GetMapping("randomGame/{guess}")
    public String randomGame(@PathVariable("guess") int guessVariable) {
        if ((guessVariable == randomNumber) && (count <= 10)) {
            int winCount = count; // salvestab count väärtuse, mida kuvada vastuse stringis
            count = 1; // äraarvamise puhul nullib counteri
            return "Tubli, arvasid ära " + winCount + ". korraga!";
        } else if (count >= 10) {
            count = 1;
            return "Ei arvanud ära, see oli viimane katse. Tegelik number oli " + randomNumber;
        } else if (guessVariable > randomNumber) {
            count ++;
            return "Proovi uuesti, number on väiksem " + guessVariable + "-st";
        } else {
            count ++;
            return "Proovi uuesti, number on suurem " + guessVariable + "-st";
        }
    }
}
