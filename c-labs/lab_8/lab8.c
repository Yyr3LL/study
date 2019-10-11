#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int numCs;

typedef struct Country {
	char name[20];
	char capital[30];
	int population;
	int area;
} Country;

void createCountrys(FILE *fp) {
	fseek(fp, 0, SEEK_SET);
	Country newCountry;
	for (int i = 0; i < numCs; i++) {
		scanf("%s %s %d %d", newCountry.name, newCountry.capital, &newCountry.population, &newCountry.area);
		fwrite(&newCountry, sizeof(Country), 1, fp);
	}
}

void printCountrys(FILE *fp) {
	fseek(fp, 0, SEEK_SET);
	Country newCountry;
	printf("\nCountries\n");
	for (int i = 0; i < numCs; i++) {
		fread(&newCountry, sizeof(Country), 1, fp);
		printf("Name: %s\tcapital: %s\tPopulation: %d\tArea: %d\n", newCountry.name, newCountry.capital, newCountry.population, newCountry.area);
	}
}

void delete_with_lower_pop(FILE *fp, int pop) {

	fseek(fp, 0, SEEK_SET);
	Country newCountry;
	Country countriess[numCs];
	int j = 0;
	for (int i = 0; i < numCs; i++) {
		fread(&newCountry, sizeof(Country), 1, fp);
		if (newCountry.population > pop) {
			countriess[j]=newCountry;
			j++;
		}
	}
	numCs = j;
	freopen("Countrys.txt", "w+b", fp);
	for(int k = 0; k < j; k++){
		fwrite(&countriess[k], sizeof(Country), 1, fp);
	}
}

void insertCountry(FILE *fp) {
	numCs+=2;
	Country newCountry;

	//fread(&newCountry, sizeof(Country), 1, fp);
	//fwrite(&newCountry, sizeof(Country), 1, fp);

	fseek(fp, 0, SEEK_END);
	for(int i = 0; i < 2; i++){
		scanf("%s %s %d %d", newCountry.name, newCountry.capital, &newCountry.population, &newCountry.area);
		fwrite(&newCountry, sizeof(Country), 1, fp);
	}

}




int main() {
	FILE *fp = fopen("Countrys.txt", "w+b");
	if (fp == NULL) {
		perror("\nError opening the file.\n");
		exit(0);
	}
	printf("Number of Countrys: ");
	scanf("%d", &numCs);
	createCountrys(fp);
	int pop;
	int g;
	int action, quit = 0;
	while(!quit){
		printf("what do you want:\n1. print\n2. delete with lower pop\n3. insert");
		scanf("%d", &action);
		switch(action){
			case 1:
				printCountrys(fp);
				break;
			case 2:
				scanf("%d", &pop);
				delete_with_lower_pop(fp, pop);
				break;
			case 3:
				insertCountry(fp);
				break;
			default:
				quit = 1;
				break;
		}
	}
	fclose(fp);
}



/*#include <stdio.h>
#include <stdlib.h>

//main structure of the countries
typedef struct Country1
{
	char name[10];
	char capital[10];
	int population;
	int area;

}Country1;

int main()
{
    //file pointer
	FILE* fp;

    //enter the number of countries
	int countries;
	printf("Enter number of countries\n");
	scanf("%d",&countries);

    //closing file if there is an eror
	fp = fopen("file.txt","wb");
	if(fp == NULL)
	{
		printf("Error");
		return 0;
	}

	//creates the copy of structure
	Country1 Country;

	//creates the array for the number of countries
	Country1 arr[countries];

    //enter the data
	for(int i = 1; i <= countries;i++)
	{
		printf("name = ");
		scanf("%s",Country.name);

  		printf("Town = ");
  		scanf("%s",Country.capital);

  		printf("population = ");
  		scanf("%d",&Country.population);

  		printf("area = ");
  		scanf("%d",&Country.area);

	  	printf("\n");

        //writes the information to file
  		fwrite(&Country, sizeof(Country), 1,fp);
	}

    //reads and printf entered countries
	freopen("file.txt","rb",fp);
	int i = 0;
	printf("The entered countries are:\n");
	while(!feof(fp) && i <countries)
	{
		fread(&arr[i],sizeof(Country),1,fp);
		printf("\nname = %s \ncapital = %s \npopulation = %d \narea = %d",arr[i].name,arr[i].capital, arr[i].population, arr[i].area);
		printf("\n");
		i++;
	}
	printf("\n");

    //deliting the area that is lower than current
	printf("Deliting the countries with lower population than written\n");
	freopen("file.txt","wb",fp);
	printf("Please give me the population\n\n");
	int new_pop;
	scanf("%d",&new_pop);
	int count = 0;
	for( i = 0; i < countries; i++)
	{
		if(arr[i].area < new_pop)
		{
			count++;
			continue;
		}
	printf("%d - count and %d - countries", count, countries);
		//writes the given number to file
		fwrite(&arr[i],sizeof(Country), 1,fp);
	}

	//reads and prints only the team that has biger area than you entered
	freopen("file.txt","rb",fp);
	if(countries - count == 0){
		Country1 New_Countries[255];
		if(!feof(fp)){
			i = 0;
			fread(&New_Countries[i],sizeof(Country),1,fp);
			printf("\nname = %s \ncapital = %s \npopulation = %d \narea = %d",New_Countries[i].name,New_Countries[i].capital, New_Countries[i].population, New_Countries[i].area);
		}
	}
	else{
		Country1 New_Countries[countries - count];
		i = 0;
		while(!feof(fp) && i < countries - count)
		{
			fread(&New_Countries[i],sizeof(Country),1,fp);
			printf("\nname = %s \ncapital = %s \npopulation = %d \narea = %d",New_Countries[i].name,New_Countries[i].capital, New_Countries[i].population, New_Countries[i].area);
			i++;
		}
	}
	printf("\n");

	// Ading two elements
	printf("\n");
	printf("Enter 2 countries to add: \n");
	freopen("file.txt","wb",fp);

	//creates the copy of structure
	Country1 new_co jyf5  untry;


	printf("name = ");
	scanf("%s",new_country.name);

	printf("capital = ");
	scanf("%s",new_country.capital);

	printf("population = ");
	scanf("%d",&new_country.population);

	printf("area = ");
	scanf("%d",&new_country.area);

	printf("\n");

	//writes the information to file
	fwrite(&new_country, sizeof(new_country), 1,fp);


	//writes all data that was given to a file
	for( i = 0; i < countries - count;i++)
	{
		fwrite(&new_country[i],sizeof(Country1), 1,fp);
	}

	//reads and prints all countries that were entered
	freopen("file.txt","rb",fp);
	i = 0;
	Country1 Fin_Countries[countries - count+1];
	while(!feof(fp) && i < countries - count+1 )
	{
		fread(&Fin_Countries[i],sizeof(Country1),1,fp);
		printf("\nname = %s \ncapital = %s \npopulation = %d \narea = %d",Fin_Countries[i].name,Fin_Countries[i].capital, Fin_Countries[i].population, Fin_Countries[i].area);
		i++;
		printf("\n");
	}

fclose(fp);
}
*/