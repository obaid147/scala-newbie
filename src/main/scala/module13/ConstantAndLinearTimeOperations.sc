/** 1 Constant TIME OPERATIONS */
/** Big O Notation = O(1) = Constant time complexity
 * Operations at the head of a List are constant time,
   e.g. .head, .tail, isEmpty  including :: ( right associative)
 */
val numS = (1 to 10).toList
numS.head
numS.tail
numS.isEmpty
numS.nonEmpty
0 :: numS // appends 0 to head node
numS.::(-1)//
/** :: is also constant time,
 * it re-uses the existing list and only creates one new node. */
// ----------------------------------------------------------

/** 2 Linear TIME OPERATIONS */
// Operations that are more expensive on List include.
val numS1 = (1 to 10). toList
numS1.last
numS1.init
numS1.length
numS1.reverse

/**
These are all linear time, each must traverse the entire list.
init make a copy of the entire List minus the final element.
Operations like such on lists are sub-optimal.
O (N/2) notation = Linear time complexity*/
