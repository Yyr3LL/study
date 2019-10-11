#include <iostream>
#include <iomanip>

using namespace std;

void dodM(int **arr, int **arr2, int n, int m) {
	for (int i = 0; i < n; i++) {
		for (int k = 0; k < m; k++) {
			arr[i][k] += arr2[i][k];

		}
	}
	for (int i = 0; i < n; i++) {
		for (int k = 0; k < m; k++) {
			cout << setw(4) << arr[i][k];
		}
		cout << endl;
	}
}
int main() {
	int n, m;
	cin >> n >> m;
	int **array = new int*[n];
	for (int i = 0; i < n; i++) {
		array[i] = new int[m];
	}
	for (int i = 0; i < n; i++) {
		for (int k = 0; k < m; k++) {
			array[i][k] = i + k;
		}
	}

	int **array2 = new int*[n];
	for (int i = 0; i < n; i++) {
		array2[i] = new int[m];
	}
	for (int i = 0; i < n; i++) {
		for (int k = 0; k < m; k++) {
			array2[i][k] = i + k + 3;
		}
	}
	cout << "The first matrix: " << endl;
	for (int i = 0; i < n; i++) {
		for (int k = 0; k < m; k++) {
			cout << setw(4) << array[i][k];
		}
		cout << endl;
	}
	cout << "The second matrix: " << endl;
	for (int i = 0; i < n; i++) {
		for (int k = 0; k < m; k++) {
			cout << setw(4) << array2[i][k];
		}
		cout << endl;
	}
	cout << "Adding matrixes..." << endl;
	dodM(array, array2, n, m);
	cout << endl;
	system("pause");
}
