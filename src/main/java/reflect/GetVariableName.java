package reflect;

import java.lang.reflect.Field;

public class GetVariableName {

	private String myName;

	/**
	 * @param args
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		// TODO Auto-generated method stub
		GetVariableName a = new GetVariableName();
		a.setMyName("aa");
		Field[] fields = a.getClass().getDeclaredFields();
		int len = fields.length;
		String myName = "bb";
		String myName2 = "cc";
		String str = "";
		
		Field f = a.getClass().getDeclaredField("myName");

		try {
			for (int i = 0; i < fields.length; i++) {
				System.out.println("多个field循环");
				System.out.println("类型 : " + fields[i].getType().getName());
				System.out.println("变量名: " + fields[i].getName());
				System.out.println("原值: " + fields[i].get(a));
				
				fields[i].setAccessible(true);
				fields[i].set(a, myName);
				
				System.out.println("现值: " + fields[i].get(a));
			}
			
			System.out.println();
			Field f1 = a.getClass().getDeclaredField("myName");
			System.out.println("单个field");
			System.out.println("类型 : " + f.getType().getName());
			System.out.println("变量名: " + f.getName());
			System.out.println("原值: " + f.get(a));
			
			//f.setAccessible(true);
			f.set(a, myName2);
			System.out.println("现值: " + f.get(a));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

}
