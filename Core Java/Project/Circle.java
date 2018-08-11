public class Circle implements Shape 
{
	public static final float pi=3.14f;

	private double rad;
	
	public Circle(double rad){
		this.rad=rad;
		
	
	}
	public void area(){
		System.out.println("Circle area "+(pi*rad*rad));
	}

	public void perimeter(){
		System.out.println("Circle perimeter"+(2*pi*rad));
	
	}
	public void printRad(){
		System.out.println("rad "+rad);
		
	}
	
	}
