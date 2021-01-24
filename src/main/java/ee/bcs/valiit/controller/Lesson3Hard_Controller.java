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
    int count = 0;
    // http://localhost:8080/Lesson3Hard/randomGame/73 // >> arvamiseks vaja muuta nr URLi lõpus
    @GetMapping("randomGame/{guess}")
    public String randomGame(@PathVariable("guess") int guessVariable) {
        count++;
        if ((guessVariable == randomNumber) && (count <= 10)) {
            int winCount = count; // salvestab count väärtuse, mida kuvada vastuse stringis
            count = 0; // äraarvamise puhul nullib counteri
            randomNumber = random.nextInt(100);
            return "Tubli, arvasid ära " + winCount + ". korraga!";
        } else if (count >= 10) {
            count = 0;
            int oldRandomNumber = randomNumber;
            randomNumber = random.nextInt(100);
            return "Ei arvanud ära, see oli viimane katse. Tegelik number oli " + oldRandomNumber;
        } else if (guessVariable > randomNumber) {
            return "See oli " + count + ". katse. \n Proovi uuesti, number on väiksem " + guessVariable + "-st";
        } else {
            return "See oli " + count + ". katse. \n Proovi uuesti, number on suurem " + guessVariable + "-st";
        }
    }
}
