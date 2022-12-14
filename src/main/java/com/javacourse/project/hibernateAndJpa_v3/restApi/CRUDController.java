package com.javacourse.project.hibernateAndJpa_v3.restApi;

import com.javacourse.project.hibernateAndJpa_v3.business.CRUDService;
import com.javacourse.project.hibernateAndJpa_v3.entities.CRUD;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@CrossOrigin
@RestController
public class CRUDController {
    public CRUDService crudService;


    public CRUDController(CRUDService crudService) {
        this.crudService = crudService;
    }

    @PostMapping("/create")
    public String createCRUD(@RequestBody CRUD crud)throws InterruptedException, ExecutionException{
        return crudService.createCRUD(crud);
    }
    @GetMapping("/get")
    public CRUD getCRUD(@RequestParam String documentId)throws InterruptedException, ExecutionException{
        return crudService.getCRUD(documentId);
    }

    @PutMapping("/update")
    public String updateCRUD(@RequestBody CRUD crud) throws ExecutionException, InterruptedException {
        return crudService.updateCRUD(crud);
    }

    @PutMapping("/delete")
        public String deleteCRUD(@RequestParam String documentId){
        return crudService.deleteCRUD(documentId);
    }
    @GetMapping("/test")
    public ResponseEntity<String> testGetEndpoint() { return ResponseEntity.ok("hibernateAndJpa_v3 Test Get Endpoint is Working");}
}
