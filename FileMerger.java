/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.filemerger;

/**
 *
 * @author vikaasoo
 */

import java.io.*;

public class FileMerger {

    public static void main(String[] args) throws IOException {
        System.out.println("Pr_5, Student Sogrina Vika, RIBO-03-21");
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите количество файлов:");
        int fileCount = Integer.parseInt(reader.readLine());
        String[] filePaths = new String[fileCount];
        System.out.println("Введите пути к файлам:");
        for (int i = 0; i < fileCount; i++) {
            filePaths[i] = reader.readLine();
        }
        
        try {
            File outputFile = new File(filePaths[0]);
            String outputFileName = outputFile.getName();
            String outputFilePath = outputFile.getParent() + File.separator + "merged_" + outputFileName;
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            for (String filePath : filePaths) {
                BufferedReader fileReader = new BufferedReader(new FileReader(filePath));
                String line = fileReader.readLine();
                while (line != null) {
                    writer.write(line);
                    line = fileReader.readLine();
                }
                fileReader.close();
            }
            writer.close();
            System.out.println("Файлы успешно объединены в " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    



}
