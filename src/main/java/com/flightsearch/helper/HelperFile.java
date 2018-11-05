package com.flightsearch.helper;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Cette Classe est utilisée pour récupérer le fichier Json qui contient la liste des vols
 */
public class HelperFile {

    private static String PATH_RESOURCE = "static/json/";

    public static String loadFileJson (String nameFile) {

        String contentFile = null;

        try{

            contentFile = new String(Files.readAllBytes(Paths.get(HelperFile.class.getClassLoader().getResource(PATH_RESOURCE + nameFile).toURI())));

        } catch (Exception e) {

        }


        return contentFile;
    }
}
