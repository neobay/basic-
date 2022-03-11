#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#define MAX 50
	
struct Employee{
	char codes[MAX][9];
	char names[MAX][21];
	double salaries[MAX];
	double allowances[MAX];
};
//typedef Employee Emp;

void createEmployee(struct Employee employee, int size){
	int i;
	for(i = 0; i < size; i++){
		printf("Employee %d: ", i + 1);
		gets(employee.names[i]);
		fflush(stdin);
		printf("Salary %d: ", i + 1);
		scanf("%lf", &employee.salaries[i]);
		printf("Allowance %d: ", i + 1);
		scanf("%lf", &employee.allowances[i]);
		fflush(stdin);
	}
}

void addEmployee(struct Employee employee, int* size, char* s){
	strcpy(employee.names[*size], s);
	(*size) += 1;
	printf("Salary: ");
	scanf("%lf", &employee.salaries[*size]);
	printf("Allowance: ");
	scanf("%lf", &employee.allowances[*size]);
}

void ascOrder(struct Employee employee, int size){
	int i, j;
	char t[21];
	for(i = size; i >= 1; i--){
		for(j = 0; j < i - 1; j++){
			if((employee.allowances[j] + employee.salaries[j]) > (employee.allowances[j + 1] + employee.salaries[j + 1])){
				strcpy(t, employee.names[j + 1]);
				strcpy(employee.names[j + 1], employee.names[j]);
				strcpy(employee.names[j], t);
			}
		}
	}
}

bool removeEmployee(struct Employee employee, int* size, char* s){
	int i, j;
	for(i = 0; i < *size; i++){
		if(strcmp(employee.codes[i], s) == 0){
			for(j = i; j < *size; j++){
				strcpy(employee.codes[j], employee.codes[j + 1]);
			}
			(*size) -= 1;
			return true;
		}
	}
	return false;
}

void showEmp(struct Employee employee, int size){
	int i;
	for(i = 0; i < size; i++){
		//puts(list[i]);
		//printf("%s\n", employee.names[i]);
		puts(employee.names[i]);
	}
}

int main(){
	int size = 0;
	int choice = 0;
	char s[21];
	struct Employee employee;
	printf("Input number of employees: ");
	scanf("%d", &size);
	fflush(stdin);
	createEmployee(employee, size);
	do{
		printf("====================================MENU========================================\n");
		printf("1. Add a new employee\n");
		printf("2. Find employee using name\n");
		printf("3. Remove employee using code\n");
		printf("4. Print in ascending order\n");
		printf("5. Show list\n");
		printf("0. Exit\n");
		printf("Your choice: ");
		scanf("%d%*c", &choice);
		switch(choice){
			case 0:
				printf("Good Bye!\n");
				break;
			case 1:
				printf("Input employee's name: ");
				gets(s);
				addEmployee(employee, &size, s);
				break;
			case 5:
				fflush(stdin);
				showEmp(employee, size);
				break;
		}
	}while(choice != 0);
	
	
	
	
	return 0;
}
