package com.dheerendra.Pausing;

public class Join_Sleep_Thread2 extends Thread {

	public void run() {

		for (int i = 0; i < 20; i++) {
			System.out.println(getName() + " " + i);

			if (i == 5 && getName().equals("Child2")) {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}
		}

	}
}
