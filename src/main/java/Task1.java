package main.java;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {

    public static void mergeFiles(String path) throws IOException {
        String str = Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .sorted(Comparator.comparing(Path::getFileName))
                .map(Task1::readFile)
                .collect(Collectors.joining(" "));

        PrintWriter out = new PrintWriter(new File("output.txt"));
        out.print(str);
        out.close();
    }

    public static String readFile(Path file) {
        StringBuilder builder = new StringBuilder();
        try (Stream<String> stream = Files.lines(file)) {
            stream.forEach(builder::append);
        } catch (IOException e) {
        }
        return builder.toString();
    }
}
