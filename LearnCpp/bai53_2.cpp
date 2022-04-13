#include "Person.h"
#include <iostream>
#include <string>

using namespace std;

Person addPersonInfo();

int main() {

}

Person addPersonInfo()
{
	
	string personId;
	string firstName;
	string lastName;
	string midName;
	string dob;
	string email;
	string city;
	string nation;
	string phoneNumber;
	string occupation;
	string gender;
	cout << "=================NHAP THONG TIN CA NHAN====================\n";
	cout << "Nhap CCCD: ";
	getline(cin, personId);
	cout << "Nhap ho ten: ";
	getline(cin, firstName);
	cout << "Nhap ten: ";
	getline(cin, lastName);
	cout << "Nhap ten dem: ";
	getline(cin, midName);
	cout << "Nhap ngay thang nam sinh: ";
	getline(cin, dob);
	cout << "Nhap email: ";
	getline(cin, email);
	cout << "Nhap thanh pho: ";
	getline(cin, city);
	cout << "Ten quoc gia: ";
	getline(cin, nation);
	cout << "So dien thoai: ";
	getline(cin, phoneNumber);
	cout << "Nghe nghiep: ";
	getline(cin, occupation);
	cout << "Gioi tinh: ";
	getline(cin, gender);
	FullName fullName(firstName, lastName, midName);
	Address address(city, nation);
	Person person(personId, fullName, address, dob,
		email, phoneNumber, occupation, gender);
	return person;
}
