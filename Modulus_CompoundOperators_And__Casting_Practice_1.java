//PART ONE: MODULUS
//What would each of the following 1-6 lines including the modulo operator cause to be printed?
     System.out.println(14 % 13);
//prints 1

     System.out.println(8 % 11);
//prints 8

     System.out.println(6 % 2);
//prints 0

     System.out.println(7 % 2);
//prints 1

     System.out.println(274 % 10);
//prints 4

     System.out.println(881 % 2);
//prints 1


//PART THREE: CASTING

    int total = 5 + 7 + 2;
    (double) (total / 3); //Option A
    total / 3; //Option B
    (double) total / 3; //Option C

//Which of the above options correctly computes the average of total? Why do the other options not work?
/*
* The correct option is C, because the when the division occurs in the first two, both numbers are ints, so the quotient would be truncated.
* In option C though, the total is cast as a double. Since doubles take priority over ints, the answer would remain in decimal form, which we want.
*/
