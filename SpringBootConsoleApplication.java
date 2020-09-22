package com.file.encoding;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.file.encoding.scan.ScanFileProcess;

@SpringBootApplication
@ComponentScan
public class SpringBootConsoleApplication implements CommandLineRunner {

	@Autowired
	ScanFileProcess scanFileProces;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConsoleApplication.class, args);
	}

	@Override
	public void run(String... args) throws IOException {
        // parse arguments
        if (args.length == 0 || args.length > 2)
            usage();
        boolean recursive = false;
        int dirArg = 0;
        if (args[0].equals("-r")) {
            if (args.length < 2)
                usage();
            recursive = true;
            dirArg++;
        }

        // register directory and process its events
        scanFileProces.monitorFileSystem(args[dirArg], recursive);
    }
	
    static void usage() {
        System.err.println("usage: java WatchDir [-r] dir");
        System.exit(-1);
    }
}