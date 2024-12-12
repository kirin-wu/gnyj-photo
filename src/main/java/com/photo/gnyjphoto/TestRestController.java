package com.photo.gnyjphoto;

import org.springframework.web.bind.annotation.*;

@RestController()
public class TestRestController {
   private static String name1 = "小王";
   private static String name2 = "小李";

   @GetMapping("student")
   public String getStudent(@RequestParam String name){
       System.out.println(name);
       if(name.contains("王")){
           return name1;
       }else {
           return name2;
       }
   }

   @PostMapping("/student")
   public String updateName  (@RequestParam String id,@RequestParam String name){
       System.out.println(name);
       System.out.println(name1);
       System.out.println(id instanceof String);
       System.out.println(id == "1");
       if(id.equals("1")){
           name1 = name;
           System.out.println(name1);
       }else if(id.equals("2")) {
           name2 = name;
       }
       return name1+name2;
   }

   @RequestMapping(value="/student",method = RequestMethod.PUT)
    public String student (@RequestParam String id,@RequestParam String name){
       if(id.equals("1")){
           name1 = name;
           System.out.println(name1);
       }else if(id.equals("2")) {
           name2 = name;
       }
       return "ok";
   }
}
