public class Polynomial {
	private double[] coefficients;

	public Polynomial() {
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