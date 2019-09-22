package main.java.utility;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CSVFileReader {

	public static List<String> read(String fileName) throws IOException, URISyntaxException {
		
		List<String> content =new ArrayList<String>();
		Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()));
		stream.forEach((item) -> content.add(item.trim()));
		stream.close();
		return content;
	}
}
