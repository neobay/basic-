#include <iostream>
#include <string>

#define SIZE 100

using namespace std;

void getArrayElements(string names[], int& n, string& x);
void showArrayElements(const string names[], int n);
int findX(const string names[], int n, string x);
int countX(const string names[], int n, string x);
bool isExisted(const string names[], int n, string x);
void findMax(const string names[], int n, string x);
void showMaxOccurentName(const string names[], int n, int maxOcc);

int main() {
	int n, max;
	string x;
	string names[SIZE];
	getArrayElements(names, n, x);
	showArrayElements(names, n);
	int k = findX(names, n, x);
	if (k != -1)
	{
		cout << x << " found at: " << k << endl;
	}
	else
	{
		cout << "Not found" << endl;
	}

	findMax(names, n, x);
	

	return 0;
}

void getArrayElements(string names[], int& n, string& x) {
	cout << "Nhap vao so luong: ";
	cin >> n;

	if (n < 0 || n > 100)
	{
		cout << "N Invalid" << endl;
	}
	else
	{
		for (size_t i = 0; i < n; i++)
		{
			cout << "names[" << i << "]= ";
			cin >> names[i];
		}
		cout << "Ten sinh vien: ";
		cin >> x;
	}
}

void showArrayElements(const string names[], int n) {
	cout << "Danh sach: ";
	for (size_t i = 0; i < n; i++)
	{
		cout << names[i] << " ";
	}
	cout << endl;
}

int findX(const string names[], int n, string x) {
	for (size_t i = 0; i < n; i++)
	{
		if (names[i] == x)
		{
			return i;
		}
	}
	return -1;
}

int countX(const string names[], int n, string x) {
	int count = 0;
	for (size_t i = 0; i < n; i++)
	{
		if (names[i] == x)
		{
			count++;
		}
	}
	return count;
}

bool isExisted(const string names[], int n, string x) {
	for (size_t i = 0; i < n; i++)
	{
		if (names[i] == x)
		{
			return true;
		}
	}
	return false;
}

void findMax(const string names[], int n, string x) {
	int max = countX(names, n, names[0]);
	bool isExisted(const string[], int, string);
	for (size_t i = 0; i < n; i++)
	{
		if (!isExisted(names, i, names[i]))
		{
			int count = countX(names, n, names[i]);
			if (count > max)
			{
				max = count;
			}
		}		
	}
	showMaxOccurentName(names, n, max);
}

void showMaxOccurentName(const string names[], int n, int maxOcc) {
	for (int i = 0; i < n; i++)
	{
		if (countX(names, n, names[i]) == maxOcc) {
			cout << names[i] << " " << maxOcc << endl;
			break;
		}
	}
}
