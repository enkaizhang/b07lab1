public class Polynomial {
	private double[] coefficients;
	private int[] exps;

	public Polynomial() {
<<<<<<< HEAD
		coefficients = new double[]{0.0};
		exps = new int[]{0};
	}
	
	public Polynomial(double[] coeffs) {
		int count = 0;
		for (int i=0; i<coeffs.length; i++)
		{
			if (coeffs[i] > 0)
			{
				count++;
			}
		}
		if (count == 0)
		{
			this.coefficients = new double[]{0.0};
			this.exps = new int[]{0};
		}
		else
		{
			this.coefficients = new double[count];
			this.exps = new int[count];
			int j=0;
			for (int i=0; i<coeffs.length; i++)
			{
				if (coeffs[i] > 0)
				{
					this.coefficients[j] = coeffs[i];
					this.exps[j] = i;
					j++;
				}
			}
		}
	}
	
	public Polynomial add(Polynomial second) 
	{
		int max_exp=0;
		for (int i=0; i<this.exps.length; i++) 
		{
			if (this.exps[i] > max_exp) 
			{
				max_exp = this.exps[i];
			}
		}
		for (int i=0; i<second.exps.length; i++) 
		{
			if (second.exps[i] > max_exp) 
			{
				max_exp = second.exps[i];
			}
		}
		
		double[] new_coeffs = new double[max_exp + 1];
        for (int i=0; i<=max_exp; i++) 
		{
            new_coeffs[i] = 0.0;
        }
        for (int i=0; i<this.coefficients.length; i++)
		{
            int idx = this.exps[i];
            new_coeffs[idx] = new_coeffs[idx] + this.coefficients[i];
        }
        for (int i=0; i<second.coefficients.length; i++) 
		{
            int idx = second.exps[i];
            new_coeffs[idx] = new_coeffs[idx] + second.coefficients[i];
        }
		
		int count = 0;
		for (int i=0; i<= max_exp; i++)
		{
			if (new_coeffs[i] > 0)
			{	
				count++;
			}
		}
		
		if (count == 0)
			return new Polynomial();
		
		double new_Coeffs = new double[count];
		int new_exps = new int[count];
		int j=0;
		for (int i=0; i<=max_exp; i++)
		{
			if (new_coeffs[i] > 0)
			{
				new_Coeffs[j] = new_coeffs[i];
				new_exps[j] = i;
				j++;
			}
		}
		
		return new Polynomial(new_Coeffs, new_exps);
	}
	
	public double evaluate(double x) 
	{
		double sum = 0;
		for (int i=0; i<this.coefficients.length; i++) 
		{
			sum += coefficients[i] * Math.pow(x, exps[i]);
		}
		return sum;
	}
	
	public boolean hasRoot(double x) 
	{
		double value = evaluate(x);
		return Math.abs(value) < 1e-6;
	}
}
=======
		coefficients = new double[]{0};
	}
	public Polynomial(double[] coeffs) {
		this.coefficients = coeffs;
	}
	public Polynomial add(Polynomial second) {
		int max_length = Math.max(this.coefficients.length, second.coefficients.length);
		double[] new_coeffs = new double[max_length];
		for (int i=0; i<max_length; i++) {
			double f_coeffs, s_coeffs;
			if (i<this.coefficients.length) {
				f_coeffs = this.coefficients[i];
			}
			else {
				f_coeffs = 0;
			}
			if (i<second.coefficients.length) {
				s_coeffs = second.coefficients[i];
			}
			else {
				s_coeffs = 0;
			}
			new_coeffs[i] = f_coeffs + s_coeffs;
		}
		return new Polynomial(new_coeffs);
	}
	public double evaluate(double x) {
		double sum = 0;
		for (int i=0; i<this.coefficients.length; i++) {
			sum += coefficients[i] * Math.pow(x, i);
		}
		return sum;
	}
	public boolean hasRoot(double x) {
		double value = evaluate(x);
		return Math.abs(value) < 1e-6;
	}
}
>>>>>>> 2d0664998b72ab517eef8766ec1f06ac98b93ca5
