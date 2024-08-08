package com.imv.unit_testing;

import lombok.ToString;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("Emp")
@ToString
public class EmpCtrol {
    @RequestMapping("/get")
    public Emp[] printEmp(@RequestParam("employees") String[] emp) {
        Arrays.stream(emp).forEach(System.out::println);
        Emp[] emps =Arrays.stream(emp).map(empStr->{
            String[] empStrArr = empStr.split(",");
            int id=Integer.parseInt(empStrArr[0]);
            String name=empStrArr[1];
            int age=Integer.parseInt(empStrArr[2]);
            return new Emp(id,name,age);
                }).toArray(Emp[]::new);

        return emps;
    }

}


//http://localhost:8080/Emp/get?employees=1,John,25&employees=2,Jane,30