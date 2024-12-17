package hu.cubix.zoltan_sipeki.student;

import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import hu.cubix.zoltan_sipeki.student.util.InitDbService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@SpringBootApplication
public class StudentApplication implements CommandLineRunner {

	private InitDbService initDb;

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// try {
		// 	initDb.init();
		// } catch (StreamReadException e) {
		// 	e.printStackTrace();
		// } catch (DatabindException e) {
		// 	e.printStackTrace();
		// } catch (IOException e) {
		// 	e.printStackTrace();
		// } catch (Throwable e) {
		// 	e.printStackTrace();
		// }
	}

}
