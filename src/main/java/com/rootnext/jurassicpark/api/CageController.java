package com.rootnext.jurassicpark.api;

import com.rootnext.jurassicpark.model.Cage;
import com.rootnext.jurassicpark.model.CageRepository;
import com.rootnext.jurassicpark.model.PowerStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sanjoy on 6/29/15.
 */
@RestController
@RequestMapping("api/cage")
public class CageController {
    @Autowired
    CageRepository cageRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Cage> get() {
        return cageRepository.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Cage get(@PathVariable("id") Integer id) {
        return cageRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Cage create(@RequestParam(value = "maxCapacity") Integer maxCapacity, @RequestParam(value = "powerStatus") String powerStatus) {
        Cage cage = new Cage(null, maxCapacity, PowerStatus.valueOf(powerStatus));
        cageRepository.save(cage);
        return cage;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public Cage update(@PathVariable(value = "id") Integer id, @RequestParam(value = "maxCapacity", required = false) Integer maxCapacity, @RequestParam(value = "powerStatus", required = false) String powerStatus) {
        Cage cage = cageRepository.findOne(id);
        if (maxCapacity != null) {
            cage.setMaxCapacity(maxCapacity);
        }
        if (powerStatus != null) {
            cage.setPowerStatus(PowerStatus.valueOf(powerStatus));
        }
        cageRepository.save(cage);
        return cage;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Cage delete(@PathVariable(value = "id") Integer id){
        Cage cage = cageRepository.findOne(id);
        cageRepository.delete(id);
        return cage;
    }


}
