**Solution:**

The solution consists of analyzing each letter of a word entered, verify how many times a letter is repeated within the
word and with this information create an array of size 25 which refers to the number of words in the ASCII table and 
each letter of the word is placed in the corresponding position between A and Z. The value of each position refers to 
the number of times the same letter is repeated within the word. After this, all the words contained in a text file 
called **words.txt**, which contains a large number of words in the American language, are analyzed and all the words 
are reviewed and stored in a new array. Then what is done is a comparison of arrays where it is validated that each word 
stored in the array contains the letters of the word entered.

**How to execute?**
 1. Locate the class named Execution.class in the path src/test/java/
 2. In the main function of the Execution class, change the text found in the function for the word to be tested