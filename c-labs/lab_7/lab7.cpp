#include <iostream>
#include <iomanip>
using namespace std;
void func(int a, int b, int c) {	//перевантажена функція для обчислення 
	c += a * b;						// добутку цілих чисел
	cout << "a * b = " << c << endl;
}
void func(double a, double b, double c, double d, double x, double y) {	// перевантажена функція для обчислення
	x += a * c - b * d;													// добутку комплексних чисел		
	y += a * d + b * c;
	if (y >= 0)
		cout << "(" << a << " + " << b << "i) * (" << c << " c + " << d << "i) = " << x << " + " << y << "i" << endl;
	else
		cout << "(" << a << " + " << b << "i) * (" << c << " c + " << d << "i) = " << x << " - " << y << "i" << endl;
}

int main() {
	int intA, intB, dobutok;
	dobutok = 0;
	cout << "vvedit cili chisla" << endl;
	cin >> intA >> intB;
	double a, b, c, d, existing, abstract;
	existing = 0;
	abstract = 0;
	cout << "vvedit kompleksni chisla" << endl;
	cin >> a >> b >> c >> d;
	cout << endl;
	func(intA, intB, dobutok);
	cout << endl;
	func(a, b, c, d, existing, abstract);
	//cout << "(" << a << " + " << b << "i) * (" << c << " c + " << d << "i) =" << endl;
	system("pause");
}
