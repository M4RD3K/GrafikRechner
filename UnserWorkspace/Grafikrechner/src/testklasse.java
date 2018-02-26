
public class testklasse {

	public static void main(String[] args) {

		Steuerung s = new Steuerung();
	
		
	}
	
	
	public void test() {
		
		String s = "x^2+2x";
		char[] c = s.toCharArray();
		char[] f = new char[10];
		char[] g = new char[10];
		for (int i = 0; i < c.length; i++) {
			if (c[i]== '+') {
				int k=i;
				
				for (int j = 0; j < i; j++) {
					g[j]=c[j];
					
				}
				for (int j2 = 0; j2 < c.length-i; j2++) {
					f[j2]=c[k];
					k++;
				}
				
			}
		}
		for (int i = 0; i < g.length; i++) {
			System.out.println(g[i]);
		}
	 for (int i = 0; i < f.length; i++) {
		System.out.println(f[i]);
	}

		
	}


	
	
	
}
