package com.lidl.java8.demojava8;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoJava8ApplicationTests {

	@Test
	public void contextLoads() {

	}

	@Test
	public void getCpuNum() {
		System.out.println("cpu number is " + Runtime.getRuntime().availableProcessors());
	}

}
