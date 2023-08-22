package in.rest.RestAssuredDemo;

import java.util.UUID;

import org.testng.annotations.Test;

public class UUID_Demo {
	UUID uuid = UUID.randomUUID();
	@Test
	public void test() {
		System.out.println(uuid);
	}

}
