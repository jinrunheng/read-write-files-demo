package com.github.readwritefilesdemo;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileAccessor {

    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir"), System.getProperty("user.dir"));
        File testFile = new File(projectDir, "target/test.txt");
        List<String> lines = Arrays.asList("AAA", "BBB", "CCC");
        writeLinesToFile1(lines, testFile);
        writeLinesToFile2(lines, testFile);
        writeLinesToFile3(lines, testFile);
        writeLinesToFile4(lines, testFile);


        System.out.println(readFile1(testFile));
        System.out.println(readFile2(testFile));
        System.out.println(readFile3(testFile));
        System.out.println(readFile4(testFile));
    }

    public static List<String> readFile4(File file) {
        List<java.lang.String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        try (InputStream is = new FileInputStream(file)) {
            int content;
            while ((content = is.read()) != -1) {

                if (content == 10) {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                } else {
                    sb.append((char) content);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    public static List<String> readFile1(File file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<String> readFile2(File file) {

        try {
            return IOUtils.readLines(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> readFile3(File file) {
        try {
            return Files.readAllLines(file.toPath());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeLinesToFile1(List<String> lines, File file) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))) {
            for (String line : lines) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeLinesToFile2(List<String> lines, File file) {
        try {
            IOUtils.writeLines(lines, "\n", new FileOutputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NIO Java 7+
     *
     * @param lines
     * @param file
     */
    public static void writeLinesToFile3(List<String> lines, File file) {
        try {
            Files.write(file.toPath(), lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeLinesToFile4(List<String> lines, File file) {
        try (OutputStream os = new FileOutputStream(file)) {
            for (String line : lines) {
                os.write(line.getBytes());
                os.write("\n".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
