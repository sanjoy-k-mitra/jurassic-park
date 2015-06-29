package com.rootnext.jurassicpark.api;

import com.rootnext.jurassicpark.model.CageRepository;
import com.rootnext.jurassicpark.model.Dinosaur;
import com.rootnext.jurassicpark.model.DinosaurRepository;
import com.rootnext.jurassicpark.model.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sanjoy on 6/29/15.
 */
@RestController
@RequestMapping("api/dinosaur")
public class DinosaurController {
    @Autowired
    DinosaurRepository dinosaurRepository;
    @Autowired
    SpeciesRepository speciesRepository;
    @Autowired
    CageRepository cageRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Dinosaur> list(){
        return dinosaurRepository.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Dinosaur get(@PathVariable("id") Integer id) {
        return dinosaurRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Dinosaur create(@RequestParam(value = "name") String name, @RequestParam(value = "speciesId") Integer speciesId, @RequestParam(value = "cageId", required = false) Integer cageId) {
        Dinosaur dinosaur = new Dinosaur(null, name);
        dinosaur.setSpecies(speciesRepository.findOne(speciesId));
        dinosaur.setCage(cageRepository.findOne(cageId));
        dinosaurRepository.save(dinosaur);
        return dinosaur;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public Dinosaur update(@PathVariable(value = "id") Integer id, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "speciesId", required = false) Integer speciesId, @RequestParam(value = "cageId", required = false) Integer cageId) {
        Dinosaur dinosaur = dinosaurRepository.findOne(id);
        if(name != null){
            dinosaur.setName(name);
        }
        if(speciesId != null){
            dinosaur.setSpecies(speciesRepository.findOne(speciesId));
        }
        if(cageId != null){
            dinosaur.setCage(cageRepository.findOne(cageId));
        }

        dinosaurRepository.save(dinosaur);
        return dinosaur;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Dinosaur delete(@PathVariable(value = "id") Integer id){
        Dinosaur dinosaur = dinosaurRepository.findOne(id);
        dinosaurRepository.delete(id);
        return dinosaur;
    }
}
