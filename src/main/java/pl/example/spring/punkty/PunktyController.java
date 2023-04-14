package pl.example.spring.punkty;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/punkty")
public class PunktyController {
    private List<String> users=new CopyOnWriteArrayList<>();

    {
        this.users.addAll(Arrays.asList("Student1", "Student2", "Student3"));
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<String> getUsers() {
        //return Arrays.asList("Student1", "Student2", "Student3");
        return this.users;
    }

    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public int addUser(@RequestBody String name) {
        this.users.add(name);
        return this.users.size();
    }
}
