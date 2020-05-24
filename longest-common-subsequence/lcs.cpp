#include <iostream>
#include <array>

using namespace std;

class Lcs{};

int main(){

    int first_element_size;  
    int second_element_size;
    char letter;

	cout << "\n\nEnter first element size: ";
	cin >> first_element_size;
	char first_element[first_element_size + 1];

	cout << "\n\nEnter second element size: ";
	cin >> second_element_size;
	char second_element[second_element_size + 1];

	for(int i = 0; i < first_element_size; i++){

		cout << "\n\nEnter values for first element";
		cout << "\nEnter element" << i + 1  << " : ";
		cin >> letter;
		first_element[i + 1] = letter;
	}

	for(int i = 0; i < second_element_size; i++){

		cout << "\n\nEnter values for second element";
		cout << "\nEnter element" << i + 1  << " : ";
		cin >> letter;
		second_element[i + 1] = letter;
	}

	int lcs[first_element_size + 1][second_element_size + 1];
	int backptr[first_element_size + 1][second_element_size + 1];
	int count = 0;

	for(int j = 0; j <= second_element_size; j++){

		for(int i = 0; i <= first_element_size; i++){

				if(i == 0 && j == 0){

					lcs[i][j] = 0;
					cout << "lcs[" << i << "][" << j << "] = " << lcs[i][j] << "\n"; 
				}else if(i == 0 || j == 0){

					lcs[i][j] = 0;
					cout << "lcs[" << i << "][" << j << "] = " << lcs[i][j] << "\n";
				}else{

					if(first_element[i] == second_element[j]){

						lcs[i][j] = 1 +lcs[i-1][j-1];
						backptr[i][j] = 1;
						cout << "lcs[" << i << "][" << j << "] = " << lcs[i][j] << "\n";
						count++;	
					}else if(lcs[i-1][j] >= lcs[i][j-1]){

						lcs[i][j] =  lcs[i-1][j];
						backptr[i][j] = 2;
						cout << "lcs[" << i << "][" << j << "] = " << lcs[i][j] << "\n";
					}else{

						lcs[i][j] =  lcs[i][j-1];
						backptr[i][j] = 3;
						cout << "lcs[" << i << "][" << j << "] = " << lcs[i][j] << "\n";
					}
				}
			}

	}

	char LCS[lcs[first_element_size + 1][second_element_size + 1]];
	int k = 0;

	for(int i = first_element_size + 1; i > 0 ; i--){

		for(int j = second_element_size + 1; j > 0 ; j--){

			if(backptr[i][j] == 1){

				LCS[k] = first_element[i];
					i--;
					j--;
					k++;
			}else if(backptr[i][j] == 2){

				i--;
			}else if(backptr[i][j] == 3){

				j--;
			}
		}
	}

	for(int k = 0; k < count; k++){

		cout << LCS[k];
	}
	cout << "\n";	
}