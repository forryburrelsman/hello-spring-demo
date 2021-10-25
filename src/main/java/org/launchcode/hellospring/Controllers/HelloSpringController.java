package org.launchcode.hellospring.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("hello")
public class HelloSpringController {

    // lives at /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, world";
    }


    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }


    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String lang){
        if (name==null){
            name = "World";
        }
        return createMessage(name, lang);
    }

    public static String createMessage(String name, String lang){
        String language = "";
        if (lang.equals("english") || lang.equals("")) {
            language = "Hello, " + name;
        }
        else if (lang.equals("french")) {
            language= "Bonjour, " + name;
        }
        else if (lang.equals("spanish")){
            language =  "Hola, "+ name;
        }
        else if (lang.equals("italian")){
            language = "Bonjourno, "+ name;
        }
        else if (lang.equals("german")){
            language = "Hallo, "+ name;
        }
        return language;
    }

    // hello/form
    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        String html =
                "<html>" +
                        "<body>" +
                        "<form action = '/hello' method = 'post'>" + //submit a request to /hello
                        "<input type = 'text' name = 'name' />" +
                        "<select name='lang' id='lang'>"+
                        "<option value=''>Please choose a language</option>" +
                        "<option value='english'>English</option>"+
                        "<option value='french'>French</option>"+
                        "<option value='italian'>Italian</option>"+
                        "<option value='spanish'>Spanish</option>"+
                        "<option value='german'>German</option>"+
                        "</select>"+
                        "<input type = 'submit' value = 'Greet Me!' />" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
    }



}
