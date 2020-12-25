package formalab.gestion.produits.services;

import formalab.gestion.produits.entities.Product;
import formalab.gestion.produits.entities.ProductFile;
import formalab.gestion.produits.repositories.ProductFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Service
public class ProductFileService {

    @Autowired
    ProductFileRepository productFileRepository;

    public ProductFile saveFile(MultipartFile file, Long productId) throws Exception{
        //TODO: set path as global variable

        // move file to the specified directory
        File convertFile = new File("D:\\produits\\templates.uploads\\"+file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout= new FileOutputStream(convertFile);//
        fout.write(file.getBytes());
        fout.close();

        //save to DB
        ProductFile img= new ProductFile(file.getOriginalFilename(),"D:\\produits\\templates.uploads\\"+file.getOriginalFilename(),
                file.getContentType(),file.getSize(), productId);
        return  productFileRepository.save(img);
    }

    public List <ProductFile> findByProductId(Long id){
        return productFileRepository.findByProductId(id);
    }
}
