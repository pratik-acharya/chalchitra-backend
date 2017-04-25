package tech.pratik.apps.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Pratik on 3/17/17.
 */
@RestController
@RequestMapping("oauth")
public class TestController {
    @RequestMapping("oauth/token")
    public String get(){
        return null;

    }
}
