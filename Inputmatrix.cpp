#include <iostream>

using namespace std;

#define M 100
#define N 100

void getMatrix(int matrix[][N], int& m, int& n);
void showMatrixElements(int matrix[][N], int m, int n);

int main() {
	int m, n;
	int matrix[M][N];
	getMatrix(matrix, m, n);
	showMatrixElements(matrix, m, n);
	return 0;
}

void getMatrix(int matrix[][N], int& m, int& n) {
	cout << "Nhap so hang, so cot: ";
	cin >> m >> n;


	cout << "Nhap du lieu: ";
	if (m > 0 && n > 0)
	{
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				cin >> matrix[i][j];
			}
		}
	}
	else
	{
		cout << "ERROR" << endl;
	}
}

void showMatrixElements(int matrix[][N], int m, int n) {
	cout << "Ma tran ban vua nhap la: " << endl;
	for (int i = 0; i < m; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cout << matrix[i][j] << " ";
		}
		cout << endl;
	}
}

