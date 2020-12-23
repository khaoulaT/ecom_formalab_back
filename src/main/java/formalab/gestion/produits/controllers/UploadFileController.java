package formalab.gestion.produits.controllers;

import formalab.gestion.produits.config.FileStorageProperties;
import formalab.gestion.produits.entities.ProductFile;
import formalab.gestion.produits.repositories.ProductFileRepository;
import formalab.gestion.produits.services.ProductFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/uploads")
public class UploadFileController {

    @Autowired
    ProductFileRepository productFileRepository;

    @Autowired
    private ProductFileService productFileService;

    @PostMapping(value = {"","/"}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductFile> uploadFile(@RequestParam("file") MultipartFile file ) throws  Exception{
        ProductFile productFile= productFileService.saveFile(file);
        return new ResponseEntity<>(productFile, HttpStatus.OK);
    }
}
