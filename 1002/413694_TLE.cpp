#include <iostream>
#include <string>
#include <set>
using namespace std;


int main( void ) {
 
    
    for ( int i = 0; i < 1; ++i ) {
        int n;
        cin >> n;
        
        if ( i != 0 ) {
            cout << endl;
        }
        
        multiset< string > nums;
        set< string > names;
        
        for ( int j = 0; j < n; ++j ) {
            string str;
            cin >> str;
            
            string newstr = "";
            for ( string::iterator p = str.begin( ); p != str.end( ); ++p ) {
                if ( *p == '-' ) {
                    continue;
                }
                
                switch ( *p ) {
                    case 'A': case 'B': case 'C':
                        newstr += "2";
                        break;
                        
                    case 'D': case 'E': case 'F':
                        newstr += "3";
                        break;
                        
                    case 'G': case 'H': case 'I':
                        newstr += "4";
                        break;
                        
                    case 'J': case 'K': case 'L':
                        newstr += "5";
                        break;
                    
                    case 'M': case 'N': case 'O':
                        newstr += "6";
                        break;
                        
                    case 'P': case 'R': case 'S':
                        newstr += "7";
                        break;
                    
                    case 'T': case 'U': case 'V':
                        newstr += "8";
                        break;
                        
                    case 'W': case 'X': case 'Y':
                        newstr += "9";
                        break;
                    
                    default:
                        newstr += *p;
                        break;
                }
            }
            
            newstr.insert( 3 , "-" );
            nums.insert( newstr );
            names.insert( newstr );
            
        }
        
        int flag = 0;
        for ( set< string >::iterator p = names.begin( ); p != names.end( ); ++p ) {
            int c = nums.count( *p );
            if ( c > 1 ) {
                cout << *p << " " << c << endl;
                ++flag;
            }
        }
        
        if ( flag == 0 ) {
            cout << "No duplicates." << endl;
        }
        
    }

    return 0;
}

