package com.github.brianmmcclain.springhelloworld;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/env")
    @ResponseBody
    public String env() {
        String jvmVersion = System.getProperty("java.vm.version");
        String jvmName = System.getProperty("java.vm.name");

        String ret = "<h2>JVM: " + jvmName + " " + jvmVersion + "</h2><br /><br />";
        Map<String, String> env = System.getenv();
        for (String key : env.keySet()) {
            ret += "<b>" + key + "</b>: " + env.get(key) + "<br />";
        }
        return ret;
    }

}