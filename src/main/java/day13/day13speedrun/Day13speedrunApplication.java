package day13.day13speedrun;

import java.io.File;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day13speedrunApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(Day13speedrunApplication.class, args);
	}
	@Override
	public void run(ApplicationArguments args) throws Exception{

		if (args.containsOption("dataDir")){
			final String dataDir = args.getOptionValues("dataDir").get(0);

			File fileDir = new File(dataDir);

			if (!fileDir.exists()){
				fileDir.mkdirs();
				System.out.println(("***" +fileDir.getAbsolutePath()));
				System.out.println(("***" +fileDir.getPath()));
				System.out.println(("***" +fileDir.getParent()));
			}
			else{
				System.out.println(("***" +fileDir.getAbsolutePath()));
			}
		}
	}
}
