#pragma once
#include <string>
using namespace std;
class FullName
{
public:
	string firstName;
	string lastName;
	string midName;

	FullName() {
		firstName = "";
		lastName = "";
		midName = "";
	}



	FullName(string firstName) : firstName(firstName) {}
	FullName(string firstName, string lastName) :
		firstName(firstName), lastName(lastName) {}
	FullName (string firstName, string lastName, string midName):
		firstName(firstName), lastName(lastName), midName(midName) {}

	void setFirstName(string firstName) {
		this->firstName = firstName;
	}

	void setLastName(string lastName) {
		this->lastName = lastName;
	}

	void setMidName(string midName) {
		this->midName = midName;
	}

	string getFirstName() {
		return firstName;
	}

	string getLastname() {
		return lastName;
	}

	string getMidName() {
		return midName;
	}

	string getFullName(){
		return firstName + " " + midName + " " + lastName;
	}
};

