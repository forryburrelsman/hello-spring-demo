package org.launchcode.hellospring.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloSpringController {

    // Responds to get requests at /hello?coder=LaunchCoder
    @GetMapping("hello")
    @ResponseBody
    public String hello(@RequestParam String coder){
        return "Hello " + coder;
    }

    // Responds to get requests at /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloAgain(@PathVariable String name){
        return "Hello, " + name;
    }

    // responds to post requests at "/goodbye"
    @PostMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, world";
    }

    @RequestMapping(value = "hellogoodbye", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hellogoodbye(){
         return "Hello world, goodbye world.";
    }


}
