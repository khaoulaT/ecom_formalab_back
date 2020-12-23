package formalab.gestion.produits.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "products_images")
public class ProductFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @NotNull(message = "Image name is required")
    private String fileName;
    @NotNull(message = "Image URI is required")
    private String fileDownloadUri;
    @NotNull(message = "Image type is required")
    private String fileType;
    @NotNull(message = "Image size is required")
    private long size;

    public ProductFile() {
    }

    public ProductFile(String fileName, String fileDownloadUri, String fileType, long size) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }

    public ProductFile(Long id, @NotNull(message = "Image name is required") String fileName, @NotNull(message = "Image URI is required") String fileDownloadUri, @NotNull(message = "Image type is required") String fileType, @NotNull(message = "Image size is required") long size) {
        Id = id;
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public void setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
