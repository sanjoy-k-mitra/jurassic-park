package com.rootnext.jurassicpark.api;

import com.rootnext.jurassicpark.model.CageRepository;
import com.rootnext.jurassicpark.model.Dinosaur;
import com.rootnext.jurassicpark.model.DinosaurRepository;
import com.rootnext.jurassicpark.model.SpeciesRepository;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @RequestMapping(method = RequestMethod.GET,produces = "application/json")
    public Iterable<Dinosaur> list(){
        return dinosaurRepository.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET,produces = "application/json")
    public Dinosaur get(@PathVariable("id") Long id) {
        return dinosaurRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST,produces = "application/json", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Dinosaur create(@RequestParam(value = "name")String name, @RequestParam(value = "species")Long speciesId, @RequestParam(value = "cage")Long cageId) throws Exception{
        Dinosaur dinosaur = new Dinosaur();
        dinosaur.setName(name);
        dinosaur.setSpecies(speciesRepository.findOne(speciesId));
        dinosaur.setCage(cageRepository.findOne(cageId));
        dinosaurRepository.save(dinosaur);
        return dinosaur;
    }

    @RequestMapping(method = RequestMethod.POST,produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Dinosaur createFromJson(@RequestBody String jsonString) throws Exception{
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(jsonString);
        Dinosaur dinosaur = new Dinosaur();
        String name = (String)jsonObject.get("name");
        JSONObject species = (JSONObject)jsonObject.get("species");
        JSONObject cage = (JSONObject)jsonObject.get("cage");
        Long speciesId = species!=null ? (Long)species.get("id") : null;
        Long cageId = cage!= null ? (Long)cage.get("id") : null;

        dinosaur.setName(name);
        dinosaur.setSpecies(speciesRepository.findOne(speciesId));
        dinosaur.setCage(cageRepository.findOne(cageId));
        dinosaurRepository.save(dinosaur);
        return dinosaur;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST,produces = "application/json", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Dinosaur update(@PathVariable(value = "id") Long id, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "speciesId", required = false) Long speciesId, @RequestParam(value = "cageId", required = false) Long cageId) throws Exception{
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

    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Dinosaur update(@PathVariable(value = "id") Long id, @RequestBody String jsonString) throws Exception{
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(jsonString);
        Dinosaur dinosaur = dinosaurRepository.findOne(id);
        String name = (String)jsonObject.get("name");
        JSONObject species = (JSONObject)jsonObject.get("species");
        JSONObject cage = (JSONObject)jsonObject.get("cage");
        Long speciesId = species!=null ? (Long)species.get("id") : null;
        Long cageId = cage!= null ? (Long)cage.get("id") : null;
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

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE,produces = "application/json")
    public Dinosaur delete(@PathVariable(value = "id") Long id){
        Dinosaur dinosaur = dinosaurRepository.findOne(id);
        dinosaurRepository.delete(id);
        return dinosaur;
    }
}
