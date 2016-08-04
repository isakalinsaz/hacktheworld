package stringparsing;

public class TestThread implements Runnable {

	@Override
	public void run() {
		
		long start = System.currentTimeMillis();
		/*for (double i = 0; i <90000; i++) {
			for (int j = 0; j < 1000; j++) {
				double count= Math.pow(i, 2);
			}
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		String[] value="TEST".split("TT");
		
		System.out.println(System.currentTimeMillis() - start);
		StringBuilder builder=new StringBuilder(); 
		builder.append("TEST");
		builder.append("+");
		builder.append("TEST");
		System.out.println("Result : "+builder);
	}

}
