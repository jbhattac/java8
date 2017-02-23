package com.joydeep.lamdas.thisref;

import com.joydeep.lamdas.interfaces.Process;

public class ThisReferanceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThisReferanceExample ref = new ThisReferanceExample();
		ref.doProcess(10, new Process() {

			@Override
			public void doProcess(int i) {
				System.out.println(i);
				System.out.println(this);

			}

			public String toString() {
				return "This is to string of annonymous inner calss";
			}

		});
		
		ref.doProcess(10,(i)->{
			System.out.println(i);
			//System.out.println(this);
		});
		ref.execute();
		
	}

	private void execute() {
		System.out.println(this);
		doProcess(10,(j)->{
			System.out.println(j);
			System.out.println(this);
		});
		
	}

	private void doProcess(int i, Process process) {
		// TODO Auto-generated method stub
		process.doProcess(i);
	}

	@Override
	public String toString() {
		return "ThisReferanceExample [getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

	
	
}
