package com.projectjava25.poc_class_file_api;

import com.projectjava25.poc_class_file_api.examples.Example01List;
import com.projectjava25.poc_class_file_api.examples.Example02Fields;

import java.io.IOException;


public class PocClassFileApiApplication {

	public static void main(String[] args) throws IOException {
		Example01List.execute();
		Example02Fields.execute();
	}

}
