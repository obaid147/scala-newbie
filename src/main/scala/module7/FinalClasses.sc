//A whole class can be marked final as well, e.g. Java's String class:

/**class BadString extends String*/
// Error: illegal inheritance from final class String
// class BadString extends String
//                         ^

//And again, we can do this ourselves:
final class Infinity
/**class Beyond extends Infinity*/
// Error: illegal inheritance from final class Infinity
// class Beyond extends Infinity
//                      ^
//Sorry Buzz Lightyear...