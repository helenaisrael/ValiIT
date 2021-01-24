package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping
@RestController
public class Employee_Controller {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    // DTO harjutuse jaoks loon listi
    private List<Employee> employeesList = new ArrayList<>();


    // http://localhost:8080/testEmployee?id=005&name=Mari_Maasikas&age=36&address=Tallinn
    @GetMapping("testEmployee")
    public Employee newEmployee1(@RequestParam("id") int id,
                                 @RequestParam("name") String name,
                                 @RequestParam("age") int age,
                                 @RequestParam("address") String address
    ) {
        Employee newEmployee1 = new Employee();
        newEmployee1.setId(005);
        newEmployee1.setName("Mari Maasikas");
        newEmployee1.setAge(36);
        newEmployee1.setAddress("Veeriku 10, Tallinn");

        String sql = "INSERT INTO employee (id, name, age, address) VALUES (:idParameter, :nameParameter, :ageParameter, :addressParameter)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("idParameter", newEmployee1.getId());
        paramMap.put("nameParameter", newEmployee1.getName());
        paramMap.put("ageParameter", newEmployee1.getAge());
        paramMap.put("addressParameter", newEmployee1.getAddress());
        jdbcTemplate.update(sql, paramMap);
        return newEmployee1;
    }

    // POST MAPPING (Postman)
    // http://localhost:8080/testEmployee // töötab ainult Postmanis
    @PostMapping("testEmployee")
    public void test(@RequestBody Employee newEmployee1) {
        System.out.println(newEmployee1.getName()); // see on lihtsalt endale tõestuseks, et server on selle kätte saanud, seda iseenesest pole vaja
    }


// NBNBNB: kui on vaja @RequestBody (turvalisem!), siis peab Postmanis olema alati raw + JSON (ja all kastis ka JSONi kujul andmed!
// NBNB: ühtegi @RequestParam (ehk peale ? ei tohi olla andmeid)

    // Exercise REST endpoint
    // Lisa uus
    // http://localhost:8080/employee
    @PostMapping("employee")
    public void addEmployee(@RequestBody Employee newEmployee1) {
        employeesList.add(newEmployee1);
    }

    // Vaata kõiki töötajaid
    // http://localhost:8080/employee/
    @GetMapping("employee")
    public List<Employee> getEmployees() {
        return employeesList;
    }

    // otsi konkreetne töötaja välja id järgi
    // http://localhost:8080/employee/3 // NB: see nr on index, st alates 0st!
    @GetMapping("employee/{id}")
    public Employee viewOneEmployee(@PathVariable("id") int id) {
        return employeesList.get(id);
    }

    // muuda ühe töötaja andmeid
    // http://localhost:8080/employee/3
    @PutMapping("employee/{id}")
    public void replaceEmployee(@RequestBody Employee newEmployee1, @PathVariable("id") int id) {
        employeesList.set(id, newEmployee1); // tahab int index ja Employee element
    }

    // kustuta üks töötaja
    // http://localhost:8080/employee/5
    @DeleteMapping("employee/{id}")
    public void removeEmployee(@PathVariable("id") int id) {
        employeesList.remove(id);
    }

}





//// http://localhost:8080/testEmployee/001/MariMaasikas/36/Tallinn - see ei toimi...?
//    @GetMapping("testEmployee/{id}/{name}/{age}/{address}")
//    public Employee testEmployee(@PathVariable("id") int id,
//                                 @PathVariable("name") String name,
//                                 @PathVariable("age") int age,
//                                 @PathVariable("address") String address) {
//        Employee testEmployee = new Employee();
//        testEmployee.setId(001);
//        testEmployee.setName("Mari Maasikas");
//        testEmployee.setAge(36);
//        testEmployee.setAddress("Veeriku 10, Tallinn");
//        return testEmployee;
//    }

