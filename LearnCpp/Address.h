#pragma once
#include <string>

using namespace std;
class Address
{
public:
	string roadName;
	string number;
	string alley;
	string ward;
	string district;
	string city;
	string nation;

	Address() {}
	Address(string city) : roadName(city) {}
	Address(string city, string nation) : 
		city(city), nation(nation) {}
	Address(string district, string city, string nation) :
		district(district), city(city), nation(nation) {}

	string getFullAddress();
};

string Address::getFullAddress() {
	return number + ", " + alley + ", " + roadName + ward
		+ ", " + district + ", " + city + ", " + nation;
}