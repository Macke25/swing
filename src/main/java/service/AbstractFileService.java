package service;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.logging.Logger;

public abstract class AbstractFileService<T> {
    protected String path;
    private Logger logger;

    protected AbstractFileService(Logger logger) {
        this.logger = logger;
    }

    public void save(T genericDto){
        try{
            PrintWriter printWriter = new PrintWriter(this.path);
            printWriter.println(new Gson().toJson(genericDto));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public Optional<T> load(){
        try {
            logger.info("Attempt to load data from: " + path);
            String json = new String(Files.readAllBytes(Paths.get(path)));
            return Optional.of(unJson(json));
        } catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

   protected T unJson (String s){

       return null;

   }
}
