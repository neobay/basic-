#pragma once
#include <string>
#include "FullName.h"
#include "Address.h"
#include <iostream>

using namespace std;
class Person
{
public:
	string id;
	FullName fullName;
	Address address;
	string dateOfBirth;
	string email;
	string phoneNumber;
	string occupation;
	string gender;

	Person() {}
	Person(string id) : id(id) {}
	Person(string fullName) : fullName(fullName) {}
	Person(string id, FullName fullName) : id(id), fullName(fullName) {}
	Person(string id, FullName fullName, string gender) :
		id(id), fullName(fullName), gender(gender) {}
	Person(string id, FullName fullName, Address address, string dob,
		string email, string phoneNum, string occupation, string gender) :
		id(id), fullName(fullName), address(address), dateOfBirth(dob),
		email(email), phoneNumber(phoneNum), occupation(occupation), gender(gender) {}

	void sleep();
	void eat();
	void walk();
	void relax();
};

void Person::sleep() {
	cout << fullName.getFullName() << "is sleeping" << endl;
}

void Person::eat() {
	cout << fullName.getFullName() << "is eating" << endl;
}

void Person::walk() {
	cout << fullName.getFullName() << "is walking" << endl;
}

void Person::relax() {
	cout << fullName.getFullName() << "is relaxing" << endl;
}
