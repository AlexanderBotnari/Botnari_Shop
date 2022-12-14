package com.example.botnari_shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.botnari_shop.entities.BaseEntity;
import com.example.botnari_shop.services.EntityService;

@CrossOrigin(origins="*")//< vulnerable point
public abstract class BaseController<T extends BaseEntity> {

	@Autowired
	EntityService<T> service;
	 
//    @GetMapping("/index")
//    public JSONResponse index(){
//        return new JSONResponse(ResponseStatus.SUCCES,service.all());
//    }
//    
//    @GetMapping("/index/{type}")
//    public JSONResponse indexByType(@PathVariable String type){
//        return new JSONResponse(ResponseStatus.SUCCES,service.allByType(type));
//    }
//
//    @GetMapping("/{id}")
//    public JSONResponse show(@PathVariable Integer id){
//        return new JSONResponse(ResponseStatus.SUCCES, service.find(id));
//    }
//
//    @PutMapping(value="/",consumes=MediaType.APPLICATION_JSON_VALUE)
//    public  JSONResponse update(@RequestBody T entity){
//    	service.save(entity);
//        return new JSONResponse(ResponseStatus.SUCCES, entity);
//    }
//
//    @PostMapping(value="/create",consumes=MediaType.APPLICATION_JSON_VALUE)
//    public JSONResponse create(@RequestBody T entity){
//    	service.save(entity);
//        return new JSONResponse(ResponseStatus.SUCCES,entity);
//    }
//
//    @DeleteMapping("/")
//    public JSONResponse delete(@RequestBody T entity){
//        service.delete(entity);
//        return new JSONResponse(ResponseStatus.SUCCES, entity);
//    }
}
