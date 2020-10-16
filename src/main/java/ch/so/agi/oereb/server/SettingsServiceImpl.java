package ch.so.agi.oereb.server;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.stream.StreamSource;
import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.gwt.user.server.rpc.SerializationPolicy;
import com.google.gwt.user.server.rpc.SerializationPolicyLoader;

import ch.ehi.oereb.schemas.oereb._1_0.extract.GetExtractByIdResponse;
import ch.so.agi.oereb.shared.SettingsResponse;
import ch.so.agi.oereb.shared.SettingsService;

public class SettingsServiceImpl extends RemoteServiceServlet implements SettingsService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    Jaxb2Marshaller marshaller;

    @Value("${app.myVar}")
    private String myVar;

    @Override
    public void init() throws ServletException {
         super.init();
         SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
    }
    
    @Override
    protected SerializationPolicy doGetSerializationPolicy(HttpServletRequest request, String moduleBaseURL, String strongName) {
//        if(GWT.isScript()) {
//            return ContextRemoteServiceServlet.loadSerializationPolicy(this, request, moduleBaseURL, strongName);
//        } else {
//            return super.doGetSerializationPolicy(request, moduleBaseURL, strongName);
//        }
        
        log.info(request.toString());
        log.info(moduleBaseURL.toString());
        log.info(strongName);
        
        //return super.doGetSerializationPolicy(request, moduleBaseURL, strongName);
        return SettingsServiceImpl.loadSerializationPolicy(this, request, moduleBaseURL, strongName);


    }
    
    
    static SerializationPolicy loadSerializationPolicy(HttpServlet servlet, HttpServletRequest request,
            String moduleBaseURL, String strongName) {
        // The serialization policy path depends only by context path
        String contextPath = request.getContextPath();
        servlet.log("contextPath: " + contextPath);
        SerializationPolicy serializationPolicy = null;
        String contextRelativePath = contextPath + "/";
        String serializationPolicyFilePath = SerializationPolicyLoader
                .getSerializationPolicyFileName(contextRelativePath + strongName);

         servlet.log("serializationPolicyFilePath: "+serializationPolicyFilePath);
        
        // Open the RPC resource file and read its contents.
        //InputStream is = servlet.getServletContext().getResourceAsStream("/module1/"+serializationPolicyFilePath);
         InputStream is = null;
        try {
            URL url = new URL("http://localhost:8080/module1"+serializationPolicyFilePath);

            HttpURLConnection connection = null;
            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(4000);
            connection.setRequestMethod("GET");
//            connection.setRequestProperty("Accept", "application/xml");
            

            
             is = connection.getInputStream();

        } catch (Exception e) {
            e.printStackTrace();
        }

        
        
        try {
            if (is != null) {
                try {
                    serializationPolicy = SerializationPolicyLoader.loadFromStream(is, null);
                } catch (ParseException e) {
                    servlet.log("ERROR: Failed to parse the policy file '" + serializationPolicyFilePath + "'", e);
                } catch (IOException e) {
                    servlet.log("ERROR: Could not read the policy file '" + serializationPolicyFilePath + "'", e);
                }
            } else {
                String message = "ERROR: The serialization policy file '" + serializationPolicyFilePath
                        + "' was not found; did you forget to include it in this deployment?";
                servlet.log(message);
            }
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    // Ignore this error
                }
            }
        }

        return serializationPolicy;
    }

    
    @Override
    public SettingsResponse settingsServer() throws IllegalArgumentException, IOException {
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

        
        HashMap<String,Object> settings = new HashMap<String,Object>();        
        settings.put("MY_VAR", myVar);
        
        settings.put("EXTRACT", obj);
        
        SettingsResponse response = new SettingsResponse();
        response.setSettings(settings);
        return response;
    }
}
