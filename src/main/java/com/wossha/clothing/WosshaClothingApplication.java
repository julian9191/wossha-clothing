package com.wossha.clothing;

import javax.sql.DataSource;
import org.skife.jdbi.v2.DBI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class WosshaClothingApplication implements CommandLineRunner {

	public final static String APP_NAME="WOSSHA-CLOTHING";
	
	public static void main(String[] args) {
		SpringApplication.run(WosshaClothingApplication.class, args);
		System.out.println("APPLICATION STARTED");
	}

	@Override
	public void run(String... args) throws Exception {
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	@Bean
	public DBI dbi(DataSource dataSource) {
		synchronized (DBI.class) {
			return new DBI(dataSource);
		}
	}

}
