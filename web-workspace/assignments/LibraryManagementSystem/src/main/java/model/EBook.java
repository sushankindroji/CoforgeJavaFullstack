package model;

import javax.persistence.*;

@Entity
@Table(name = "ebooks")
public class EBook extends Book {
    private String fileFormat;
    private double fileSize; // in MB
    private String downloadLink;

    // Getters & Setters
    public String getFileFormat() { return fileFormat; }
    public void setFileFormat(String fileFormat) { this.fileFormat = fileFormat; }
    public double getFileSize() { return fileSize; }
    public void setFileSize(double fileSize) { this.fileSize = fileSize; }
    public String getDownloadLink() { return downloadLink; }
    public void setDownloadLink(String downloadLink) { this.downloadLink = downloadLink; }
}