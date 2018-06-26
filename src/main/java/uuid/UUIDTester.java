package uuid;

import java.util.UUID;

public class UUIDTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        str = str.toUpperCase();
        //str = str.replaceAll("-", "");
        System.out.println("uuid: " + str);
        System.out.print("length: " + str.length());
	}

}
