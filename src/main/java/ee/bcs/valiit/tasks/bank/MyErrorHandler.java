package ee.bcs.valiit.tasks.bank;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyErrorHandler {
    @ExceptionHandler(BankException.class)
    public ResponseEntity<Object> handleBankException(Exception ex) {
        System.out.println("handle exception here");
        ErrorResponse response = new ErrorResponse();
        response.setMessage(ex.getMessage());
        return new ResponseEntity<Object>(new ErrorResponse(), new
                HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleError(Exception ex) {
        System.out.println("handle exception here");
        ErrorResponse response = new ErrorResponse();
        response.setMessage("Testin, mis juhtub");
        return new ResponseEntity<Object>(response, new
                HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
