Notes on addressing upcoming requirements changes:
1)  Another department will want to use this utility as well, but they have a much more complex name scoring algorithm.
>>  Address this by using an abstract class that contains an abstract method for the scoring algorithm.  Non-abstract
>>  derived classes will provide the implementation for this method.

2)  This scoring feature will be added to the company's intranet web-app, allowing employees to upload and score files from their desktop.
>>  Not sure how this will or should affect the implementation, other than this could be a standalone program.

3)  The company will be switching from first names only to both first and last names in the file.
>>  The major impact would be on the sorting.  Would you sort by last name, then first name?
>>  Having first name and last name as part of the scoring for each name would have no impact on the algorithm
>>  itself because the order in which you sum the values of the letters in the first/last name will not change
>>  the result of executing the algorithm on a given first name and last name.
>>  You may want a new class called "Name" that would contain two String fields (firstName, lastName).
>>  You could then implement the Comparator interface (Comparator<Name>) to specify how to sort Name objects, i.e.,
>>  by lastName then firstName.


ASSUMPTIONS:
Assume that the names do not contain a comma within a pair of double quotes.  The algorithm uses the comma as the
delimiter between names and assumes that each name CAN be enclosed within double quotes (although it will work if the
name is NOT enclosed in double quotes).

See "ParseStringWithEmbeddedCommas" for example of how to deal with embedded commas within a pair of double quotes
and the arrangement of first name and last name.

