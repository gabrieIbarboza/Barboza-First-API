package com.gabrieibarboza.barboza.firstapi;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "firstApi")
public class BarbozaMeme {
    
    @Id
    private String id;
    private String title;
    private String imageUrl;
    private String quote;

    public BarbozaMeme() {
        
    }

    public BarbozaMeme(String title, String imageUrl, String quote) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.quote = quote;
    }
    
    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public String getQuote() {
        return quote;
    }

    

}
