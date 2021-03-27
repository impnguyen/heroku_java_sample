package com.inccrativ.herokujava;


import java.util.Map;
import com.google.cloud.translate.*;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/v1")
public class TestController {
    
    @GetMapping("/hello")
	public String hello(){
		return "Hello world";
	} 

    @GetMapping("/track")
    public Map<String, String> trackUser(
      @RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> {
            System.out.println(String.format("Header '%s' = %s", key, value));
        });
    
        // return new ResponseEntity<String>(
        //   String.format("Listed %d headers", headers.size()), HttpStatus.OK);
        return headers;
    }

    //how to call: 
    @GetMapping("/translate")
    public String translateForPro(@RequestParam String source) {
        Translate translate = TranslateOptions.getDefaultInstance().getService();
        Translation translation = translate.translate(source);

        return "Translated to english:" + translation.getTranslatedText();
    }

}
