# Spell Checker README

## Project Information
- **Course**: Data Structures and Algorithms
- **Project**: Project 2
  
## Project Objective
The objective of this project is to build a fast spell checker using a generic hash implementation with an open addressing strategy. The program should allow users to:
1. Load a dictionary from a given text file.
2. Search for an entry in the dictionary in constant time.
3. Insert a word into the dictionary in constant time.
4. Delete a word from the dictionary in constant time.
5. Perform a spell check on a random text file in linear time.

## Project Requirements
- **Dictionary**: The program should be able to load a dictionary of 200,000+ words from a text file.
- **Search**: Users should be able to search for an entry in the dictionary with constant time complexity.
- **Insertion and Deletion**: Users should be able to insert and delete words from the dictionary with constant time complexity.
- **Spell Check**: When the user chooses option 5, the program should read a specified text file for spell checking and display all spelling errors found in the file.
- **Input Handling**: Words may be separated by spaces, punctuations, and carriage returns. All words should be converted to lowercase, and numeric characters should be ignored during spell checking.

## Hash Implementation
- Use a generic hash implementation with an open addressing strategy to achieve constant time complexity for search, insertion, and deletion operations.

## Usage
1. Load a dictionary: Users can load a dictionary from a given text file.
2. Search: Users can search for a word in the dictionary.
3. Insert: Users can insert a new word into the dictionary.
4. Delete: Users can delete a word from the dictionary.
5. Spell Check: Users can perform a spell check on a text file and display spelling errors.
