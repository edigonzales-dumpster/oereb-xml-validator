package ch.so.agi.oereb.server;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.ehi.oereb.schemas.oereb._1_0.extract.GetExtractByIdResponse;

@RestController
public class MainController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    Jaxb2Marshaller marshaller;

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        log.info("ping");
        return new ResponseEntity<String>("oereb-xml-validator", HttpStatus.OK);
    }
    
    @GetMapping("/dummy")
    public ResponseEntity<?> dummy() throws IOException {     
        int responseCode = 204;

        URL url = new URL("https://geo.so.ch/api/oereb/extract/reduced/xml/geometry/CH233274062061");

        HttpURLConnection connection = null;
        connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(4000);
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/xml");
        responseCode = connection.getResponseCode();
        log.debug("response code: " + String.valueOf(responseCode));
        
        if (responseCode != 200) {
            throw new IOException("response code: " + String.valueOf(responseCode));
        }
        
        File xmlFile = Files.createTempFile("oereb_extract_", ".xml").toFile();
        InputStream initialStream = connection.getInputStream();
        java.nio.file.Files.copy(initialStream, xmlFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        initialStream.close();
        log.debug("file downloaded: " + xmlFile.getAbsolutePath());

        
        StreamSource xmlSource = new StreamSource(xmlFile);
        GetExtractByIdResponse obj = (GetExtractByIdResponse) marshaller.unmarshal(xmlSource);        
        
        return new ResponseEntity<String>("dummy", HttpStatus.OK);
        //return new ResponseEntity<GetExtractByIdResponse>(obj, HttpStatus.OK);

    }
    
}
