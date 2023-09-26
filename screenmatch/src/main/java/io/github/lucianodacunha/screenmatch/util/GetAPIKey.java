package io.github.lucianodacunha.screenmatch.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetAPIKey {

    public static String getAPIKey(){
        InputStream config = GetAPIKey.class.getClassLoader().getResourceAsStream(
                "application.properties");
        Properties prop = new Properties();

        try {
            prop.load(config);
        }  catch (IOException e){
            System.out.println("Erro ao carregar o arquivo de properties");
        }

        return prop.getProperty("apikey");

    }

}
