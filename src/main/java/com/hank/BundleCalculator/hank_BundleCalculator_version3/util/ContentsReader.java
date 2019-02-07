package com.hank.BundleCalculator.hank_BundleCalculator_version3.util;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



public class ContentsReader {

    public List<String> contentsRead(String filename){
        Path path = Paths.get(filename);
        List<String> contents = new ArrayList<>();
        try {
            contents = Files.readAllLines(path);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return contents;
    }

}
