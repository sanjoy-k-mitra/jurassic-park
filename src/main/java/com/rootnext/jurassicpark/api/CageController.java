package com.rootnext.jurassicpark.api;

import com.rootnext.jurassicpark.model.Cage;
import com.rootnext.jurassicpark.model.PowerStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sanjoy on 6/29/15.
 */
@RestController
public class CageController {

    @RequestMapping(value = "api/cage", method = RequestMethod.GET)
    public Cage get(){
        return new Cage(1l, 10, PowerStatus.ACTIVE);
    }
}
